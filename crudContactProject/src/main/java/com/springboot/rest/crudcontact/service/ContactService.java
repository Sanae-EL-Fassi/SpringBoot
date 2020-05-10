package com.springboot.rest.crudcontact.service;

import java.util.List;
import java.util.Optional;

import com.springboot.rest.crudcontact.entity.Contact;


public interface ContactService {
	
	public List<Contact> findAll();
	public Contact findById(String nom);
	public void save(Contact theContact);
	public void deleteById(String nom);

}
