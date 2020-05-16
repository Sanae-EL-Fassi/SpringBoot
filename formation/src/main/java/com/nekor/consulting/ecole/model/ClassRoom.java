package com.nekor.consulting.ecole.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
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

@Table(name = "classe")
@Entity
//@Data
public class ClassRoom implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", insertable = false, nullable = false)
    private String id;

    @Column(name = "nom")
    private String name;
    
    @ManyToMany(fetch=FetchType.LAZY, 
    		cascade= {CascadeType.PERSIST, 
		    CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH}
    )
@JoinTable(name="professeur_class",
joinColumns=@JoinColumn(name="classe_id"),
inverseJoinColumns=@JoinColumn(name="professeur_id")
)
    @JsonIgnore
private List<Teacher> teachers;
    
    
    @OneToMany(mappedBy="classRoom",
			cascade= {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JsonIgnore
	private List<Lesson> lessons;
    
    
    @OneToMany(mappedBy="classRoom",
			cascade= {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JsonIgnore
	private List<Student> students;


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

	public List<Teacher> getTeachers() {
		return teachers;
	}

	public void setTeachers(List<Teacher> teachers) {
		this.teachers = teachers;
	}
	
    
		public List<Lesson> getLessons() {
		return lessons;
	}

	public void setLessons(List<Lesson> lessons) {
		this.lessons = lessons;
	}

		public void addTeacher(Teacher teacher) {
		if(teachers==null) {
			teachers = new ArrayList<>();
		}
		teachers.add(teacher);
	}
			
		public void add(Lesson tempLesson) {
			if(lessons==null) {
				lessons = new ArrayList<>();
			}
			lessons.add(tempLesson);
			tempLesson.setClassRoom(this);
		}
				
		public void add(Student tempStudent) {
			if(students==null) {
				students = new ArrayList<>();
			}
			students.add(tempStudent);
			tempStudent.setClassRoom(this);
		}
}
