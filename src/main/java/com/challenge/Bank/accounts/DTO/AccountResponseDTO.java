package com.challenge.Bank.accounts.DTO;

import com.challenge.Bank.Enums.AccountStatus;
import com.challenge.Bank.Enums.AccountType;

import java.math.BigDecimal;
import java.util.UUID;

public record AccountResponseDTO(
        UUID uuid,
        UUID clientUuid,
        BigDecimal balance,
        AccountType type,
        BigDecimal overdraftLimit,
        AccountStatus status
) {}