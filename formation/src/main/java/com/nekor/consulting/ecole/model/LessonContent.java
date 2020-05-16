package com.nekor.consulting.ecole.model;

//import lombok.Data;;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDate;

@Table(name = "cours_contenu")
//@Data
@Entity
public class LessonContent implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(name = "contenu")
    private String content;

    @Column(name = "cours_id", nullable = false)
    private String lessonId;

    @Column(name = "date_creation")
    private LocalDate createDate;

    @Id
    @Column(name = "id", insertable = false, nullable = false)
    private String id;

    @Column(name = "type")
    private String type;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getLessonId() {
        return lessonId;
    }

    public void setLessonId(String lessonId) {
        this.lessonId = lessonId;
    }

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
