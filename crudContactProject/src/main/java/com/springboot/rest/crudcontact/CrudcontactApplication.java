package com.springboot.rest.crudcontact;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class CrudcontactApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudcontactApplication.class, args);
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		System.out.println(passwordEncoder.encode("admin"));
	}

}
