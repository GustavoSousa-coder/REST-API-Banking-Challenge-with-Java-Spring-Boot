package com.challenge.Bank.mappers;

import com.challenge.Bank.DTO.request.AccountRequestDTO;
import com.challenge.Bank.DTO.request.ClientRequestDTO;
import com.challenge.Bank.DTO.request.OnboardingRequestDTO;
import com.challenge.Bank.DTO.response.AccountResponseDTO;
import com.challenge.Bank.DTO.response.ClientResponseDTO;
import com.challenge.Bank.DTO.response.OnboardingResponseDTO;
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
        accountRequestDTO.setClientId(onboardingRequestDTO.getClientId());
        return accountRequestDTO;
    }

    public OnboardingResponseDTO toOnboardingResponse(ClientResponseDTO clientResponseDTO, AccountResponseDTO accountResponseDTO) {
        return new OnboardingResponseDTO(
                clientResponseDTO.getId(),
                clientResponseDTO.getName(),
                clientResponseDTO.getDateOfBirth(),
                clientResponseDTO.getEmail(),
                clientResponseDTO.getAccountStatus(),

                accountResponseDTO.getId(),
                accountResponseDTO.getBalance(),
                accountResponseDTO.getType(),
                accountResponseDTO.getOverdraftLimit(),
                accountResponseDTO.getStatus()
        );
    }

}
