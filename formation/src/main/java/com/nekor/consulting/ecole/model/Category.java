package com.nekor.consulting.ecole.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
//@Data
@Table(name = "ref_categorie")
public class Category implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "name", insertable = false, nullable = false)
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
