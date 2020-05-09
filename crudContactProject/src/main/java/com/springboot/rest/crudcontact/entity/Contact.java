package com.springboot.rest.crudcontact.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="contact")
public class Contact {
	@Id
	@NotNull
	String nom;
	
	@NotNull
	String prenom;
	
	@NotNull
	String email;
	
	public Contact() {
		
	}
	public Contact(@NotNull String prenom, @NotNull String nom, @NotNull String email) {
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
