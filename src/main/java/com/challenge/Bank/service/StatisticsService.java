package com.challenge.Bank.service;

import com.challenge.Bank.DTO.response.StatisticsResponseDTO;
import com.challenge.Bank.DTO.response.TransactionResponseDTO;
import com.challenge.Bank.model.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

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
                .mapToDouble(Transaction::getValor).summaryStatistics();

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
