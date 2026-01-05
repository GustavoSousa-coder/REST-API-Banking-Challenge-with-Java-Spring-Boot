package com.challenge.Bank.DTO.response;

import com.challenge.Bank.model.status.Status;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

public class ClientResponseDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
    private Long id;
    private String name;
    private Long cpf;
    private LocalDate dateOfBirth;
    private String email;
    private Status accountStatus;
    private BigDecimal currentBalance;
    private String password;

    public ClientResponseDTO() {
    }
    public ClientResponseDTO(Long id, String name, Long cpf, LocalDate dateOfBirth, String email, Status accountStatus, BigDecimal currentBalance, String password) {
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
        ClientResponseDTO that = (ClientResponseDTO) o;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getName(), that.getName()) && Objects.equals(getCpf(), that.getCpf()) && Objects.equals(getDateOfBirth(), that.getDateOfBirth()) && Objects.equals(getEmail(), that.getEmail()) && getAccountStatus() == that.getAccountStatus() && Objects.equals(getCurrentBalance(), that.getCurrentBalance()) && Objects.equals(getPassword(), that.getPassword());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getCpf(), getDateOfBirth(), getEmail(), getAccountStatus(), getCurrentBalance(), getPassword());
    }
}
