package com.challenge.Bank.clients.controller;

import com.challenge.Bank.clients.DTO.ClientRequestDTO;
import com.challenge.Bank.clients.DTO.ClientResponseDTO;
import com.challenge.Bank.clients.service.ClientService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/client")
public class ClientController {

    private final ClientService clientService;
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ClientResponseDTO>> findAll() {
        return ResponseEntity.ok(clientService.findAll());
    }

    @GetMapping(value = "/{uuid}",  produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ClientResponseDTO> findById(@PathVariable UUID uuid) {
        return ResponseEntity.ok(clientService.findById(uuid));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ClientResponseDTO save(@RequestBody @Valid ClientRequestDTO clientRequestDTO) {
        return clientService.save(clientRequestDTO);
    }

    @DeleteMapping(value = "/{uuid}")
    public ResponseEntity<Void> deactivateUser(@PathVariable UUID uuid) {
        clientService.deactivateUser(uuid);
        return ResponseEntity.ok().build();
    }

}
