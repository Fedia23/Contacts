package com.example.contacts.error;

public class RegexError {
    private final String errorMessage;

    public RegexError(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
