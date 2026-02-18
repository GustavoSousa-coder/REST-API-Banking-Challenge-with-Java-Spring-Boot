package com.challenge.Bank.accounts.service;

import com.challenge.Bank.Enums.AccountStatus;
import com.challenge.Bank.accounts.DTO.AccountRequestDTO;
import com.challenge.Bank.accounts.DTO.AccountResponseDTO;
import com.challenge.Bank.accounts.mapper.AccountMapper;
import com.challenge.Bank.accounts.model.Account;
import com.challenge.Bank.accounts.repository.AccountRepository;
import com.challenge.Bank.clients.repository.ClientRepository;
import com.challenge.Bank.exceptions.UnprocessableEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class AccountService {

    private static final Logger log = LoggerFactory.getLogger(AccountService.class);
    private final AccountRepository accountRepository;
    private final ClientRepository clientRepository;
    private final AccountMapper accountMapper;

    public AccountService(AccountRepository accountRepository, ClientRepository clientRepository, AccountMapper accountMapper) {
        this.accountRepository = accountRepository;
        this.clientRepository = clientRepository;
        this.accountMapper = accountMapper;
    }

    public List<AccountResponseDTO> findAllByClientId(UUID clientUuid) {
        log.info("Find all accounts by client id {}", clientUuid);

        clientRepository.findById(clientUuid)
                .orElseThrow(() -> new RuntimeException("client not found"));

        var accounts = accountRepository.findAll();
        return accounts.stream().map(accountMapper::ToDTO).toList();
    }

    public AccountResponseDTO findById(UUID uuid) {
        log.info("Find account by id {}", uuid);
        Account account = accountRepository.findById(uuid)
                .orElseThrow(() -> new UnprocessableEntity("Account not found"));
        return accountMapper.ToDTO(account);
    }

    public AccountResponseDTO saveAccount(AccountRequestDTO accountRequestDTO, UUID uuid) {
        if(uuid == null) { throw new  IllegalArgumentException("Client id is null"); }
        var entity = accountMapper.ToEntity(accountRequestDTO);
        var client = clientRepository.findById(uuid)
                .orElseThrow(() -> new UnprocessableEntity("Client not found"));
        entity.setClient(client);
        var accountSave = accountRepository.save(entity);
        log.info("Save account");
        return accountMapper.ToDTO(accountSave);
    }

    public void desableAccount(UUID uuid) {
        log.info("Delete account by id {}", uuid);
        var search = accountRepository.findById(uuid)
                .orElseThrow(() -> new UnprocessableEntity("Account not found"));
        search.setStatus(AccountStatus.CLOSED);
        accountMapper.ToDTO(accountRepository.save(search));
    }
}
