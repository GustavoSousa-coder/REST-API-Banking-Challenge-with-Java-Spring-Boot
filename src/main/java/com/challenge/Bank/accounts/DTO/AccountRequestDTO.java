package com.challenge.Bank.accounts.DTO;

import com.challenge.Bank.Enums.AccountType;
import com.challenge.Bank.Enums.KeyType;
import com.challenge.Bank.clients.model.Client;

import java.util.Objects;
import java.util.UUID;

public class AccountRequestDTO {

    private UUID clientUuid;
    private AccountType type;

    public AccountRequestDTO() {
    }
    public AccountRequestDTO(UUID clientUuid, AccountType type) {
        this.clientUuid = clientUuid;
        this.type = type;
    }

    public UUID getClientUuid() {
        return clientUuid;
    }

    public void setClientUuid(UUID clientUuid) {
        this.clientUuid = clientUuid;
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
        return Objects.equals(getClientUuid(), that.getClientUuid()) && getType() == that.getType();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getClientUuid(), getType());
    }
}
