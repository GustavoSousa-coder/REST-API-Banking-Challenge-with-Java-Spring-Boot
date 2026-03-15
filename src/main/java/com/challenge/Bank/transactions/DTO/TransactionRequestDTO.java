package com.challenge.Bank.transactions.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;
import java.util.Objects;

public record TransactionRequestDTO(
        @NotNull
        @Positive
        BigDecimal amount,
        @NotBlank
        String key
) {}

