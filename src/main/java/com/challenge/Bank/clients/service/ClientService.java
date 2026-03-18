package com.challenge.Bank.clients.service;

import com.challenge.Bank.clients.mapper.ClientMapper;
import com.challenge.Bank.clients.repository.ClientRepository;
import com.challenge.Bank.clients.DTO.ClientRequestDTO;
import com.challenge.Bank.clients.DTO.ClientResponseDTO;
import com.challenge.Bank.clients.model.Client;
import com.challenge.Bank.exceptions.Conflict;
import com.challenge.Bank.exceptions.NotFound;
import com.challenge.Bank.exceptions.UnprocessableEntity;
import com.challenge.Bank.Enums.ClientStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.UUID;

@Service
public class ClientService {

    private final Logger log =  LoggerFactory.getLogger(ClientService.class);
    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;

    public ClientService(ClientRepository clientRepository, ClientMapper clientMapper) {
        this.clientRepository = clientRepository;
        this.clientMapper = clientMapper;
    }

    public List<ClientResponseDTO> findAll() {
        log.info("Entering findAll()");

        return clientRepository.findAll()
                .stream()
                .map(clientMapper::toDTO)
                .toList();
    }

    public ClientResponseDTO findById(UUID uuid) {
        log.info("Entering findById(id)");

        return clientRepository.findById(uuid)
                .map(clientMapper::toDTO)
                .orElseThrow(() -> new NotFound("Client with id " + uuid + " not found"));
    }

    public ClientResponseDTO save(ClientRequestDTO clientRequestDTO) {
        log.info("Entering save(ClientRequestDTO)");

        if (Period.between(clientRequestDTO.dateOfBirth(), LocalDate.now()).getYears() < 18) {
            throw new UnprocessableEntity("Invalid date of birth");
        }
        validateCpf(clientRequestDTO.cpf());

        var entity = clientMapper.toEntity(clientRequestDTO);
        var savedEntity = clientRepository.save(entity);
        return clientMapper.toDTO(savedEntity);
    }

    public void deactivateUser(UUID uuid) {
        log.info("Entering deactivateUser()");

        var search = clientRepository.findById(uuid)
                .orElseThrow(() -> new UnprocessableEntity("Client with id " + uuid + " not found"));

        if (search.getClientStatus() ==  ClientStatus.Inactive) {
            throw new UnprocessableEntity("Client já inativo");
        }

        search.setClientStatus(ClientStatus.Inactive);
        clientMapper.toDTO(clientRepository.save(search));

    }

    public void validateCpf(String cpf) {
        log.info("Entering validateCpf()");
        if (clientRepository.findByCpf(cpf).isPresent()) {
            throw new Conflict("Cpf Já existente");
        }
    }

}
