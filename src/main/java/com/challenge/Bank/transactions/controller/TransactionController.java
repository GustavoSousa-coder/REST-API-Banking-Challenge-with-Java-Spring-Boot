package com.challenge.Bank.transactions.controller;

import com.challenge.Bank.accounts.model.Account;
import com.challenge.Bank.transactions.DTO.TransactionRequestDTO;
import com.challenge.Bank.transactions.DTO.TransactionResponseDTO;
import com.challenge.Bank.transactions.service.TransactionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
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
    public ResponseEntity<TransactionResponseDTO> save(@PathVariable UUID accountId, @RequestBody TransactionRequestDTO transactionRequestDTO) {
        var saved = transactionService.save(accountId, transactionRequestDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

}
