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
        return new ClientRequestDTO(
                onboardingRequestDTO.name(),
                onboardingRequestDTO.cpf(),
                onboardingRequestDTO.dateOfBirth(),
                onboardingRequestDTO.email(),
                onboardingRequestDTO.password()
        );
    }

    public AccountRequestDTO toAccountRequest(OnboardingRequestDTO onboardingRequestDTO) {
        return new  AccountRequestDTO(
                onboardingRequestDTO.type()
        );
    }

    public OnboardingResponseDTO toOnboardingResponse(ClientResponseDTO clientResponseDTO, AccountResponseDTO accountResponseDTO) {
        return new OnboardingResponseDTO(
                clientResponseDTO.uuid(),
                clientResponseDTO.name(),
                clientResponseDTO.dateOfBirth(),
                clientResponseDTO.email(),
                clientResponseDTO.clientStatus(),

                accountResponseDTO.uuid(),
                accountResponseDTO.balance(),
                accountResponseDTO.type(),
                accountResponseDTO.overdraftLimit(),
                accountResponseDTO.status()
        );
    }

}
