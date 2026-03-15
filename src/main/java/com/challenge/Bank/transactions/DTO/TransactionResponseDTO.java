package com.challenge.Bank.transactions.DTO;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;


public record TransactionResponseDTO(
        UUID uuid,
        BigDecimal amount,
        OffsetDateTime dataHora
) {
    public TransactionResponseDTO {
        dataHora = OffsetDateTime.now();
    }
}
