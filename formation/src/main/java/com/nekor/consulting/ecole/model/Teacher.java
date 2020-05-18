package com.nekor.consulting.ecole.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;

//import lombok.Data;;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Table(name = "professeur")
@Entity
//@Data
public class Teacher implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id", insertable = false, nullable = false)
	private String id;

	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH,
			CascadeType.REFRESH })
	@JoinTable(name = "professeur_class", 
	joinColumns = @JoinColumn(name = "professeur_id"), 
	inverseJoinColumns = @JoinColumn(name = "classe_id"))
	 @JsonIgnore
	private List<ClassRoom> classes;
	
	@OneToMany(mappedBy="teacher",
			cascade= {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
	 @JsonIgnore	
	private List<Lesson> lessons;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<ClassRoom> getClasses() {
		return classes;
	}

	public void setClasses(List<ClassRoom> classes) {
		this.classes = classes;
	}
	
	public void addClassRoom(ClassRoom classRoom) {
		if(classes==null) {
			classes = new ArrayList<>();
		}
		classes.add(classRoom);
	}
	
		public void addLesson(Lesson tempLesson) {
			if(lessons==null) {
				lessons = new ArrayList<>();
			}
			lessons.add(tempLesson);
			tempLesson.setTeacher(this);
		}

		
	
	
}
