package com.challenge.Bank.clients.DTO;

import com.challenge.Bank.Enums.ClientStatus;

import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

public record ClientResponseDTO(
        UUID uuid,
        String name,
        LocalDate dateOfBirth,
        String email,
        ClientStatus clientStatus
) {}