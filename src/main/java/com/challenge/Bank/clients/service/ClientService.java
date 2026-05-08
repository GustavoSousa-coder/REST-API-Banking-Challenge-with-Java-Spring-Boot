package com.challenge.Bank.clients.service;

import com.challenge.Bank.clients.mapper.ClientMapper;
import com.challenge.Bank.clients.repository.ClientRepository;
import com.challenge.Bank.clients.DTO.ClientRequestDTO;
import com.challenge.Bank.clients.DTO.ClientResponseDTO;
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
    private final PasswordEncoder passwordEncoder;

    public ClientService(ClientRepository clientRepository, ClientMapper clientMapper, PasswordEncoder passwordEncoder) {
        this.clientRepository = clientRepository;
        this.clientMapper = clientMapper;
        this.passwordEncoder = passwordEncoder;
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

    public void deactivateUser(UUID uuid) {
        log.info("Entering deactivateUser()");

        var search = clientRepository.findById(uuid)
                .orElseThrow(() -> new UnprocessableEntity("Client with id " + uuid + " not found"));

        if (search.getClientStatus() ==  ClientStatus.INACTIVE) {
            throw new UnprocessableEntity("Client já inativo");
        }

        search.setClientStatus(ClientStatus.INACTIVE);
        clientMapper.toDTO(clientRepository.save(search));

    }

    public ClientResponseDTO save(ClientRequestDTO clientRequestDTO) {
        log.info("Entering save(ClientRequestDTO)");

        validateCpf(clientRequestDTO.cpf());
        validateEmail(clientRequestDTO.email());
        validateAge(clientRequestDTO);

        var encodedPassword = passwordEncoder.encode(clientRequestDTO.password());
        var entity = clientMapper.toEntity(clientRequestDTO, encodedPassword);

        var savedEntity = clientRepository.save(entity);
        return clientMapper.toDTO(savedEntity);
    }

    private void validateCpf(String cpf) {
        log.info("Entering validateCpf()");
        if (clientRepository.findByCpf(cpf).isPresent()) {
            throw new Conflict("Cpf Já existente");
        }
    }

    private void validateEmail(String email) {
        log.info("Entering validateEmail()");
        if (clientRepository.findByEmail(email).isPresent()) {
            throw new Conflict("Email já existente");
        }
    }

    private void validateAge(ClientRequestDTO clientRequestDTO) {
        log.info("Entering validateAge()");
        if (Period.between(clientRequestDTO.dateOfBirth(), LocalDate.now()).getYears() < 18) {
            throw new UnprocessableEntity("Invalid date of birth");
        }
    }

}
