package com.challenge.Bank.onboarding.DTO;

import com.challenge.Bank.Enums.AccountStatus;
import com.challenge.Bank.Enums.AccountType;
import com.challenge.Bank.Enums.ClientStatus;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

public class OnboardingResponseDTO {

    private UUID ClientUuid;
    private String name;
    private LocalDate dateOfBirth;
    private String email;
    private ClientStatus accountStatus;

    private UUID AccountUuid;
    private BigDecimal balance;
    private AccountType type;
    private Double overdraftLimit;
    private AccountStatus status;

    public OnboardingResponseDTO() {
    }

    public OnboardingResponseDTO(UUID uuid, String name, LocalDate dateOfBirth, String email, ClientStatus accountStatus, UUID accountUUID, BigDecimal balance, AccountType type, Double overdraftLimit, AccountStatus status) {
        this.ClientUuid = uuid;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.accountStatus = accountStatus;
        AccountUuid = accountUUID;
        this.balance = balance;
        this.type = type;
        this.overdraftLimit = overdraftLimit;
        this.status = status;
    }

    public UUID getClientUuid() {
        return ClientUuid;
    }

    public void setClientUuid(UUID clientUuid) {
        this.ClientUuid = clientUuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ClientStatus getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(ClientStatus accountStatus) {
        this.accountStatus = accountStatus;
    }

    public UUID getAccountUuid() {
        return AccountUuid;
    }

    public void setAccountUuid(UUID accountUuid) {
        AccountUuid = accountUuid;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public AccountType getType() {
        return type;
    }

    public void setType(AccountType type) {
        this.type = type;
    }

    public Double getOverdraftLimit() {
        return overdraftLimit;
    }

    public void setOverdraftLimit(Double overdraftLimit) {
        this.overdraftLimit = overdraftLimit;
    }

    public AccountStatus getStatus() {
        return status;
    }

    public void setStatus(AccountStatus status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        OnboardingResponseDTO that = (OnboardingResponseDTO) o;
        return Objects.equals(getClientUuid(), that.getClientUuid()) && Objects.equals(getName(), that.getName()) && Objects.equals(getDateOfBirth(), that.getDateOfBirth()) && Objects.equals(getEmail(), that.getEmail()) && getAccountStatus() == that.getAccountStatus() && Objects.equals(getAccountUuid(), that.getAccountUuid()) && Objects.equals(getBalance(), that.getBalance()) && getType() == that.getType() && Objects.equals(getOverdraftLimit(), that.getOverdraftLimit()) && getStatus() == that.getStatus();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getClientUuid(), getName(), getDateOfBirth(), getEmail(), getAccountStatus(), getAccountUuid(), getBalance(), getType(), getOverdraftLimit(), getStatus());
    }
}
