package com.challenge.Bank.transactions.DTO;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.Objects;
import java.util.UUID;


public class TransactionResponseDTO {

    private UUID uuid;
    private BigDecimal amount;
    private OffsetDateTime dataHora =  OffsetDateTime.now();

    public TransactionResponseDTO() {
    }

    public TransactionResponseDTO(UUID uuid, BigDecimal valor, OffsetDateTime dataHora) {
        this.uuid = uuid;
        this.amount = valor;
        this.dataHora = dataHora;
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

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        TransactionResponseDTO that = (TransactionResponseDTO) o;
        return Objects.equals(getUuid(), that.getUuid()) && Objects.equals(getAmount(), that.getAmount()) && Objects.equals(getDataHora(), that.getDataHora());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUuid(), getAmount(), getDataHora());
    }
}
