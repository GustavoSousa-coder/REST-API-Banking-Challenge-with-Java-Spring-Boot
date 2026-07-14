package com.challenge.Bank.transactions.DTO;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

public record TransactionResponseDTO(
        BigDecimal amount,
        OffsetDateTime dataHora
) {
}