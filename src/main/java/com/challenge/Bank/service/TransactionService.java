package com.challenge.Bank.service;

import com.challenge.Bank.DTO.request.TransactionRequestDTO;
import com.challenge.Bank.DTO.response.TransactionResponseDTO;
import com.challenge.Bank.exceptions.BadRequest;
import com.challenge.Bank.exceptions.UnprocessableEntity;
import com.challenge.Bank.mappers.TransactionMapper;
import com.challenge.Bank.model.Transaction;
import com.challenge.Bank.repository.TransactionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.List;

import static java.time.OffsetDateTime.now;

@Service
public class TransactionService {

    private final Logger log =  LoggerFactory.getLogger(TransactionService.class);

    private final TransactionRepository transactionRepository;
    private final TransactionMapper  transactionMapper;

    public TransactionService(TransactionRepository transactionRepository, TransactionMapper transactionMapper) {
        this.transactionRepository = transactionRepository;
        this.transactionMapper = transactionMapper;
    }

    public TransactionResponseDTO save(TransactionRequestDTO transactionRequestDTO) {
        log.info("Saving transaction");

        TransactionResponseDTO transactionResponseDTO = new TransactionResponseDTO();
        var dataHora = transactionResponseDTO.getDataHora();

        var valor = transactionRequestDTO.getValor();

        if (dataHora.isAfter(now())) { throw new UnprocessableEntity("Error relational in dataHora"); }
        if (valor == null || valor.compareTo(BigDecimal.ZERO) < 0) { throw new BadRequest("Error relational in value is negative"); }

        var entity = transactionMapper.toEntity(transactionRequestDTO);
        var saved = transactionRepository.save(entity);

        return transactionMapper.toDTO(saved);
    }

    public void delete(Long id) {
        log.info("Deleting transaction");
        transactionRepository.delete(id);
    }

    public List<Transaction> getTransactionByTime(Integer TimeSearch) {
        log.info("Getting transaction by time");

        OffsetDateTime dataHoraTimeSearch = OffsetDateTime.now().minusSeconds(TimeSearch);

        log.info("return of transaction");
        return transactionRepository.findAll(TimeSearch)
                .stream().filter(transactionDTO -> transactionDTO.getDataHora()
                        .isAfter(dataHoraTimeSearch)).toList();

    }

}
