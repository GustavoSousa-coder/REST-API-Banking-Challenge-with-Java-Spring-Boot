package com.challenge.Bank.onboarding.DTO;

import com.challenge.Bank.Enums.AccountType;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDate;

public record OnboardingRequestDTO(
        String name,
        String cpf,
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
        LocalDate dateOfBirth,
        String email,
        String password,
        AccountType type
) {}
