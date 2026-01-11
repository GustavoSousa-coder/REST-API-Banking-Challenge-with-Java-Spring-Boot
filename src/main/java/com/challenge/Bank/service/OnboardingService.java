package com.challenge.Bank.service;

import com.challenge.Bank.DTO.request.ClientRequestDTO;
import com.challenge.Bank.DTO.request.OnboardingRequestDTO;
import com.challenge.Bank.DTO.response.AccountResponseDTO;
import com.challenge.Bank.DTO.response.ClientResponseDTO;
import com.challenge.Bank.DTO.response.OnboardingResponseDTO;
import com.challenge.Bank.mappers.AccountMapper;
import com.challenge.Bank.mappers.ClientMapper;
import com.challenge.Bank.mappers.OnboardingMapper;
import com.challenge.Bank.model.Client;
import org.springframework.stereotype.Service;

@Service
public class OnboardingService {

    private final OnboardingMapper onboardingMapper;
    private final ClientService clientService;
    private final AccountService accountService;

    public OnboardingService(OnboardingMapper onboardingMapper, ClientService clientService, AccountService accountService) {
        this.onboardingMapper = onboardingMapper;
        this.clientService = clientService;
        this.accountService = accountService;
    }

    public OnboardingResponseDTO save(OnboardingRequestDTO onboardingRequestDTO) {

        var clientRequest = onboardingMapper.toClientRequest(onboardingRequestDTO);
        var accountRequest = onboardingMapper.toAccountRequest(onboardingRequestDTO);

        var client = clientService.save(clientRequest);
        var account = accountService.saveAccount(accountRequest);

        return onboardingMapper.toOnboardingResponse(client, account);
    }

}
