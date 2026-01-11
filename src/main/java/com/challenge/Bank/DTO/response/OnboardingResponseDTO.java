package com.challenge.Bank.DTO.response;

import com.challenge.Bank.model.Enums.AccountStatus;
import com.challenge.Bank.model.Enums.AccountType;
import com.challenge.Bank.model.Enums.Status;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

public class OnboardingResponseDTO {

    private Long ClientId;
    private String name;
    private LocalDate dateOfBirth;
    private String email;
    private Status accountStatus;

    private Long AccountId;
    private BigDecimal balance;
    private AccountType type;
    private Double overdraftLimit;
    private AccountStatus status;

    public OnboardingResponseDTO() {
    }

    public OnboardingResponseDTO(Long clientId, String name, LocalDate dateOfBirth, String email, Status accountStatus, Long accountId, BigDecimal balance, AccountType type, Double overdraftLimit, AccountStatus status) {
        ClientId = clientId;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.accountStatus = accountStatus;
        AccountId = accountId;
        this.balance = balance;
        this.type = type;
        this.overdraftLimit = overdraftLimit;
        this.status = status;
    }

    public Long getClientId() {
        return ClientId;
    }

    public void setClientId(Long clientId) {
        ClientId = clientId;
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

    public Status getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(Status accountStatus) {
        this.accountStatus = accountStatus;
    }

    public Long getAccountId() {
        return AccountId;
    }

    public void setAccountId(Long accountId) {
        AccountId = accountId;
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
        return Objects.equals(getClientId(), that.getClientId()) && Objects.equals(getName(), that.getName()) && Objects.equals(getDateOfBirth(), that.getDateOfBirth()) && Objects.equals(getEmail(), that.getEmail()) && getAccountStatus() == that.getAccountStatus() && Objects.equals(getAccountId(), that.getAccountId()) && Objects.equals(getBalance(), that.getBalance()) && getType() == that.getType() && Objects.equals(getOverdraftLimit(), that.getOverdraftLimit()) && getStatus() == that.getStatus();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getClientId(), getName(), getDateOfBirth(), getEmail(), getAccountStatus(), getAccountId(), getBalance(), getType(), getOverdraftLimit(), getStatus());
    }
}
