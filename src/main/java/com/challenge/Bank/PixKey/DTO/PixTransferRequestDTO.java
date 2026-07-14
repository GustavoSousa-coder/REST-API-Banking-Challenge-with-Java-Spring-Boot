package com.challenge.Bank.PixKey.DTO;

import com.challenge.Bank.Enums.KeyType;

import java.util.UUID;

public record PixTransferRequestDTO(
            KeyType keyType,
            String keyValue,
            UUID accountId
) {}
