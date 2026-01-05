package com.challenge.Bank.model;

import com.challenge.Bank.model.status.Status;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

public class Client implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
    private Long id;
    private String name;
    private Long cpf;
    private LocalDate dateOfBirth;
    private String email;
    private Status accountStatus = Status.Active;
    private BigDecimal currentBalance =  BigDecimal.ZERO;
    private String password;

    public Client() {
    }

    public Client(Long id, String name, Long cpf, LocalDate dateOfBirth, String email, Status accountStatus, BigDecimal currentBalance, String password) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.accountStatus = accountStatus;
        this.currentBalance = currentBalance;
        this.password = password;
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

    public Long getCpf() {
        return cpf;
    }

    public void setCpf(Long cpf) {
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

    public BigDecimal getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(BigDecimal currentBalance) {
        this.currentBalance = currentBalance;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(getId(), client.getId()) && Objects.equals(getName(), client.getName()) && Objects.equals(getCpf(), client.getCpf()) && Objects.equals(getDateOfBirth(), client.getDateOfBirth()) && Objects.equals(getEmail(), client.getEmail()) && getAccountStatus() == client.getAccountStatus() && Objects.equals(getCurrentBalance(), client.getCurrentBalance()) && Objects.equals(getPassword(), client.getPassword());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getCpf(), getDateOfBirth(), getEmail(), getAccountStatus(), getCurrentBalance(), getPassword());
    }
}
