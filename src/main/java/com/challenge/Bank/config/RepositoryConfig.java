package com.challenge.Bank.config;

import com.challenge.Bank.repository.ClientRepositoryInMemory;
import com.challenge.Bank.repository.RepositoryInMemory;
import com.challenge.Bank.repository.TransactionRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RepositoryConfig {

    @Bean
    public TransactionRepository transactionRepository() {
        return new RepositoryInMemory();
    }

    @Bean
    public ClientRepositoryInMemory clientRepository() {
        return new ClientRepositoryInMemory();
    }

}
