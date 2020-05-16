package com.nekor.consulting.ecole.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;

//import lombok.Data;;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Table(name = "ref_matiere")
//@Data
@Entity
public class Subject implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", insertable = false, nullable = false)
    private String id;

    @Column(name = "nom")
    private String name;
    
    @OneToMany(mappedBy="subject", 
			cascade= {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JsonIgnore
	private List<Lesson> lessons;

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

	public List<Lesson> getLessons() {
		return lessons;
	}

	public void setLessons(List<Lesson> lessons) {
		this.lessons = lessons;
	}
	
	public void add(Lesson tempLesson) {
		if(lessons==null) {
			lessons = new ArrayList<>();
		}
		lessons.add(tempLesson);
		tempLesson.setSubject(this);
	}

    
    
}
