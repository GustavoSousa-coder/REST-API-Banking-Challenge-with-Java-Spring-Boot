package com.challenge.Bank.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class Conflict extends RuntimeException {
    public Conflict(String message) {
        super(message);
    }
}
