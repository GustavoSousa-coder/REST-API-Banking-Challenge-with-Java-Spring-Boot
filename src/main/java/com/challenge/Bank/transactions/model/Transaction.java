package com.challenge.Bank.transactions.model;

import com.challenge.Bank.Enums.TransactionStatus;
import com.challenge.Bank.Enums.TransactionType;
import com.challenge.Bank.accounts.model.Account;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "transactions")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID uuid;

    @Column(name = "amount",  nullable = false)
    private BigDecimal amount;

    @Enumerated(EnumType.STRING)
    @Column(name = "transaction_type", nullable = false)
    private TransactionType transactionType;

    @Column(name = "status")
    private TransactionStatus status;

    @Column(name = "data_hora",  nullable = false)
    private OffsetDateTime dataHora;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sender_account_id")
    private Account senderAccount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "receiver_account_id")
    private Account receiverAccount;

    {
        this.dataHora = OffsetDateTime.now();
        this.amount = BigDecimal.ZERO;
    }
    public Transaction() {
    }
    public Transaction(UUID uuid, BigDecimal amount, TransactionType transactionType, TransactionStatus status, OffsetDateTime dataHora, Account senderAccount, Account receiverAccount) {
        this.uuid = uuid;
        this.amount = amount;
        this.transactionType = transactionType;
        this.status = status;
        this.dataHora = dataHora;
        this.senderAccount = senderAccount;
        this.receiverAccount = receiverAccount;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public OffsetDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(OffsetDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    public Account getSenderAccount() {
        return senderAccount;
    }

    public void setSenderAccount(Account senderAccount) {
        this.senderAccount = senderAccount;
    }

    public Account getReceiverAccount() {
        return receiverAccount;
    }

    public void setReceiverAccount(Account receiverAccount) {
        this.receiverAccount = receiverAccount;
    }

    public TransactionStatus getStatus() {
        return status;
    }

    public void setStatus(TransactionStatus status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return Objects.equals(getUuid(), that.getUuid()) && Objects.equals(getAmount(), that.getAmount()) && getTransactionType() == that.getTransactionType() && getStatus() == that.getStatus() && Objects.equals(getDataHora(), that.getDataHora()) && Objects.equals(getSenderAccount(), that.getSenderAccount()) && Objects.equals(getReceiverAccount(), that.getReceiverAccount());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUuid(), getAmount(), getTransactionType(), getStatus(), getDataHora(), getSenderAccount(), getReceiverAccount());
    }
}
