package com.nekor.consulting.ecole.model;

//import lombok.Data;;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

//@Data
@Table(name = "ref_contenu_type")
@Entity
public class ContentType implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "type", insertable = false, nullable = false)
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
