package com.challenge.Bank.addressKey.service;

import com.challenge.Bank.accounts.repository.AccountRepository;
import com.challenge.Bank.addressKey.DTO.AddressKeyRequestDTO;
import com.challenge.Bank.addressKey.mapper.AddressKeyMapper;
import com.challenge.Bank.addressKey.repository.AddressKeyRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AddressKeyService {

    private final AddressKeyRepository addressKeyRepository;
    private final AccountRepository accountRepository;
    private final AddressKeyMapper addressKeyMapper;

    public AddressKeyService(AddressKeyRepository addressKeyRepository1, AccountRepository accountRepository, AddressKeyMapper addressKeyMapper) {
        this.addressKeyRepository = addressKeyRepository1;
        this.accountRepository = accountRepository;
        this.addressKeyMapper = addressKeyMapper;
    }

    public Object registerAddressKey(AddressKeyRequestDTO addressKeyRequestDTO, UUID accountId) {
        var key = addressKeyMapper.toEntity(addressKeyRequestDTO);
        var account =  accountRepository.findById(accountId)
                .orElseThrow(() -> new RuntimeException("Conta não encontrada"));
        key.setAccount(account);
        var saved = addressKeyRepository.save(key);
        return addressKeyMapper.toDTO(saved);
    }

}
