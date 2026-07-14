package com.challenge.Bank.card.DTO;

import com.challenge.Bank.Enums.CardStatus;

import java.time.OffsetDateTime;
import java.time.YearMonth;
import java.util.UUID;
public record CardResponseDTO(

        UUID uuid,

        String cardNumber,

        String holderName,

        YearMonth expirationDate,

        CardStatus status,

        OffsetDateTime createdAt

) {
}