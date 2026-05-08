package com.challenge.Bank.clients.DTO;

public record AuthenticationRequestDTO(
        String login,
        String password
) {
}
