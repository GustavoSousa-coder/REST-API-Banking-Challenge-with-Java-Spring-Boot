package com.challenge.Bank.transactions.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;
import java.util.Objects;

public class TransactionRequestDTO {

    @NotNull
    @Positive
    private BigDecimal amount;

    @NotBlank
    private String key;

    public TransactionRequestDTO() {}
    public TransactionRequestDTO(BigDecimal amount,  String key) {
        this.amount = amount;
        this.key = key;
    }

    public BigDecimal getAmount() {return amount;}
    public void setAmount(BigDecimal amount) {this.amount = amount;}
    public String getKey() {return key;}
    public void setKey(String key) {this.key = key;}

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        TransactionRequestDTO that = (TransactionRequestDTO) o;
        return Objects.equals(getAmount(), that.getAmount()) && Objects.equals(getKey(), that.getKey());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAmount(), getKey());
    }
}

