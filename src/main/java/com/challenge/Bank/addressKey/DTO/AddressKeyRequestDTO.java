package com.challenge.Bank.addressKey.DTO;

import com.challenge.Bank.Enums.KeyType;

import java.util.Objects;
import java.util.UUID;

public class AddressKeyRequestDTO {

    private KeyType keyType;
    private String keyValue;
    private UUID accountId;

    public AddressKeyRequestDTO() {
    }
    public AddressKeyRequestDTO(KeyType keyType, String keyValue, UUID account) {
        this.keyType = keyType;
        this.keyValue = keyValue;
        this.accountId = account;
    }

    public KeyType getKeyType() {
        return keyType;
    }

    public void setKeyType(KeyType keyType) {
        this.keyType = keyType;
    }

    public String getKeyValue() {
        return keyValue;
    }

    public void setKeyValue(String keyValue) {
        this.keyValue = keyValue;
    }

    public UUID getAccountId() {
        return accountId;
    }

    public void setAccountId(UUID accountId) {
        this.accountId = accountId;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        AddressKeyRequestDTO that = (AddressKeyRequestDTO) o;
        return getKeyType() == that.getKeyType() && Objects.equals(getKeyValue(), that.getKeyValue()) && Objects.equals(getAccountId(), that.getAccountId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getKeyType(), getKeyValue(), getAccountId());
    }
}
