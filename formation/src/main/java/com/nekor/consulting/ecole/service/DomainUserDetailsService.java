package com.nekor.consulting.ecole.service;

import com.nekor.consulting.ecole.model.UserModel;
import com.nekor.consulting.ecole.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


public class DomainUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {
        return userRepository.findById(username)
                .map(userModel -> createUserDetail(userModel))
                .orElseThrow(() -> new UsernameNotFoundException("User with name " + username + " not found"));
    }

    private UserDetails createUserDetail(UserModel user) {
        return new User(user.getId(), user.getPassword(), user.getRoles());
    }
}
