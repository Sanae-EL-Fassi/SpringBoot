package com.springboot.rest.crudcontact.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


public class DomainUserDetailsService implements UserDetailsService {
	
    @Override 
    //it return an object UserDetails containing necessary informations for authentification such as
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    	
        List<GrantedAuthority> authorities = new ArrayList<>();
        
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority("ADMIN");
        
        authorities.add(authority);
        
        User user = new User("admin","admin", authorities);
        
        return user;
    }
}
