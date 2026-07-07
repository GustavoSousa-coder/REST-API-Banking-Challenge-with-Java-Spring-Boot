package com.challenge.Bank.clients.DTO;

import java.util.UUID;

public record AuthenticationResponseDTO(
        String token,
        UUID uuid
) {
}
