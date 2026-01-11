package com.challenge.Bank.DTO.request;

import java.math.BigDecimal;
import java.util.Objects;

public class TransactionRequestDTO {

    private BigDecimal valor;

    public TransactionRequestDTO() {}
    public TransactionRequestDTO(BigDecimal valor) {
        this.valor = valor;
    }

    public BigDecimal getValor() {return valor;}

    public void setValor(BigDecimal valor) {this.valor = valor;}

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        TransactionRequestDTO that = (TransactionRequestDTO) o;
        return Objects.equals(getValor(), that.getValor());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getValor());
    }
}

