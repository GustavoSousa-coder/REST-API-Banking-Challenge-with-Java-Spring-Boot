package com.challenge.Bank.repository;

import com.challenge.Bank.model.Transaction;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class RepositoryInMemory implements TransactionRepository {

    private final Map<Long, Transaction> map = new ConcurrentHashMap<>();
    private final AtomicLong sequence = new AtomicLong(1);

    @Override
    public List<Transaction> findAll(Integer timeSearch) {
        return new ArrayList<>(map.values());
    }

    @Override
    public Transaction save(Transaction transaction) {
        if (transaction.getId()==null) {
            transaction.setId(sequence.getAndIncrement());
        }

        map.put(transaction.getId(), transaction);
        return transaction;

    }

    @Override
    public void delete(Long id) {
        map.remove(id);
    }

}
