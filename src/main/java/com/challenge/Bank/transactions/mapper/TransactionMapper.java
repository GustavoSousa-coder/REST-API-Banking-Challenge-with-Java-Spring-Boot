package com.challenge.Bank.transactions.mapper;

import com.challenge.Bank.transactions.DTO.TransactionRequestDTO;
import com.challenge.Bank.transactions.DTO.TransactionResponseDTO;
import com.challenge.Bank.transactions.model.Transaction;
import org.springframework.stereotype.Component;

@Component
public class TransactionMapper {

    public Transaction toEntity(TransactionRequestDTO dto) {
        return Transaction.builder()
                .amount(dto.amount())
                .build();
    }

    public TransactionResponseDTO toDTO(Transaction transaction) {
        return new TransactionResponseDTO(
                transaction.getUuid(),
                transaction.getAmount(),
                transaction.getDataHora()
        );
    }

}
