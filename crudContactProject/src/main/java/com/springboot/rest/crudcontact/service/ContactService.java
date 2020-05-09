package com.springboot.rest.crudcontact.service;

import java.util.List;

import com.springboot.rest.crudcontact.entity.Contact;


public interface ContactService {
	
	public List<Contact> findAll();
	public Contact findByNom(String nom);
	public void save(Contact theContact);
	public long deleteByNom(String nom);

}
