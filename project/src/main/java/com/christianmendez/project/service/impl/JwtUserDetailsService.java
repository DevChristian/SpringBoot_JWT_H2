package com.christianmendez.project.service.impl;

import java.util.ArrayList;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.christianmendez.project.repository.UserRepository;

/**
* This service is responsible for validating that the user exists in the database and generating the token
*
* @author  Christian Mendez
* @version 1.0
* @since   2020-02-07 
*/

@Service
public class JwtUserDetailsService implements UserDetailsService {
	
	private final static Logger LOGGER = Logger.getLogger(JwtUserDetailsService.class.getName());

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    	
    	LOGGER.info("Find the user in the DB");
    	
    	com.christianmendez.project.entity.User user =  userRepository.findByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with email: " + email);
        }
        
        LOGGER.info("User obtained");
        
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),
                new ArrayList<>());
    }

}