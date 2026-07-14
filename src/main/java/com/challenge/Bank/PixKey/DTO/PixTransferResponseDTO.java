package com.challenge.Bank.PixKey.DTO;

import com.challenge.Bank.Enums.KeyType;

public record PixTransferResponseDTO(
        KeyType keyType,
        String keyValue
) {}
