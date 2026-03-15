package com.challenge.Bank.addressKey.service;

import com.challenge.Bank.Enums.AccountStatus;
import com.challenge.Bank.accounts.repository.AccountRepository;
import com.challenge.Bank.addressKey.DTO.AddressKeyRequestDTO;
import com.challenge.Bank.addressKey.mapper.AddressKeyMapper;
import com.challenge.Bank.addressKey.model.AddressKey;
import com.challenge.Bank.addressKey.repository.AddressKeyRepository;
import com.challenge.Bank.exceptions.NotFound;
import com.challenge.Bank.exceptions.UnprocessableEntity;
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
        var entity = addressKeyMapper.toEntity(addressKeyRequestDTO);

        var account =  accountRepository.findById(accountId)
                .orElseThrow(() -> new NotFound("Account not found"));

        if (account.getStatus() != AccountStatus.ACTIVE) { throw new UnprocessableEntity("Error relational in account not active"); }

        AddressKey getKey = addressKeyRepository.findByKeyValue(addressKeyRequestDTO.keyValue());
        if (getKey == null) { throw  new NotFound("Address key not found"); }

        AddressKey key = AddressKey.builder()
                .keyValue(addressKeyRequestDTO.keyValue())
                .keyType(addressKeyRequestDTO.keyType())
                .account(account)
                .build();

        var saved = addressKeyRepository.save(key);

        return addressKeyMapper.toDTO(saved);
    }

}
