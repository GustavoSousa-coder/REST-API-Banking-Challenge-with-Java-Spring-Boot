package com.challenge.Bank.repository;

import com.challenge.Bank.model.Transaction;

import java.util.List;

public interface TransactionRepository {

    List<Transaction> findAll(Integer timeSearch);

    Transaction save(Transaction transaction);

    void delete(Long id);

}
