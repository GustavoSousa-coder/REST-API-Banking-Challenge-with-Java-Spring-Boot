package com.challenge.Bank.accounts.DTO;

import com.challenge.Bank.Enums.AccountStatus;
import com.challenge.Bank.Enums.AccountType;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;

public class AccountResponseDTO {

    private UUID uuid;
    private UUID clientUuid;
    private BigDecimal balance;
    private AccountType type;
    private Double overdraftLimit;
    private AccountStatus status;

    public AccountResponseDTO() {
    }

    public AccountResponseDTO(UUID uuid, UUID clientUuid, BigDecimal balance, AccountType type, Double overdraftLimit, AccountStatus status) {
        this.uuid = uuid;
        this.clientUuid = clientUuid;
        this.balance = balance;
        this.type = type;
        this.overdraftLimit = overdraftLimit;
        this.status = status;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public UUID getClientUuid() {
        return clientUuid;
    }

    public void setClientUuid(UUID clientUuid) {
        this.clientUuid = clientUuid;
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
        return Objects.equals(getUuid(), that.getUuid()) && Objects.equals(getClientUuid(), that.getClientUuid()) && Objects.equals(getBalance(), that.getBalance()) && getType() == that.getType() && Objects.equals(getOverdraftLimit(), that.getOverdraftLimit()) && getStatus() == that.getStatus();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUuid(), getClientUuid(), getBalance(), getType(), getOverdraftLimit(), getStatus());
    }
}
