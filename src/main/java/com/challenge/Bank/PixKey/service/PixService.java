package com.challenge.Bank.PixKey.service;

import com.challenge.Bank.Enums.AccountStatus;
import com.challenge.Bank.accounts.repository.AccountRepository;
import com.challenge.Bank.PixKey.DTO.PixTransferRequestDTO;
import com.challenge.Bank.PixKey.mapper.PixKeyMapper;
import com.challenge.Bank.PixKey.model.PixKey;
import com.challenge.Bank.PixKey.repository.PixKeyRepository;
import com.challenge.Bank.exceptions.NotFound;
import com.challenge.Bank.exceptions.UnprocessableEntity;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PixService {

    private final PixKeyRepository pixKeyRepository;
    private final AccountRepository accountRepository;
    private final PixKeyMapper pixKeyMapper;

    public PixService(PixKeyRepository pixKeyRepository1, AccountRepository accountRepository, PixKeyMapper pixKeyMapper) {
        this.pixKeyRepository = pixKeyRepository1;
        this.accountRepository = accountRepository;
        this.pixKeyMapper = pixKeyMapper;
    }

    public Object registerAddressKey(PixTransferRequestDTO pixTransferRequestDTO, UUID accountId) {
        var entity = pixKeyMapper.toEntity(pixTransferRequestDTO);

        var account =  accountRepository.findById(accountId)
                .orElseThrow(() -> new NotFound("Account not found"));

        if (account.getStatus() != AccountStatus.ACTIVE) { throw new UnprocessableEntity("Error relational in account not active"); }

        PixKey key = PixKey.builder()
                .keyValue(pixTransferRequestDTO.keyValue())
                .keyType(pixTransferRequestDTO.keyType())
                .account(account)
                .build();

        var saved = pixKeyRepository.save(key);

        return pixKeyMapper.toDTO(saved);
    }

}
