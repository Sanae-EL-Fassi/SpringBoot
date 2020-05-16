package com.nekor.consulting.ecole.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.CascadeType;

//import lombok.Data;;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

//@Data
@Entity
@Table(name = "cours")
public class Lesson implements Serializable {
    private static final long serialVersionUID = 1L;
 
    @Column(name = "date_creation")
    @Temporal(TemporalType.DATE)
    private LocalDate createDate;

    @Id
    @Column(name = "id", insertable = false, nullable = false)
    private String id;

    @Column(name = "nom", nullable = false)
    private String name;

    @ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name="professeur_id")
    private Teacher teacher;
    
    
    @ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name="classe_id")
    private ClassRoom classRoom;
    
    @ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name="matiere_id")
    private Subject subject;


    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
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

 
	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public ClassRoom getClassRoom() {
		return classRoom;
	}

	public void setClassRoom(ClassRoom classRoom) {
		this.classRoom = classRoom;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}
	
	
	
    
}
