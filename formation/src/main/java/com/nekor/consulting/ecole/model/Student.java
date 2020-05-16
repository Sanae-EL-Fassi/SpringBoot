package com.nekor.consulting.ecole.model;

import javax.persistence.CascadeType;

//import lombok.Data;;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;

//@Data
@Entity
@Table(name = "eleve")
public class Student implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "id", insertable = false, nullable = false)
    private String id;

    @ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name="classe_id")
    private ClassRoom classRoom;
   
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

	public ClassRoom getClassRoom() {
		return classRoom;
	}

	public void setClassRoom(ClassRoom classRoom) {
		this.classRoom = classRoom;
	}
    
}
