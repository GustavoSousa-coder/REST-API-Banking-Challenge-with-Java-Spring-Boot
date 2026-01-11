package com.challenge.Bank.mappers;

import com.challenge.Bank.DTO.request.AccountRequestDTO;
import com.challenge.Bank.DTO.response.AccountResponseDTO;
import com.challenge.Bank.model.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountMapper {

    public Account ToEntity(AccountRequestDTO dto) {
        Account account = new Account();
        account.setClientId(dto.getClientId());
        account.setType(dto.getType());
        return account;
    }

    public AccountResponseDTO ToDTO(Account account) {
        AccountResponseDTO dto = new AccountResponseDTO();
        dto.setId(account.getId());
        dto.setBalance(account.getBalance());
        dto.setType(account.getType());
        dto.setOverdraftLimit(account.getOverdraftLimit());
        dto.setStatus(account.getStatus());
        return dto;
    }

}
