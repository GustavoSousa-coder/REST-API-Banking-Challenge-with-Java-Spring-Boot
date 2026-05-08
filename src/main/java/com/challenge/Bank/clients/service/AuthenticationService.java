package com.challenge.Bank.clients.service;

import com.challenge.Bank.clients.DTO.AuthenticationRequestDTO;
import com.challenge.Bank.clients.model.Client;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;

    public AuthenticationService(AuthenticationManager authenticationManager, TokenService tokenService) {
        this.authenticationManager = authenticationManager;
        this.tokenService = tokenService;
    }

    public String login(AuthenticationRequestDTO dto) {
        var userNamePassword = new UsernamePasswordAuthenticationToken(dto.login(), dto.password());
        var auth = authenticationManager.authenticate(userNamePassword);
        return tokenService.generateToken((Client) auth.getPrincipal());
    }

}
