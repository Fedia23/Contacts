package com.example.contacts.services;

import com.example.contacts.ContactsApplication;
import com.example.contacts.dto.ContactsDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { ContactsApplication.class })
class ContactsServiceTest {

    @Autowired
    private ContactsService contactsService;

    public static final String REGEX = "^A.*$";
    public static final String REGEX2 = "^.*?[aei].*$";

    @Test
    public void testFetchContactNamesFilteredWithRegularExpression() {
        //arrange
        List<ContactsDTO> saved = contactsService.saveAll(generateContacts(1000));

        //act
        List<String> contacts = contactsService.getContacts(REGEX);
        List<String> contactsWithSQL = contactsService.getContactsWithSQL(REGEX);

        //assert
        Assertions.assertNotNull(contacts);
        Assertions.assertNotEquals(saved.size(), contacts.size());
        Assertions.assertEquals(contacts.size(), contactsWithSQL.size());
    }

    private List<ContactsDTO> generateContacts(int count) {
        List<ContactsDTO> list = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            ContactsDTO dto = new ContactsDTO();
            if (i % 2 == 1) {
                dto.setName("ATEST " + i);
            } else {
                dto.setName("TeST " + i);
            }
            list.add(dto);
        }
        return list;
    }
}