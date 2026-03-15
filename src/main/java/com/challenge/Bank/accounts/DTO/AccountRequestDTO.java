package com.challenge.Bank.accounts.DTO;

import com.challenge.Bank.Enums.AccountType;
import java.util.UUID;

public record AccountRequestDTO(
        AccountType type
) {}