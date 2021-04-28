package com.example.contacts.controllers;

import com.example.contacts.error.InvalidRegexException;
import com.example.contacts.error.RegexError;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class ContactsControllerAdvice {

    @ExceptionHandler(InvalidRegexException.class)
    public
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    RegexError handleError(HttpServletRequest req, InvalidRegexException ex) {
        return new RegexError(ex.getErrorMessage());
    }
}
