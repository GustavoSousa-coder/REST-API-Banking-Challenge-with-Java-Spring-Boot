package com.challenge.Bank.repository;

import com.challenge.Bank.model.Client;

import java.util.List;

public interface ClientRepository {

    List<Client> findAll();

    Client findById(Long id);

    Client save(Client client);

}
