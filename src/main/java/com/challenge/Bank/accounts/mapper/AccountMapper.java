package com.challenge.Bank.accounts.mapper;

import com.challenge.Bank.accounts.DTO.AccountRequestDTO;
import com.challenge.Bank.accounts.DTO.AccountResponseDTO;
import com.challenge.Bank.accounts.model.Account;
import com.challenge.Bank.clients.model.Client;
import org.springframework.stereotype.Component;

@Component
public class AccountMapper {

    public Account ToEntity(AccountRequestDTO dto) {
        Account account = new Account();
        account.setType(dto.getType());
        return account;
    }

    public AccountResponseDTO ToDTO(Account account) {
        AccountResponseDTO dto = new AccountResponseDTO();
        dto.setUuid(account.getUuid());
        dto.setClientUuid(account.getClient().getUuid());
        dto.setBalance(account.getBalance());
        dto.setType(account.getType());
        dto.setOverdraftLimit(account.getOverdraftLimit());
        dto.setStatus(account.getStatus());
        return dto;
    }

}
