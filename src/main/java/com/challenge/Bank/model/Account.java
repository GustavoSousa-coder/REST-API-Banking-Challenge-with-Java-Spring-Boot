package com.challenge.Bank.model;

import com.challenge.Bank.model.Enums.AccountStatus;
import com.challenge.Bank.model.Enums.AccountType;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.Objects;

public class Account {

    private Long id;
    private String accountNumber;
    private String agencyNumber;
    private Long clientId;
    private BigDecimal balance;
    private AccountType type;
    private Double overdraftLimit;
    private AccountStatus status;
    private OffsetDateTime createdAt;

    {
        this.accountNumber = "5706";
        this.agencyNumber = "0001";
        this.overdraftLimit = 1.000;
        //----
        this.balance = BigDecimal.ZERO;
        this.status = AccountStatus.ACTIVE;
        this.createdAt = OffsetDateTime.now();
    }

    public Account() {
    }
    public Account(Long id, String accountNumber, String agencyNumber, Long clientId, BigDecimal balance, AccountType type, Double overdraftLimit, AccountStatus status, OffsetDateTime createdAt) {
        this.id = id;
        this.accountNumber = accountNumber;
        this.agencyNumber = agencyNumber;
        this.clientId = clientId;
        this.balance = balance;
        this.type = type;
        this.overdraftLimit = overdraftLimit;
        this.status = status;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAgencyNumber() {
        return agencyNumber;
    }

    public void setAgencyNumber(String agencyNumber) {
        this.agencyNumber = agencyNumber;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
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

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(getId(), account.getId()) && Objects.equals(getAccountNumber(), account.getAccountNumber()) && Objects.equals(getAgencyNumber(), account.getAgencyNumber()) && Objects.equals(getClientId(), account.getClientId()) && Objects.equals(getBalance(), account.getBalance()) && getType() == account.getType() && Objects.equals(getOverdraftLimit(), account.getOverdraftLimit()) && getStatus() == account.getStatus() && Objects.equals(getCreatedAt(), account.getCreatedAt());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getAccountNumber(), getAgencyNumber(), getClientId(), getBalance(), getType(), getOverdraftLimit(), getStatus(), getCreatedAt());
    }
}
