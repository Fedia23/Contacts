package com.example.contacts.mapper;

import com.example.contacts.dto.ContactsDTO;
import com.example.contacts.entity.Contacts;
import org.springframework.stereotype.Component;

@Component
public class ContactMapper {

    public ContactsDTO mapToDTO(Contacts source) {
        ContactsDTO target = new ContactsDTO();
        target.setId(source.getId());
        target.setName(source.getName());

        return target;
    }

    public Contacts mapToEntity(ContactsDTO source) {
        Contacts target = new Contacts();
        target.setId(source.getId());
        target.setName(source.getName());

        return target;
    }
}
