package com.challenge.Bank.model;

import com.challenge.Bank.model.Enums.Status;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.Objects;

public class Client implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
    private Long id;
    private String name;
    private String cpf;
    private LocalDate dateOfBirth;
    private String email;
    private String password; // TODO: passar a criptografar e tratar a senha, no momento é apenas para testes
    private Status accountStatus;
    private OffsetDateTime createdAt;

    {
        this.accountStatus = Status.Active;
        this.createdAt = OffsetDateTime.now();
    }

    public Client() {
    }
    public Client(Long id, String name, String cpf, LocalDate dateOfBirth, String email, String password, Status accountStatus, OffsetDateTime createdAt) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.password = password;
        this.accountStatus = accountStatus;
        this.createdAt = createdAt;
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
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

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {}

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(getId(), client.getId()) && Objects.equals(getName(), client.getName()) && Objects.equals(getCpf(), client.getCpf()) && Objects.equals(getDateOfBirth(), client.getDateOfBirth()) && Objects.equals(getEmail(), client.getEmail()) && Objects.equals(getPassword(), client.getPassword()) && getAccountStatus() == client.getAccountStatus() && Objects.equals(getCreatedAt(), client.getCreatedAt());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getCpf(), getDateOfBirth(), getEmail(), getPassword(), getAccountStatus(), getCreatedAt());
    }
}
