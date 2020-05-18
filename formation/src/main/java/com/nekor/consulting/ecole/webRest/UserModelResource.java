package com.nekor.consulting.ecole.webRest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nekor.consulting.ecole.model.UserModel;
import com.nekor.consulting.ecole.repository.UserRepository;

@RestController
@RequestMapping("/api/user")
public class UserModelResource {
	
	@Autowired UserRepository userRepository;
	
	@PostMapping
    private void createUpdateUser(@RequestBody UserModel userModel) { 
	BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
	  userModel.setPassword(encoder.encode(userModel.getPassword()));
	  userRepository.save(userModel);
    }
  
	

}
