package com.challenge.Bank.card.controller;

import com.challenge.Bank.card.DTO.CardResponseDTO;
import com.challenge.Bank.card.service.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/card")
@RequiredArgsConstructor
public class CardController {

    private final CardService cardService;

    @PostMapping("/{accountId}")
    public ResponseEntity<CardResponseDTO> create(@PathVariable UUID accountId) {
        return ResponseEntity.ok(cardService.create(accountId));
    }

}
