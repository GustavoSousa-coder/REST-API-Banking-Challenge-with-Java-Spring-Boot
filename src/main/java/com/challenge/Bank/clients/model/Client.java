package com.challenge.Bank.clients.model;

import com.challenge.Bank.Enums.ClientStatus;
import com.challenge.Bank.accounts.model.Account;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "clients")
public class Client  {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID uuid;

    @Column(name = "cpf", nullable = false, length = 11)
    private String cpf;

    @Column(name = "name", nullable = false, length = 60)
    private String name;

    @Column(name = "date_of_birth", nullable = false, length = 10)
    private LocalDate dateOfBirth;

    @Column(name = "email", nullable = false, length = 50)
    private String email;

    @Column(name = "password", length = 50)
    private String password; // TODO: passar a criptografar e tratar a senha, no momento é apenas para testes

    @Column(name = "account_status", nullable = false, length = 10)
    private ClientStatus accountStatus;

    @Column(name = "created_at")
    private OffsetDateTime createdAt;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<Account> accounts = new ArrayList<>();

    {
        this.accountStatus = ClientStatus.Active;
        this.createdAt = OffsetDateTime.now();
    }
    public Client() {
    }
    public Client(UUID uuid, String cpf, String name, LocalDate dateOfBirth, String email, String password, ClientStatus accountStatus, OffsetDateTime createdAt, List<Account> accounts) {
        this.uuid = uuid;
        this.cpf = cpf;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.password = password;
        this.accountStatus = accountStatus;
        this.createdAt = createdAt;
        this.accounts = accounts;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
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

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }



    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(getUuid(), client.getUuid()) && Objects.equals(getCpf(), client.getCpf()) && Objects.equals(getName(), client.getName()) && Objects.equals(getDateOfBirth(), client.getDateOfBirth()) && Objects.equals(getEmail(), client.getEmail()) && Objects.equals(getPassword(), client.getPassword()) && getAccountStatus() == client.getAccountStatus() && Objects.equals(getCreatedAt(), client.getCreatedAt()) && Objects.equals(getAccounts(), client.getAccounts());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUuid(), getCpf(), getName(), getDateOfBirth(), getEmail(), getPassword(), getAccountStatus(), getCreatedAt(), getAccounts());
    }
}
