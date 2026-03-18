package com.challenge.Bank.clients.mapper;

import com.challenge.Bank.clients.DTO.ClientRequestDTO;
import com.challenge.Bank.clients.DTO.ClientResponseDTO;
import com.challenge.Bank.clients.model.Client;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ClientMapper {

    private final PasswordEncoder passwordEncoder;

    public Client toEntity(ClientRequestDTO dto) {
        return Client.builder()
                .name(dto.name())
                .cpf(dto.cpf())
                .dateOfBirth(dto.dateOfBirth())
                .email(dto.email())
                .password(passwordEncoder.encode(dto.password()))
                .build();
    }

    public ClientResponseDTO toDTO(Client client) {
        return new  ClientResponseDTO(
                client.getUuid(),
                client.getName(),
                client.getDateOfBirth(),
                client.getEmail(),
                client.getClientStatus()
        );
    }

}
