package com.example.contacts.mapper;

import com.example.contacts.dto.RegexParam;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class ParamConverter implements Converter<String, RegexParam> {
    @Override
    public RegexParam convert(@Nullable String s) {
        return new RegexParam(s);
    }
}
