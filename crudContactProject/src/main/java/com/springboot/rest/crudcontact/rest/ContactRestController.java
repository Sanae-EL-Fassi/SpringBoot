package com.springboot.rest.crudcontact.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.springboot.rest.crudcontact.entity.Contact;
import com.springboot.rest.crudcontact.service.ContactService;

@RestController
@RequestMapping("/api/contacts")
public class ContactRestController {
	
	@Autowired
	private ContactService contactService;
	
	@GetMapping
	public List<Contact> getContacts(){
		return contactService.findAll();
	}
		
	@GetMapping("/byName")	
	public Contact getByName(@RequestParam("name")String name) {
		return contactService.findByNom(name);
	}
	
	@PutMapping	
	public void updateContact(@RequestBody Contact contact) {
		contactService.save(contact);
	}
	
	@DeleteMapping("/{nom}")
	public String deleteContact(@PathVariable String nom) {
		Contact tempContact = contactService.findByNom(nom);
		if (tempContact == null) {
			throw new RuntimeException("contact not found- " + nom);
		}
		contactService.deleteByNom(nom);
		return "Delete contact -" + nom;
	}

	
	
}	


