package com.challenge.Bank.repository;

import com.challenge.Bank.model.Account;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

public class AccountRepositoryInMemory implements AccountRepository {

    private final Map<Long, Account> map = new ConcurrentHashMap<>();
    private final AtomicLong sequence = new AtomicLong(1);

    @Override
    public List<Account> findAllByClientId(Long clientId) {
        return map.values().stream()
                .filter(account -> account.getClientId().equals(clientId))
                .collect(Collectors.toList());
    }

    @Override
    public Account findById(Long id) {
        return map.get(id);
    }

    @Override
    public Account save(Account account) {
        if(account.getId() == null) {
            account.setId(sequence.getAndIncrement());
        }
        map.put(account.getId(), account);
        return account;
    }

    @Override
    public void delete(Long id) {
        map.remove(id);
    }

}
