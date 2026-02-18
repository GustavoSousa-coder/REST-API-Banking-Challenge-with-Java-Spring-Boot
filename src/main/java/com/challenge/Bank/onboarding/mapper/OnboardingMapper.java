package com.challenge.Bank.onboarding.mapper;

import com.challenge.Bank.accounts.DTO.AccountRequestDTO;
import com.challenge.Bank.clients.DTO.ClientRequestDTO;
import com.challenge.Bank.accounts.DTO.AccountResponseDTO;
import com.challenge.Bank.clients.DTO.ClientResponseDTO;
import com.challenge.Bank.onboarding.DTO.OnboardingRequestDTO;
import com.challenge.Bank.onboarding.DTO.OnboardingResponseDTO;
import org.springframework.stereotype.Component;

@Component
public class OnboardingMapper {

    public ClientRequestDTO toClientRequest(OnboardingRequestDTO onboardingRequestDTO) {
        ClientRequestDTO clientRequestDTO = new ClientRequestDTO();
        clientRequestDTO.setName(onboardingRequestDTO.getName());
        clientRequestDTO.setCpf(onboardingRequestDTO.getCpf());
        clientRequestDTO.setDateOfBirth(onboardingRequestDTO.getDateOfBirth());
        clientRequestDTO.setEmail(onboardingRequestDTO.getEmail());
        clientRequestDTO.setPassword(onboardingRequestDTO.getPassword());
        return clientRequestDTO;
    }

    public AccountRequestDTO toAccountRequest(OnboardingRequestDTO onboardingRequestDTO) {
        AccountRequestDTO accountRequestDTO = new AccountRequestDTO();
        accountRequestDTO.setType(onboardingRequestDTO.getType());
        return accountRequestDTO;
    }

    public OnboardingResponseDTO toOnboardingResponse(ClientResponseDTO clientResponseDTO, AccountResponseDTO accountResponseDTO) {
        return new OnboardingResponseDTO(
                clientResponseDTO.getUuid(),
                clientResponseDTO.getName(),
                clientResponseDTO.getDateOfBirth(),
                clientResponseDTO.getEmail(),
                clientResponseDTO.getAccountStatus(),

                accountResponseDTO.getUuid(),
                accountResponseDTO.getBalance(),
                accountResponseDTO.getType(),
                accountResponseDTO.getOverdraftLimit(),
                accountResponseDTO.getStatus()
        );
    }

}
