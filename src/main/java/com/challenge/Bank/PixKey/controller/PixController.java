package com.challenge.Bank.PixKey.controller;

import com.challenge.Bank.PixKey.DTO.PixTransferRequestDTO;
import com.challenge.Bank.PixKey.controller.doc.PixControllerDoc;
import com.challenge.Bank.PixKey.service.PixService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/pix")
public class PixController implements PixControllerDoc {

    private final PixService pixService;

    public PixController(PixService pixService) {
        this.pixService = pixService;
    }


    @PostMapping(
            value = "/{accountId}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Override
    public ResponseEntity<Object> registerAddressKey(@RequestBody PixTransferRequestDTO pixTransferRequestDTO, @PathVariable UUID accountId) {
        return ResponseEntity.ok().body(pixService.registerAddressKey(pixTransferRequestDTO, accountId));
    }
}
