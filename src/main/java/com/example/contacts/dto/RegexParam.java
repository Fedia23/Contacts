package com.example.contacts.dto;

import com.example.contacts.error.InvalidRegexException;
import lombok.SneakyThrows;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

public class RegexParam {
    private String regex;

    public RegexParam(String regex) {
        checkNotEmpty(regex);

        this.setRegex(regex);
    }


    public String getRegex() {
        return regex;
    }

    @SneakyThrows
    public void setRegex(String regex) {
        this.regex = decode(regex);
    }

    private void checkNotEmpty(String regex) {
        if (regex == null || regex.trim().isEmpty()) {
            throw new InvalidRegexException("regular expression must be provided");
        }
    }

    private String decode(String regex) throws UnsupportedEncodingException {
        return URLDecoder.decode(regex, StandardCharsets.UTF_8.toString());
    }
}
