package com.challenge.Bank.repository;

import com.challenge.Bank.model.Client;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class ClientRepositoryInMemory implements ClientRepository {

    private final Map<Long, Client> map = new ConcurrentHashMap<>();
    private final AtomicLong sequence = new AtomicLong(1);

    @Override
    public List<Client> findAll() {
        return new ArrayList<>((map.values()));
    }

    @Override
    public Client findById(Long id) {
        return map.get(id);
    }

    @Override
    public Client save(Client client) {
        if (client.getId() == null) {
            client.setId(sequence.getAndIncrement());
        }
        map.put(client.getId(), client);
        return client;
    }

}
