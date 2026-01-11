package com.challenge.Bank.DTO.request;

import com.challenge.Bank.model.Enums.AccountType;

import java.util.Objects;

public class AccountRequestDTO {

    private Long ClientId;
    private AccountType type;

    public AccountRequestDTO() {
    }
    public AccountRequestDTO(Long clientId, AccountType type) {
        ClientId = clientId;
        this.type = type;
    }

    public Long getClientId() {
        return ClientId;
    }

    public void setClientId(Long clientId) {
        ClientId = clientId;
    }

    public AccountType getType() {
        return type;
    }

    public void setType(AccountType type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        AccountRequestDTO that = (AccountRequestDTO) o;
        return Objects.equals(getClientId(), that.getClientId()) && getType() == that.getType();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getClientId(), getType());
    }
}
