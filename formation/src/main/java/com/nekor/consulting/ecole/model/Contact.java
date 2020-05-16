package com.nekor.consulting.ecole.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
@Table(name = "contact")
public class Contact {
    @Id
    @Column(name = "email")
    @Size(max = 255)
    private String mail;

    @Column(name = "nom")
    @NotBlank
    @Size(max = 45)
    private String nom;

    @JsonIgnore
    @NotBlank
    @Column(name = "prenom")
    @Size(max = 45)
    private String prenom;


    public Contact() {
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return mail.equals(contact.mail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mail);
    }

    @Override
    public String toString() {
        return "Contact{" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", mail='" + mail + '\'' +
                '}';
    }
}
