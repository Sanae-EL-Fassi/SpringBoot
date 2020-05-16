package com.springboot.rest.crudcontact.service;

import java.util.List;
import java.util.Optional;

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
	public Contact findById(String nom) {		
		Optional<Contact> result = contactRepository.findById(nom);
		Contact theContact;
		if(result.isPresent()) {
			theContact = result.get();	
		}
		else {
			throw new RuntimeException("contact not found "+nom);
		}
		return theContact;			
	}

	@Override
	public void save(Contact theContact) {
		contactRepository.save(theContact);				
	}

	@Override
	public void deleteById(String nom) {
		contactRepository.deleteById(nom);
	}


}
