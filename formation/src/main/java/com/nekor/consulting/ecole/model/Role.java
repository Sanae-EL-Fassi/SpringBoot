package com.nekor.consulting.ecole.model;

//import lombok.Data;;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Table(name = "role")
@Entity
//@Data
public class Role implements GrantedAuthority {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "role", insertable = false, nullable = false)
    private String role;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String getAuthority() {
        return role;
    }
}
