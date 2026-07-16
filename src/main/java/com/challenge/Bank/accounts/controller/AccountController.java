package com.challenge.Bank.accounts.controller;

import com.challenge.Bank.accounts.DTO.AccountResponseDTO;
import com.challenge.Bank.accounts.controller.doc.AccountControllerDoc;
import com.challenge.Bank.accounts.service.AccountService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/account")
public class AccountController implements AccountControllerDoc {

    private final AccountService accountService;
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @Override
    @GetMapping(value = "/{ClientUuid}/accounts", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<AccountResponseDTO>> findAllByClientId(@PathVariable UUID ClientUuid) {
        return ResponseEntity.ok(accountService.findAllByClientId(ClientUuid));
    }

    @Override
    @GetMapping(value = "/{uuid}/account", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AccountResponseDTO> findById(@PathVariable UUID uuid) {
        return ResponseEntity.ok(accountService.findById(uuid));
    }

    @Override
    @PostMapping(value = "/{clientUuid}", produces = MediaType.APPLICATION_JSON_VALUE)
    public AccountResponseDTO save(@PathVariable UUID clientUuid) {
        return accountService.saveAccount(clientUuid);
    }

    @Override
    @DeleteMapping(value = "/{uuid}")
    public ResponseEntity<Void> delete(@PathVariable UUID uuid) {
        accountService.desableAccount(uuid);
        return ResponseEntity.ok().build();
    }

}
