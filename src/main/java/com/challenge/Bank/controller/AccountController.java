package com.challenge.Bank.controller;

import com.challenge.Bank.DTO.request.AccountRequestDTO;
import com.challenge.Bank.DTO.response.AccountResponseDTO;
import com.challenge.Bank.service.AccountService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/account")
public class AccountController {

    private final AccountService accountService;
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping(value = "/{id}/accounts", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<AccountResponseDTO> findAllByClientId(@PathVariable Long id) {
        return accountService.findAllByClientId(id);
    }

    @GetMapping(value = "/{id}/account", produces = MediaType.APPLICATION_JSON_VALUE)
    public AccountResponseDTO findById(@PathVariable Long id) {
        return accountService.findById(id);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public AccountResponseDTO save(@RequestBody AccountRequestDTO  accountRequestDTO) {
        return accountService.saveAccount(accountRequestDTO);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable Long id) {
        accountService.delete(id);
    }

}
