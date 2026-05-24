package com.challenge.Bank.transactions.service;

import com.challenge.Bank.Enums.AccountStatus;
import com.challenge.Bank.Enums.AccountType;
import com.challenge.Bank.Enums.TransactionStatus;
import com.challenge.Bank.Enums.TransactionType;
import com.challenge.Bank.accounts.model.Account;
import com.challenge.Bank.accounts.repository.AccountRepository;
import com.challenge.Bank.addressKey.model.AddressKey;
import com.challenge.Bank.addressKey.repository.AddressKeyRepository;
import com.challenge.Bank.exceptions.BadRequest;
import com.challenge.Bank.exceptions.NotFound;
import com.challenge.Bank.exceptions.UnprocessableEntity;
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
import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;


@Service
public class TransactionService {

    private final Logger log =  LoggerFactory.getLogger(TransactionService.class);

    private final AddressKeyRepository addressKeyRepository;
    private final TransactionRepository transactionRepository;
    private final AccountRepository accountRepository;
    private final TransactionMapper transactionMapper;

    public TransactionService(AddressKeyRepository addressKeyRepository, TransactionRepository transactionRepository, AccountRepository accountRepository, TransactionMapper transactionMapper) {
        this.addressKeyRepository = addressKeyRepository;
        this.transactionRepository = transactionRepository;
        this.accountRepository = accountRepository;
        this.transactionMapper = transactionMapper;
    }

    @Transactional
    public TransactionResponseDTO transfer(UUID accountId, TransactionRequestDTO dto) {
        log.info("Saving transaction");

        var valor = dto.amount();
        if (valor == null || valor.compareTo(BigDecimal.ZERO) <= 0) {
            throw new BadRequest("Error relational in value is negative");
        }

        var senderAccount = accountRepository.findById(accountId)
                .orElseThrow(() -> new NotFound("Account not found"));

        AddressKey key = addressKeyRepository.findByKeyValue(dto.key());
        if (key == null) {
            throw  new NotFound("Address key not found");
        }

        Account receiver = key.getAccount();
        if (senderAccount.getUuid().equals(receiver.getUuid())) {
            throw new UnprocessableEntity("Error relational in sender account");
        }

        if (senderAccount.getStatus() != AccountStatus.ACTIVE || receiver.getStatus() != AccountStatus.ACTIVE) {
            throw new UnprocessableEntity("Error relational in account not active");
        }

        if (senderAccount.getType() == AccountType.CORRENTE) {
            senderAccount.executeWithdrawalCorrente(valor);
            senderAccount.debit(valor);
        } else {
            senderAccount.executeWithdrawalPoupanca();
            senderAccount.debit(valor);
        }

        receiver.creditor(valor);

        Transaction transaction = Transaction.builder()
                .transactionType(TransactionType.TRANSFER)
                .amount(dto.amount())
                .status(TransactionStatus.COMPLETED)
                .senderAccount(senderAccount)
                .receiverAccount(receiver)
                .build();

        accountRepository.save(senderAccount);
        accountRepository.save(receiver);
        var saved = transactionRepository.save(transaction);
        return transactionMapper.toDTO(saved);
    }

    public List<TransactionResponseDTO> getTransactionByTime(Integer TimeSearch) {
        log.info("Getting transaction by time");
        OffsetDateTime dataHoraTimeSearch = OffsetDateTime.now().minusSeconds(TimeSearch);
        log.info("return of transaction");

        return transactionRepository.findRecentTransactions(dataHoraTimeSearch)
                .stream()
                .map(transactionMapper::toDTO)
                .toList();
    }

}
