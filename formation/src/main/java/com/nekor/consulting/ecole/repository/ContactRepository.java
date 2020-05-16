package com.nekor.consulting.ecole.repository;

import com.nekor.consulting.ecole.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends JpaRepository<Contact, String> {
    Contact findByNom(String nom);
}
