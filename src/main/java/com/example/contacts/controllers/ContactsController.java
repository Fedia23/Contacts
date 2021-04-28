package com.example.contacts.controllers;


import com.example.contacts.dto.RegexParam;
import com.example.contacts.services.ContactsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("hello")
public class ContactsController {

    @Autowired
    private ContactsService contactsService;

    @GetMapping(value = "contacts")
    @ResponseStatus(HttpStatus.OK)
    public List<String> contacts(@RequestParam("regex") RegexParam regexParam) {
        return contactsService.getContactsWithSQL(regexParam.getRegex());
    }
}
