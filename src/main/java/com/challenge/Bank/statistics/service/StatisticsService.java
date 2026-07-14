package com.challenge.Bank.statistics.service;

import com.challenge.Bank.statistics.DTO.StatisticsResponseDTO;
import com.challenge.Bank.transactions.DTO.TransactionResponseDTO;
import com.challenge.Bank.transactions.service.TransactionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Optional;
import java.util.UUID;

@Service
public class StatisticsService {

    private  static final Logger log = LoggerFactory.getLogger(StatisticsService.class);
    private final TransactionService transactionService;

    public StatisticsService(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    public Optional<StatisticsResponseDTO> calcularStatistics(UUID AccountId, Integer TimeSearch) {
        log.info("Extract Statistics");

        long start = System.currentTimeMillis();

        var transactions = transactionService.getTransactionByTime(AccountId, TimeSearch);

        if (transactions.isEmpty()) {
            return Optional.empty();
        }

        long count = transactions.size();

        BigDecimal sum = transactions.stream()
                .map(TransactionResponseDTO::amount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        BigDecimal avg = sum.divide(BigDecimal.valueOf(count), 2, RoundingMode.HALF_UP);

        BigDecimal min = transactions.stream()
                .map(TransactionResponseDTO::amount)
                .min(BigDecimal::compareTo)
                .orElse(BigDecimal.ZERO);

        BigDecimal max = transactions.stream()
                .map(TransactionResponseDTO::amount)
                .max(BigDecimal::compareTo)
                .orElse(BigDecimal.ZERO);


        long end = System.currentTimeMillis();
        long timeRequest = end - start;
        log.info("Extract Statistics Time: {}", timeRequest);

        return Optional.of(new StatisticsResponseDTO(count, sum, avg, min, max));
    }

}
