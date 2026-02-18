package com.challenge.Bank.clients.mapper;

import com.challenge.Bank.clients.DTO.ClientRequestDTO;
import com.challenge.Bank.clients.DTO.ClientResponseDTO;
import com.challenge.Bank.clients.model.Client;
import org.springframework.stereotype.Component;

@Component
public class ClientMapper {

    public Client toEntity(ClientRequestDTO dto) {
        Client client = new Client();
        client.setName(dto.getName());
        client.setCpf(dto.getCpf());
        client.setDateOfBirth(dto.getDateOfBirth());
        client.setEmail(dto.getEmail());
        client.setPassword(dto.getPassword());
        return client;
    }

    public ClientResponseDTO toDTO(Client client) {
        ClientResponseDTO dto = new ClientResponseDTO();
        dto.setUuid(client.getUuid());
        dto.setName(client.getName());
        dto.setDateOfBirth(client.getDateOfBirth());
        dto.setEmail(client.getEmail());
        dto.setAccountStatus(client.getAccountStatus());
        return dto;
    }

}
