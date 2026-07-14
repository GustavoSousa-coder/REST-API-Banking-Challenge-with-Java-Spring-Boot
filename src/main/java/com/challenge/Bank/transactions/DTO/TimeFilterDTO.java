package com.challenge.Bank.transactions.DTO;

import com.challenge.Bank.Enums.TimeUnitType;

import java.time.ZoneId;

public record TimeFilterDTO(
        TimeUnitType type,
        long amount,
        ZoneId zone,
        String dateIso
) {
}
