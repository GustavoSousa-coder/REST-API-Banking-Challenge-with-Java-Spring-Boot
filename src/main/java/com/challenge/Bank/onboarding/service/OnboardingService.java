package com.challenge.Bank.onboarding.service;

import com.challenge.Bank.accounts.service.AccountService;
import com.challenge.Bank.clients.service.ClientService;
import com.challenge.Bank.exceptions.UnprocessableEntity;
import com.challenge.Bank.onboarding.DTO.OnboardingRequestDTO;
import com.challenge.Bank.onboarding.DTO.OnboardingResponseDTO;
import com.challenge.Bank.onboarding.mapper.OnboardingMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;

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

        if (Period.between(onboardingRequestDTO.dateOfBirth(), LocalDate.now()).getYears() < 18) {
            throw new UnprocessableEntity("Invalid date of birth");
        }

        clientService.validateCpf(onboardingRequestDTO.cpf());

        var clientRequest = onboardingMapper.toClientRequest(onboardingRequestDTO);
        var clientResponse = clientService.save(clientRequest);

        var accountRequest = onboardingMapper.toAccountRequest(onboardingRequestDTO);
        var accountResponse = accountService.saveAccount(accountRequest, clientResponse.uuid());

        return onboardingMapper.toOnboardingResponse(clientResponse, accountResponse);
    }

}
