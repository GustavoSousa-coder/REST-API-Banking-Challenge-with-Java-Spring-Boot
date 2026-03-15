package com.challenge.Bank.addressKey.DTO;

import com.challenge.Bank.Enums.KeyType;

import java.util.Objects;
import java.util.UUID;

public record AddressKeyRequestDTO(
            KeyType keyType,
            String keyValue,
            UUID accountId
) {}
