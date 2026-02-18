package com.challenge.Bank.onboarding.DTO;

import com.challenge.Bank.Enums.AccountType;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

public class OnboardingRequestDTO {

    private String name;
    private String cpf;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate dateOfBirth;
    private String email;
    private String password;

    private AccountType type;

    public OnboardingRequestDTO() {
    }
    public OnboardingRequestDTO(String name, String cpf, LocalDate dateOfBirth, String email, String password, AccountType type) {
        this.name = name;
        this.cpf = cpf;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.password = password;
        this.type = type;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
        OnboardingRequestDTO that = (OnboardingRequestDTO) o;
        return Objects.equals(getName(), that.getName()) && Objects.equals(getCpf(), that.getCpf()) && Objects.equals(getDateOfBirth(), that.getDateOfBirth()) && Objects.equals(getEmail(), that.getEmail()) && Objects.equals(getPassword(), that.getPassword()) && getType() == that.getType();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getCpf(), getDateOfBirth(), getEmail(), getPassword(), getType());
    }
}
