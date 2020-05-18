package com.nekor.consulting.ecole.model;

import javax.persistence.CascadeType;

//import lombok.Data;;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

//@Data
@Table(name = "etablissement")
@Entity
public class Establishment implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(name = "adresse")
    private String address;

    @Id
    @Column(name = "id", insertable = false, nullable = false)
    private String id;

    @Column(name = "nom")
    private String name;

    @Column(name = "ville")
    private String city;
    
    @OneToMany(mappedBy="establishment",
			cascade= {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
	 @JsonIgnore	
	private List<UserModel> userModels;


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

	public List<UserModel> getUserModes() {
		return userModels;
	}

	public void setUserModels(List<UserModel> userModels) {
		this.userModels = userModels;
	}
	
	public void addUserModel(UserModel tempUser) {
		if(userModels==null) {
			userModels = new ArrayList<>();
		}
		userModels.add(tempUser);
		tempUser.setEstablishment(this);
	}

}
