package com.challenge.Bank.accounts.DTO;

import com.challenge.Bank.Enums.AccountType;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record AccountRequestDTO(

        @NotNull(message = "Tipo de conta é obrigatório")
        AccountType type
) {}