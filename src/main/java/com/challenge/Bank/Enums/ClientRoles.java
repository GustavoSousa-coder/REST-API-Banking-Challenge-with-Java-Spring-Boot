package com.challenge.Bank.Enums;

import lombok.Getter;

@Getter
public enum ClientRoles {
    CLIENT("CLIENT"),
    ADMIN("ADMIN");

    private final String role;

    ClientRoles(String role) {
        this.role = role;
    }

}
