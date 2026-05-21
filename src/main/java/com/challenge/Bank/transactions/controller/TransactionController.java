package com.challenge.Bank.transactions.controller;

import com.challenge.Bank.transactions.DTO.TransactionRequestDTO;
import com.challenge.Bank.transactions.DTO.TransactionResponseDTO;
import com.challenge.Bank.transactions.service.TransactionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/transacao")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping(
            value = "/{accountId}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<TransactionResponseDTO> transfer(@PathVariable UUID accountId, @RequestBody TransactionRequestDTO transactionRequestDTO) {
        var saved = transactionService.transfer(accountId, transactionRequestDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

}
