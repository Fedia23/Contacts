package com.example.contacts.repository;

import com.example.contacts.entity.Contacts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactsRepository extends JpaRepository<Contacts, Long> {

    @Query(value = "select c.name from Contacts c where regexp_like(c.name, :regex) = true")
    List<String> findWithREGEX(@Param("regex") String regex);
}
