package com.challenge.Bank.card.DTO;

public record CardTransactionRequestDTO(
        String cardNumber,
        String cvv
) {
}

