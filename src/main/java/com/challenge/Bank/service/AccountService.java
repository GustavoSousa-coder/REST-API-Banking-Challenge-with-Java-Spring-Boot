package com.challenge.Bank.service;

import com.challenge.Bank.DTO.request.AccountRequestDTO;
import com.challenge.Bank.DTO.response.AccountResponseDTO;
import com.challenge.Bank.mappers.AccountMapper;
import com.challenge.Bank.model.Account;
import com.challenge.Bank.repository.AccountRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {

    private static final Logger log = LoggerFactory.getLogger(AccountService.class);
    private final AccountRepository accountRepository;
    private final AccountMapper accountMapper;

    public AccountService(AccountRepository accountRepository, AccountMapper accountMapper) {
        this.accountRepository = accountRepository;
        this.accountMapper = accountMapper;
    }

    public List<AccountResponseDTO> findAllByClientId(Long clientId) {
        log.info("Find all accounts by client id {}", clientId);
        List<Account> accounts =  accountRepository.findAllByClientId(clientId);
        return accounts.stream().map(accountMapper::ToDTO).toList();
    }

    public AccountResponseDTO findById(Long id) {
        log.info("Find account by id {}", id);
        Account account = accountRepository.findById(id);
        return accountMapper.ToDTO(account);
    }

    public AccountResponseDTO saveAccount(AccountRequestDTO accountRequestDTO) {
        log.info("Save account");
        var entity = accountMapper.ToEntity(accountRequestDTO);
        var accountSave = accountRepository.save(entity);
        return accountMapper.ToDTO(accountSave);
    }

    public void delete(Long id) {
        log.info("Delete account by id {}", id);
        accountRepository.delete(id);
    }

}
