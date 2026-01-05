package com.challenge.Bank.DTO.request;

import java.util.Objects;

public class TransactionRequestDTO {

    private Double valor;

    public TransactionRequestDTO() {}
    public TransactionRequestDTO(Double valor) {
        this.valor = valor;
    }

    public Double getValor() {return valor;}

    public void setValor(Double valor) {this.valor = valor;}

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

