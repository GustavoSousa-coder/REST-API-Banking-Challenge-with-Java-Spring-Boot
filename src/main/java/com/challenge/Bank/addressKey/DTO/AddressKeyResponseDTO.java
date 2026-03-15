package com.challenge.Bank.addressKey.DTO;

import com.challenge.Bank.Enums.KeyType;

public record AddressKeyResponseDTO(
        KeyType keyType,
        String keyValue
) {}
