package com.challenge.Bank.accounts.DTO;

import com.challenge.Bank.Enums.AccountStatus;

import java.math.BigDecimal;
import java.util.UUID;

public record AccountResponseDTO(
        UUID uuid,
        UUID clientUuid,
        BigDecimal balance,
        BigDecimal overdraftLimit,
        AccountStatus status
) {}