package com.challenge.Bank.accounts.model;

import com.challenge.Bank.Enums.AccountStatus;
import com.challenge.Bank.Enums.AccountType;
import com.challenge.Bank.Enums.KeyType;
import com.challenge.Bank.clients.model.Client;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID uuid;

    @Column(name = "account_number", nullable = false, length = 5)
    private String accountNumber;

    @Column(name = "agency_number",  nullable = false, length = 5)
    private String agencyNumber;

    @Column(name = "balance", nullable = false)
    private BigDecimal balance;

    @Column(name = "type", unique = false, nullable = false,  length = 10)
    private AccountType type;

    @Column(name = "overdraft_limit", nullable = false)
    private Double overdraftLimit;

    @Column(name = "status", unique = false, nullable = false, length = 10)
    private AccountStatus status;

    @Column(name = "created_at",  nullable = false)
    private OffsetDateTime createdAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id")
    private Client client;

    {
        this.accountNumber = "5706";
        this.agencyNumber = "0001";
        this.overdraftLimit = 1.000;
        this.balance = BigDecimal.ZERO;
        this.status = AccountStatus.ACTIVE;
        this.createdAt = OffsetDateTime.now();
    }
    public Account() {
    }
    public Account(UUID uuid, String accountNumber, String agencyNumber, BigDecimal balance, AccountType type, Double overdraftLimit, AccountStatus status, OffsetDateTime createdAt, Client client) {
        this.uuid = uuid;
        this.accountNumber = accountNumber;
        this.agencyNumber = agencyNumber;
        this.balance = balance;
        this.type = type;
        this.overdraftLimit = overdraftLimit;
        this.status = status;
        this.createdAt = createdAt;
        this.client = client;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
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

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(getUuid(), account.getUuid()) && Objects.equals(getAccountNumber(), account.getAccountNumber()) && Objects.equals(getAgencyNumber(), account.getAgencyNumber()) && Objects.equals(getBalance(), account.getBalance()) && getType() == account.getType() && Objects.equals(getOverdraftLimit(), account.getOverdraftLimit()) && getStatus() == account.getStatus() && Objects.equals(getCreatedAt(), account.getCreatedAt()) && Objects.equals(getClient(), account.getClient());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUuid(), getAccountNumber(), getAgencyNumber(), getBalance(), getType(), getOverdraftLimit(), getStatus(), getCreatedAt(), getClient());
    }
}
