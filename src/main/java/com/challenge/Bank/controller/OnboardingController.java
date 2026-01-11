package com.challenge.Bank.controller;

import com.challenge.Bank.DTO.request.OnboardingRequestDTO;
import com.challenge.Bank.DTO.response.OnboardingResponseDTO;
import com.challenge.Bank.service.OnboardingService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/onboarding")
public class OnboardingController {

    private final OnboardingService  onboardingService;

    public OnboardingController(OnboardingService onboardingService) {
        this.onboardingService = onboardingService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public OnboardingResponseDTO save(@RequestBody OnboardingRequestDTO onboardingRequestDTO) {
        return onboardingService.save(onboardingRequestDTO);
    }
}
