package com.nekor.consulting.ecole.model;

//import lombok.Data;;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Table(name = "utilisateur")
@Entity
//@Data
public class UserModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(name = "categorie")
    private String category;

    @Column(name = "date_naissance")
    private Date birthDate;

    @Column(name = "etablissement_id")
    private String establishmentId;

    @Id
    @Column(name = "id", insertable = false, nullable = false)
    private String id;

    @Column(name = "nom")
    private String name;

    @Column(name = "password")
    private String password;

    @Column(name = "prenom")
    private String firstName;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "utilisateur_role",
            joinColumns = {@JoinColumn(name = "utilisateur_id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id")})
    private Set<Role> roles = new HashSet<>();

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getEstablishmentId() {
        return establishmentId;
    }

    public void setEstablishmentId(String establishmentId) {
        this.establishmentId = establishmentId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
