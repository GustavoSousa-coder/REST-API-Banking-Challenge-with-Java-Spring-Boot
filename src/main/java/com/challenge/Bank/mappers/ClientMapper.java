package com.challenge.Bank.mappers;

import com.challenge.Bank.DTO.request.ClientRequestDTO;
import com.challenge.Bank.DTO.response.ClientResponseDTO;
import com.challenge.Bank.model.Client;
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
        dto.setId(client.getId());
        dto.setName(client.getName());
        dto.setDateOfBirth(client.getDateOfBirth());
        dto.setEmail(client.getEmail());
        dto.setAccountStatus(client.getAccountStatus());
        return dto;
    }

}
