package com.challenge.Bank.repository;

import com.challenge.Bank.model.Account;

import java.util.List;

public interface AccountRepository {

    List<Account> findAllByClientId(Long clientId);

    Account findById(Long id);

    Account save(Account account);

    void delete(Long id);

}
