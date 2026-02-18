package com.challenge.Bank.statistics.service;

import com.challenge.Bank.statistics.DTO.StatisticsResponseDTO;
import com.challenge.Bank.transactions.service.TransactionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.DoubleSummaryStatistics;

@Service
public class StatisticsService {

    private  static final Logger log = LoggerFactory.getLogger(StatisticsService.class);
    private final TransactionService transactionService;

    public StatisticsService(TransactionService transactionService) {
        this.transactionService = transactionService;
    }



    public StatisticsResponseDTO calcularStatistics(Integer TimeSearch) {
        log.info("Extract Statistics");

        long start = System.currentTimeMillis();

        var transactions = transactionService.getTransactionByTime(TimeSearch);

        if (transactions.isEmpty()) {
            return new StatisticsResponseDTO();
        }

        DoubleSummaryStatistics statisticsTransactions = transactions.stream()
                .mapToDouble(t -> t.getAmount().doubleValue()).summaryStatistics();

        long end = System.currentTimeMillis();
        long timeRequest = end - start;
        log.info("Extract Statistics Time: {}", timeRequest);


        return new StatisticsResponseDTO(
                statisticsTransactions.getCount(),
                statisticsTransactions.getSum(),
                statisticsTransactions.getAverage(),
                statisticsTransactions.getMin(),
                statisticsTransactions.getMax());
    }

}
