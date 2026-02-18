package com.challenge.Bank.addressKey.model;

import com.challenge.Bank.Enums.KeyType;
import com.challenge.Bank.accounts.model.Account;
import jakarta.persistence.*;

import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "AddressKey")
public class AddressKey {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID uuid;

    @Column(name = "key_value", unique = true, nullable = false)
    private String keyValue;

    @Enumerated(EnumType.STRING)
    private KeyType keyType;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "account_id")
    private Account account;

    public AddressKey() {
    }
    public AddressKey(UUID uuid, String keyValue, KeyType keyType, Account account) {
        this.uuid = uuid;
        this.keyValue = keyValue;
        this.keyType = keyType;
        this.account = account;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getKeyValue() {
        return keyValue;
    }

    public void setKeyValue(String keyValue) {
        this.keyValue = keyValue;
    }

    public KeyType getKeyType() {
        return keyType;
    }

    public void setKeyType(KeyType keyType) {
        this.keyType = keyType;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        AddressKey that = (AddressKey) o;
        return Objects.equals(getUuid(), that.getUuid()) && Objects.equals(getKeyValue(), that.getKeyValue()) && getKeyType() == that.getKeyType() && Objects.equals(getAccount(), that.getAccount());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUuid(), getKeyValue(), getKeyType(), getAccount());
    }
}
