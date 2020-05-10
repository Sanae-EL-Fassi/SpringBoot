package com.springboot.rest.crudcontact.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="contact")
public class Contact {
	@Id
	@NotBlank
	String nom;
	
	@NotBlank
	String prenom;
	
	@NotBlank
	String email;
	
	public Contact() {
		
	}
	public Contact(String prenom, String nom, String email) {
		this.prenom = prenom;
		this.nom = nom;
		this.email = email;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Contact [prenom=" + prenom + ", nom=" + nom + ", email=" + email + "]";
	}
	
	
	
	

}
