package com.challenge.Bank.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CpfValidator implements ConstraintValidator<ValidCpf, String> {

    @Override
    public boolean isValid(String cpf, ConstraintValidatorContext context) {

        if (cpf == null) return false;

        String cleaned = cpf.replaceAll("[^0-9]", "");

        if (cleaned.length() != 11) return false;
        if (cleaned.matches("(\\d)\\1{10}")) return false;

        int sum = 0;
        for (int i = 0; i < 9; i++)
            sum += (cleaned.charAt(i) - '0') * (10 - i);
        int first = 11 - (sum % 11);
        if (first >= 10) first = 0;
        if (first != (cleaned.charAt(9) - '0')) return false;

        sum = 0;
        for (int i = 0; i < 10; i++)
            sum += (cleaned.charAt(i) - '0') * (11 - i);
        int second = 11 - (sum % 11);
        if (second >= 10) second = 0;

        return second == (cleaned.charAt(10) - '0');
    }
}
