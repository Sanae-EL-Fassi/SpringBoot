package com.springboot.rest.crudcontact.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.springboot.rest.crudcontact.entity.Contact;

public interface ContactRepository extends JpaRepository<Contact, String> {
	long deleteByNom(String nom);

}
