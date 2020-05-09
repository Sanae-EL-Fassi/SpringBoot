package com.springboot.rest.crudcontact.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.rest.crudcontact.dao.ContactRepository;
import com.springboot.rest.crudcontact.entity.Contact;

@Service
public class ContactServiceImpl implements ContactService {
	
	@Autowired
	private ContactRepository contactRepository;

	@Override
	public List<Contact> findAll() {	
		return contactRepository.findAll();
	}

	@Override
	public Contact findByNom(String nom) {		
		return contactRepository.findByNom(nom);
	}

	@Override
	public void save(Contact theContact) {
		contactRepository.save(theContact);				
	}

	@Override
	@Transactional
	public long deleteByNom(String nom) {
		return contactRepository.deleteByNom(nom);
	}


}
