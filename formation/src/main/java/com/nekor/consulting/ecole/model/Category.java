package com.nekor.consulting.ecole.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
//@Data
@Table(name = "ref_categorie")
public class Category implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "name", insertable = false, nullable = false)
    private String name;
    

	@OneToMany(mappedBy="category",
			cascade= {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
	 @JsonIgnore	
	private List<UserModel> usersModel;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

	public List<UserModel> getUsersModel() {
		return usersModel;
	}

	public void setUsersModel(List<UserModel> usersModel) {
		this.usersModel = usersModel;
	}
    
	public void addUser(UserModel tempUser) {
		if(usersModel==null) {
			usersModel = new ArrayList<>();
		}
		usersModel.add(tempUser);
		tempUser.setCategory(this);
	}

    
}
