package com.example.contacts.services;

import com.example.contacts.dto.ContactsDTO;
import com.example.contacts.mapper.ContactMapper;
import com.example.contacts.repository.ContactsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

import static java.util.regex.Pattern.compile;
import static java.util.stream.Collectors.toList;

@Service
@Transactional
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class ContactsService {

    private final ContactsRepository repo;
    private final ContactMapper contactMapper;

    public void save(ContactsDTO contactsDTO) {
        repo.save(contactMapper.mapToEntity(contactsDTO));
    }

    public void deleteAll() {
        this.repo.deleteAll();
    }

    public List<ContactsDTO> saveAll(List<ContactsDTO> contactsDTOs) {
        return repo.saveAll(contactsDTOs.stream().map(contactMapper::mapToEntity).collect(toList()))
                .stream()
                .map(contactMapper::mapToDTO)
                .collect(toList());
    }

    public List<String> getAllContactsName() {
        return repo.findAll().stream()
                .map(contactMapper::mapToDTO)
                .map(ContactsDTO::getName)
                .filter(Objects::nonNull)
                .distinct()
                .collect(toList());
    }

    public List<String> getContacts(String expression) {
        return this.getAllContactsName().stream()
                .filter(name -> !compile(expression).matcher(name).matches()).collect(toList());
    }

    public List<String> getContactsWithSQL(String expression) {
        return repo.findWithREGEX(expression);
    }
}
