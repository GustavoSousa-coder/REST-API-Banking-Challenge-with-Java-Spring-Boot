package com.challenge.Bank.addressKey.DTO;

import com.challenge.Bank.Enums.KeyType;

import java.util.Objects;

public class AddressKeyResponseDTO {

    private KeyType keyType;
    private String keyValue;

    public AddressKeyResponseDTO() {
    }
    public AddressKeyResponseDTO(KeyType keyType, String keyValue) {
        this.keyType = keyType;
        this.keyValue = keyValue;
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

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        AddressKeyResponseDTO that = (AddressKeyResponseDTO) o;
        return getKeyType() == that.getKeyType() && Objects.equals(getKeyValue(), that.getKeyValue());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getKeyType(), getKeyValue());
    }
}
