package com.challenge.Bank.Enums;

public enum KeyType {
    CPF("^[0-9]{11}$"),
    CNPJ("^[0-9]{14}$"),
    PHONE_NUMBER("^\\+[1-9][0-9]{1,14}$"),
    EMAIL("^[A-Za-z0-9+_.-]+@(.+)$"),
    ALEATORY_KEY("^[0-9a-f]{8}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{12}$");

    private final String pattern;

    KeyType(String pattern) {
        this.pattern = pattern;
    }

    public boolean validate(String value) {
        return value != null && value.matches(this.pattern);
    }
}
