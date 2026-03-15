package com.challenge.Bank.clients.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public record ClientRequestDTO(
        String name,
        String cpf,
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
        LocalDate dateOfBirth,
        String email,
        String password
) {}