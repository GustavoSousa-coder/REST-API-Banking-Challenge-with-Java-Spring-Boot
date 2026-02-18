package com.challenge.Bank.clients.DTO;

import com.challenge.Bank.Enums.ClientStatus;

import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

public class ClientResponseDTO {

    private UUID uuid;
    private String name;
    private LocalDate dateOfBirth;
    private String email;
    private ClientStatus accountStatus;

    public ClientResponseDTO() {
    }

    public ClientResponseDTO(UUID uuid, String name, LocalDate dateOfBirth, String email, ClientStatus accountStatus) {
        this.uuid = uuid;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.accountStatus = accountStatus;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ClientStatus getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(ClientStatus accountStatus) {
        this.accountStatus = accountStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ClientResponseDTO that = (ClientResponseDTO) o;
        return Objects.equals(getUuid(), that.getUuid()) && Objects.equals(getName(), that.getName()) && Objects.equals(getDateOfBirth(), that.getDateOfBirth()) && Objects.equals(getEmail(), that.getEmail()) && getAccountStatus() == that.getAccountStatus();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUuid(), getName(), getDateOfBirth(), getEmail(), getAccountStatus());
    }
}
