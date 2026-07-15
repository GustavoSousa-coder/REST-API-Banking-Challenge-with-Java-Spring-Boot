package com.challenge.Bank.accounts.mapper;

import com.challenge.Bank.accounts.DTO.AccountResponseDTO;
import com.challenge.Bank.accounts.model.Account;
import com.challenge.Bank.clients.model.Client;
import org.springframework.stereotype.Component;

@Component
public class AccountMapper {

    public Account ToEntity(Client client) {
        return Account.builder()
                .client(client)
                .build();
    }

    public AccountResponseDTO ToDTO(Account account) {
        return new AccountResponseDTO(
                account.getUuid(),
                account.getClient().getUuid(),
                account.getBalance(),
                account.getOverdraftLimit(),
                account.getStatus()
        );
    }

}
