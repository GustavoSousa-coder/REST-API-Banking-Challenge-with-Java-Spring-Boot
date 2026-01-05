package com.challenge.Bank.mappers;

import com.challenge.Bank.DTO.request.TransactionRequestDTO;
import com.challenge.Bank.DTO.response.TransactionResponseDTO;
import com.challenge.Bank.model.Transaction;
import org.springframework.stereotype.Component;

@Component
public class TransactionMapper {

    public Transaction toEntity(TransactionRequestDTO dto) {
        Transaction transaction = new Transaction();
        transaction.setValor(dto.getValor());
        return transaction;
    }

    public TransactionResponseDTO toDTO(Transaction transaction) {
        TransactionResponseDTO dto = new TransactionResponseDTO();
        dto.setId(transaction.getId());
        dto.setValor(transaction.getValor());
        dto.setDataHora(transaction.getDataHora());
        return dto;
    }

}
