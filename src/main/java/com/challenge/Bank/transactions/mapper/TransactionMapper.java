package com.challenge.Bank.transactions.mapper;

import com.challenge.Bank.transactions.DTO.TransactionRequestDTO;
import com.challenge.Bank.transactions.DTO.TransactionResponseDTO;
import com.challenge.Bank.transactions.model.Transaction;
import org.springframework.stereotype.Component;

@Component
public class TransactionMapper {

    public Transaction toEntity(TransactionRequestDTO dto) {
        Transaction transaction = new Transaction();
        transaction.setAmount(dto.getAmount());
        return transaction;
    }

    public TransactionResponseDTO toDTO(Transaction transaction) {
        TransactionResponseDTO dto = new TransactionResponseDTO();
        dto.setUuid(transaction.getUuid());
        dto.setAmount(transaction.getAmount());
        dto.setDataHora(transaction.getDataHora());
        return dto;
    }

}
