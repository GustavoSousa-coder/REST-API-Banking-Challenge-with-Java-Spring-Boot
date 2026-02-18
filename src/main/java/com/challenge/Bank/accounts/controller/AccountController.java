package com.challenge.Bank.accounts.controller;

import com.challenge.Bank.accounts.DTO.AccountRequestDTO;
import com.challenge.Bank.accounts.DTO.AccountResponseDTO;
import com.challenge.Bank.accounts.service.AccountService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/account")
public class AccountController {

    private final AccountService accountService;
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping(value = "/{ClientUuid}/accounts", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<AccountResponseDTO> findAllByClientId(@PathVariable UUID ClientUuid) {
        return accountService.findAllByClientId(ClientUuid);
    }

    @GetMapping(value = "/{uuid}/account", produces = MediaType.APPLICATION_JSON_VALUE)
    public AccountResponseDTO findById(@PathVariable UUID uuid) {
        return accountService.findById(uuid);
    }

    @PostMapping(value = "/{uuid}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public AccountResponseDTO save(@PathVariable UUID uuid, @RequestBody AccountRequestDTO accountRequestDTO) {
        return accountService.saveAccount(accountRequestDTO, uuid);
    }

    @DeleteMapping(value = "/{uuid}")
    public void delete(@PathVariable UUID uuid) {
        accountService.desableAccount(uuid);
    }

}
