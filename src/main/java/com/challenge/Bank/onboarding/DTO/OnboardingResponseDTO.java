package com.challenge.Bank.onboarding.DTO;

import com.challenge.Bank.Enums.AccountStatus;
import com.challenge.Bank.Enums.AccountType;
import com.challenge.Bank.Enums.ClientStatus;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

public record OnboardingResponseDTO(

    UUID ClientUuid,
    String name,
    LocalDate dateOfBirth,
    String email,
    ClientStatus accountStatus,
    UUID AccountUuid,
    BigDecimal balance,
    AccountType type,
    Double overdraftLimit,
    AccountStatus status
) {}
