package com.challenge.Bank.config;

import com.challenge.Bank.repository.AccountRepositoryInMemory;
import com.challenge.Bank.repository.ClientRepositoryInMemory;
import com.challenge.Bank.repository.TransactionRepositoryInMemory;
import com.challenge.Bank.repository.TransactionRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RepositoryConfig {

    @Bean
    public TransactionRepository transactionRepository() {
        return new TransactionRepositoryInMemory();
    }

    @Bean
    public ClientRepositoryInMemory clientRepository() {
        return new ClientRepositoryInMemory();
    }

    @Bean
    public AccountRepositoryInMemory  accountRepository() {
        return new AccountRepositoryInMemory();
    }

}
