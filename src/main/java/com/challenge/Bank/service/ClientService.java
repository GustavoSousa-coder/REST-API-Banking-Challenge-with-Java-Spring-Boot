package com.challenge.Bank.service;

import com.challenge.Bank.DTO.request.ClientRequestDTO;
import com.challenge.Bank.DTO.response.ClientResponseDTO;
import com.challenge.Bank.exceptions.UnprocessableEntity;
import com.challenge.Bank.mappers.ClientMapper;
import com.challenge.Bank.model.Client;
import com.challenge.Bank.model.status.Status;
import com.challenge.Bank.repository.ClientRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

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
        List<Client> clients = clientRepository.findAll();
        return clients.stream().map(clientMapper::toDTO).toList();
    }

    public ClientResponseDTO findById(Long id) {
        log.info("Entering findById(id)");
        var entity = clientRepository.findById(id);
        return clientMapper.toDTO(entity);
    }

    public ClientResponseDTO save(ClientRequestDTO clientRequestDTO) {
        log.info("Entering save(ClientRequestDTO)");
        var entity = clientMapper.toEntity(clientRequestDTO);
        var savedEntity = clientRepository.save(entity);
        return clientMapper.toDTO(savedEntity);
    }

    public void deactivateUser(Long id) {
        log.info("Entering deactivateUser()");
        var search = clientRepository.findById(id);

        if (search.getAccountStatus() ==  Status.Inactive) {
            throw new UnprocessableEntity("Client já inativo");
        }

        search.setAccountStatus(Status.Inactive);
        clientRepository.save(search);
        clientMapper.toDTO(search);

    }

}
