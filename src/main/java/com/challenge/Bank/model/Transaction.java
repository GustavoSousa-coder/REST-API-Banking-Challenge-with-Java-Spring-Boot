package com.challenge.Bank.model;

import java.io.Serial;
import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.Objects;

public class Transaction implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
    private Long id;
    private Double valor;
    private OffsetDateTime dataHora =  OffsetDateTime.now();

    public Transaction() {
    }
    public Transaction(Long id, Double valor, OffsetDateTime dataHora) {
        this.id = id;
        this.valor = valor;
        this.dataHora = dataHora;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
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
        Transaction that = (Transaction) o;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getValor(), that.getValor()) && Objects.equals(getDataHora(), that.getDataHora());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getValor(), getDataHora());
    }
}
