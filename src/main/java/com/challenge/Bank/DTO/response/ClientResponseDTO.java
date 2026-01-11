package com.challenge.Bank.DTO.response;

import com.challenge.Bank.model.Enums.Status;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.Objects;

public class ClientResponseDTO implements Serializable {

    private Long id;
    private String name;
    private LocalDate dateOfBirth;
    private String email;
    private Status accountStatus;

    public ClientResponseDTO() {
    }
    public ClientResponseDTO(Long id, String name, LocalDate dateOfBirth, String email, Status accountStatus) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.accountStatus = accountStatus;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Status getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(Status accountStatus) {
        this.accountStatus = accountStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ClientResponseDTO that = (ClientResponseDTO) o;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getName(), that.getName()) && Objects.equals(getDateOfBirth(), that.getDateOfBirth()) && Objects.equals(getEmail(), that.getEmail()) && getAccountStatus() == that.getAccountStatus();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getDateOfBirth(), getEmail(), getAccountStatus());
    }
}
