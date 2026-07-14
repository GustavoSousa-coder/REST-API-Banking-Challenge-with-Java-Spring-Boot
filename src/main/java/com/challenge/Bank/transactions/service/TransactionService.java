package com.challenge.Bank.transactions.service;

import com.challenge.Bank.Enums.AccountStatus;
import com.challenge.Bank.Enums.TransactionMethod;
import com.challenge.Bank.Enums.TransactionStatus;
import com.challenge.Bank.Enums.TransactionType;
import com.challenge.Bank.accounts.model.Account;
import com.challenge.Bank.accounts.repository.AccountRepository;
import com.challenge.Bank.PixKey.model.PixKey;
import com.challenge.Bank.PixKey.repository.PixKeyRepository;
import com.challenge.Bank.card.DTO.CardTransactionRequestDTO;
import com.challenge.Bank.card.repository.CardRepository;
import com.challenge.Bank.card.service.CardService;
import com.challenge.Bank.exceptions.BadRequest;
import com.challenge.Bank.exceptions.NotFound;
import com.challenge.Bank.exceptions.UnprocessableEntity;
import com.challenge.Bank.transactions.DTO.TimeFilterDTO;
import com.challenge.Bank.transactions.mapper.TransactionMapper;
import com.challenge.Bank.transactions.DTO.TransactionRequestDTO;
import com.challenge.Bank.transactions.DTO.TransactionResponseDTO;
import com.challenge.Bank.transactions.model.Transaction;
import com.challenge.Bank.transactions.repository.TransactionRepository;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
public class TransactionService {

    private final Logger log =  LoggerFactory.getLogger(TransactionService.class);

    private final PixKeyRepository pixKeyRepository;
    private final CardRepository cardRepository;
    private final CardService cardService;
    private final TransactionRepository transactionRepository;
    private final AccountRepository accountRepository;
    private final TransactionMapper transactionMapper;

    public TransactionService(PixKeyRepository pixKeyRepository, CardRepository cardRepository, CardService cardService, TransactionRepository transactionRepository, AccountRepository accountRepository, TransactionMapper transactionMapper) {
        this.pixKeyRepository = pixKeyRepository;
        this.cardRepository = cardRepository;
        this.cardService = cardService;
        this.transactionRepository = transactionRepository;
        this.accountRepository = accountRepository;
        this.transactionMapper = transactionMapper;
    }

    @Transactional
    public TransactionResponseDTO transfer(UUID accountId, TransactionRequestDTO dto) {

        log.info("Saving transaction");

        if (dto.amount() == null || dto.amount().compareTo(BigDecimal.ZERO) <= 0) {
            throw new BadRequest("Error relational in value is negative or null");
        }

        Account senderAccount;
        Account receiverAccount;

        switch (dto.method()) {

            case PIX -> {

                senderAccount = accountRepository.findById(accountId)
                        .orElseThrow(() -> new NotFound("Account not found"));

                PixKey key = pixKeyRepository.findByKeyValue(dto.key());

                if (key == null) {
                    throw new NotFound("Pix key not found");
                }

                receiverAccount = key.getAccount();
            }

            case CARD -> {

                senderAccount = cardService.authorize(dto.cardDto());

                PixKey key = pixKeyRepository.findByKeyValue(dto.key());

                if (key == null) {
                    throw new NotFound("Pix key not found");
                }

                receiverAccount = key.getAccount();
            }

            default ->
                    throw new BadRequest("Invalid transaction method.");

        }

        if (senderAccount.getUuid().equals(receiverAccount.getUuid())) {
            throw new UnprocessableEntity("Sender and receiver account cannot be the same.");
        }

        if (senderAccount.getStatus() != AccountStatus.ACTIVE
                || receiverAccount.getStatus() != AccountStatus.ACTIVE) {

            throw new UnprocessableEntity("Inactive account.");
        }

        senderAccount.consumeDailyTransferLimit(dto.amount());

        senderAccount.debit(dto.amount());

        receiverAccount.creditor(dto.amount());

        Transaction transaction = Transaction.builder()
                .transactionType(TransactionType.TRANSFER)
                .method(dto.method())
                .amount(dto.amount())
                .status(TransactionStatus.COMPLETED)
                .senderAccount(senderAccount)
                .receiverAccount(receiverAccount)
                .build();

        accountRepository.save(senderAccount);
        accountRepository.save(receiverAccount);

        Transaction saved = transactionRepository.save(transaction);

        return transactionMapper.toDTO(saved);
    }

    public List<TransactionResponseDTO> getTransactionByTime(UUID accountId, Integer TimeSearch) {
        accountRepository.findById(accountId)
                .orElseThrow(() -> new NotFound("Account not found"));
        log.info("Getting transaction by time");
        OffsetDateTime dataHoraTimeSearch = OffsetDateTime.now().minusSeconds(TimeSearch);
        log.info("return of transaction");

        return transactionRepository.findRecentTransactions(dataHoraTimeSearch)
                .stream()
                .map(transactionMapper::toDTO)
                .toList();
    }

        public List<TransactionResponseDTO> getTransactionByPersonaliseTime (UUID accountId, TimeFilterDTO filter) {
        accountRepository.findById(accountId)
                .orElseThrow(() -> new NotFound("Account not found"));

        log.info("Getting transactions by time: {}", filter);

        ZoneId zone = Optional.ofNullable(filter.zone()).orElse(ZoneId.systemDefault());
        OffsetDateTime from;

        switch (filter.type()) {
            case SECONDS -> from = OffsetDateTime.now().minusSeconds(filter.amount());
            case DAYS -> from = OffsetDateTime.now().minusDays(filter.amount());
            case MONTHS -> from = OffsetDateTime.now().minusMonths(filter.amount());
            case YEARS -> from = OffsetDateTime.now().minusYears(filter.amount());
            case FROM_DATE -> {
                LocalDate localStart;
                try {
                    localStart = LocalDate.parse(filter.dateIso(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                } catch (DateTimeParseException e) {
                    throw new IllegalArgumentException("dateIso inválido, use dd/MM/yyyy", e);
                }
                from = localStart.atStartOfDay(zone).toOffsetDateTime();
            }
            default -> throw new IllegalStateException("Tipo inválido");
        }

        return transactionRepository.findRecentTransactions(from)
                .stream()
                .map(transactionMapper::toDTO)
                .toList();
    }

}
