package com.challenge.Bank.card.service;

import com.challenge.Bank.Enums.CardStatus;
import com.challenge.Bank.accounts.model.Account;
import com.challenge.Bank.accounts.repository.AccountRepository;
import com.challenge.Bank.card.DTO.CardResponseDTO;
import com.challenge.Bank.card.DTO.CardTransactionRequestDTO;
import com.challenge.Bank.card.mapper.CardMapper;
import com.challenge.Bank.card.model.Card;
import com.challenge.Bank.card.repository.CardRepository;
import com.challenge.Bank.exceptions.NotFound;
import com.challenge.Bank.exceptions.UnprocessableEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.YearMonth;
import java.util.Random;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class CardService {

    private final CardRepository cardRepository;
    private final AccountRepository accountRepository;
    private final CardMapper cardMapper;

    @Transactional
    public CardResponseDTO create(UUID accountId) {
        log.info("Creating virtual card");
        Account account = accountRepository.findById(accountId)
                .orElseThrow(() -> new NotFound("Account not found"));
        if (cardRepository.existsByAccount(account)) {
            throw new UnprocessableEntity("Account already has a card");
        }
        Card card = Card.builder()
                .cardNumber(generateUniqueCardNumber())
                .cvv(generateCVV())
                .holderName(account.getClient().getName())
                .expirationDate(YearMonth.now().plusYears(5))
                .status(CardStatus.ACTIVE)
                .createdAt(OffsetDateTime.now())
                .account(account)
                .build();
        Card saved = cardRepository.save(card);
        return cardMapper.toDTO(saved);
    }

    private String generateUniqueCardNumber() {
        String number;
        do {
            number = generateCardNumber();
        } while (cardRepository.existsByCardNumber(number));
        return number;
    }

    private String generateCardNumber() {
        Random random = new Random();
        StringBuilder builder = new StringBuilder("5276");
        while (builder.length() < 16) {
            builder.append(random.nextInt(10));
        }
        return builder.toString();
    }

    private String generateCVV() {
        Random random = new Random();
        return String.format("%03d", random.nextInt(1000));
    }

    public Account authorize(CardTransactionRequestDTO dto) {

        Card card = cardRepository.findByCardNumber(dto.cardNumber())
                .orElseThrow(() -> new NotFound("Card not found"));

        if (card.getStatus() != CardStatus.ACTIVE) {
            throw new UnprocessableEntity("Card is not active.");
        }

        if (!card.getCvv().equals(dto.cvv())) {
            throw new UnprocessableEntity("Invalid CVV.");
        }

        if (card.getExpirationDate().isBefore(YearMonth.from(OffsetDateTime.now().toLocalDate()))) {

            throw new UnprocessableEntity("Invalid expiration date.");
        }

        LocalDate today = LocalDate.now();

        return card.getAccount();
    }

}
