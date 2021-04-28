package com.example.contacts.error;

public class InvalidRegexException extends RuntimeException {
    private final String message;

    public InvalidRegexException(String msg) {
        this.message = msg;
    }

    public String getErrorMessage() {
        return message;
    }
}
