package com.challenge.Bank.clients.controller;

import com.challenge.Bank.clients.DTO.AuthenticationRequestDTO;
import com.challenge.Bank.clients.DTO.AuthenticationResponseDTO;
import com.challenge.Bank.clients.DTO.ClientResponseDTO;
import com.challenge.Bank.clients.service.AuthenticationService;
import com.challenge.Bank.clients.service.ClientService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponseDTO> login(@RequestBody @Valid AuthenticationRequestDTO dto) {
        var result = authenticationService.login(dto);
        return ResponseEntity.ok(new AuthenticationResponseDTO(result.token(), result.uuid()));
    }

}
