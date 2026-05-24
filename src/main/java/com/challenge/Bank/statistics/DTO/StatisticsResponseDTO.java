package com.challenge.Bank.statistics.DTO;

import java.math.BigDecimal;

public record StatisticsResponseDTO(
     Long count,
     BigDecimal sum,
     BigDecimal avg,
     BigDecimal min,
     BigDecimal max
) {
}
