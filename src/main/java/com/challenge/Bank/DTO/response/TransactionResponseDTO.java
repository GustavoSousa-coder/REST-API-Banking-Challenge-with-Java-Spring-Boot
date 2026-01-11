package com.challenge.Bank.DTO.response;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.Objects;


public class TransactionResponseDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
    private Long id;
    private BigDecimal valor;
    private OffsetDateTime dataHora =  OffsetDateTime.now();

    public TransactionResponseDTO() {
    }
    public TransactionResponseDTO(Long id, BigDecimal valor, OffsetDateTime dataHora) {
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

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
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
        TransactionResponseDTO that = (TransactionResponseDTO) o;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getValor(), that.getValor()) && Objects.equals(getDataHora(), that.getDataHora());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getValor(), getDataHora());
    }

    @Override
    public String toString() {
        return "TransactionDTO{" +
                "id=" + id +
                ", valor=" + valor +
                ", dataHora=" + dataHora +
                '}';
    }
}
