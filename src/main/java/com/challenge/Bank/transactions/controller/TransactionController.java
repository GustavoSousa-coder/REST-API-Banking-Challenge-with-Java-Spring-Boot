package com.challenge.Bank.transactions.controller;

import com.challenge.Bank.transactions.DTO.TimeFilterDTO;
import com.challenge.Bank.transactions.DTO.TransactionRequestDTO;
import com.challenge.Bank.transactions.DTO.TransactionResponseDTO;
import com.challenge.Bank.transactions.controller.doc.TransactionControllerDoc;
import com.challenge.Bank.transactions.service.TransactionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/transacao")
public class TransactionController implements TransactionControllerDoc {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping(
            value = "/{accountId}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Override
    public ResponseEntity<TransactionResponseDTO> transfer(@PathVariable UUID accountId, @RequestBody TransactionRequestDTO transactionRequestDTO) {
        var saved = transactionService.transfer(accountId, transactionRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @GetMapping(
            value = "/{accountId}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Override
    public ResponseEntity<List<TransactionResponseDTO>> getTransactions(@PathVariable UUID accountId, @RequestParam Integer TimeSearch) {
        var transactions = transactionService.getTransactionByTime(accountId, TimeSearch);
        return ResponseEntity.ok(transactions);
    }

    @GetMapping(
            value = "/{accountId}/personalise",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Override
    public ResponseEntity<List<TransactionResponseDTO>> getTransactionByPersonaliseTime(@PathVariable UUID accountId, @RequestBody TimeFilterDTO filter) {
        var transaction = transactionService.getTransactionByPersonaliseTime(accountId, filter);
        return ResponseEntity.ok(transaction);
    }

}
