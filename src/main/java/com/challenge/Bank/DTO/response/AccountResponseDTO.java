package com.challenge.Bank.DTO.response;

import com.challenge.Bank.model.Enums.AccountStatus;
import com.challenge.Bank.model.Enums.AccountType;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.Objects;

public class AccountResponseDTO {

    private Long id;
    private BigDecimal balance;
    private AccountType type;
    private Double overdraftLimit;
    private AccountStatus status;

    public AccountResponseDTO() {
    }
    public AccountResponseDTO(Long id, BigDecimal balance, AccountType type, Double overdraftLimit, AccountStatus status) {
        this.id = id;
        this.balance = balance;
        this.type = type;
        this.overdraftLimit = overdraftLimit;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        AccountResponseDTO that = (AccountResponseDTO) o;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getBalance(), that.getBalance()) && getType() == that.getType() && Objects.equals(getOverdraftLimit(), that.getOverdraftLimit()) && getStatus() == that.getStatus();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getBalance(), getType(), getOverdraftLimit(), getStatus());
    }
}
