package com.challenge.Bank.addressKey.controller;

import com.challenge.Bank.addressKey.DTO.AddressKeyRequestDTO;
import com.challenge.Bank.addressKey.service.AddressKeyService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/addressKey")
public class AddressKeyController {

    private final AddressKeyService addressKeyService;

    public AddressKeyController(AddressKeyService addressKeyService) {
        this.addressKeyService = addressKeyService;
    }

    @PostMapping(
            value = "/{accountId}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Object> registerAddressKey(@RequestBody AddressKeyRequestDTO addressKeyRequestDTO, @PathVariable UUID accountId) {
        return ResponseEntity.ok().body(addressKeyService.registerAddressKey(addressKeyRequestDTO, accountId));
    }
}
