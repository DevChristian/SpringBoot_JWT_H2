package com.christianmendez.project.service.impl;


import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Optional;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.christianmendez.project.entity.Phones;
import com.christianmendez.project.entity.User;
import com.christianmendez.project.exception.ExistsEmailException;
import com.christianmendez.project.exception.InvalidFormatEmailException;
import com.christianmendez.project.exception.InvalidFormatPasswordException;
import com.christianmendez.project.repository.PhonesRepository;
import com.christianmendez.project.repository.UserRepository;
import com.christianmendez.project.service.UserService;
import com.christianmendez.project.util.ConstantsEnum;

/**
* This service is responsible for persisting the data sent from the controller
*
* @author  Christian Mendez
* @version 1.0
* @since   2020-02-07 
*/

@Service
public class UserServiceImpl implements UserService{

	private final static Logger LOGGER = Logger.getLogger(UserServiceImpl.class.getName());
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	PhonesRepository phonesRepository;
	
	@Override
	public Optional<User> insertUser(User user, Map<String, String> headers) {
		
		LOGGER.info("Begins to persist the user: " + user.getEmail().toString());
		
		if(!validateEmail(user.getEmail())) {
			throw new InvalidFormatEmailException();
		}else if(emailExists(user.getEmail())) {
			throw new ExistsEmailException();
		}else if(!validatePassword(user.getPassword())) {
			throw new InvalidFormatPasswordException();
		}
		
		user.setToken(headers.get("authorization").substring(7));
		user.setCreated(new Date());
		user.setLast_login(user.getCreated());
		user.setIsactive(true);
		String encodedPassword = new BCryptPasswordEncoder().encode(user.getPassword());
		user.setPassword(encodedPassword);
		
		userRepository.save(user);
		
		LOGGER.info("User persisted successfully");
		
		for (Iterator<Phones> it = user.getPhones().iterator(); it.hasNext(); ) {
			Phones f = it.next();
			f.setId_user(user.getId());
		}
		
		phonesRepository.saveAll(user.getPhones());
		
		LOGGER.info("Phones persisted successfully");
		
		Optional<User> userFinal = userRepository.findById(user.getId());
		
		return userFinal;
	}


	@Override
	public Boolean validateEmail(String mail) {
		String regex = ConstantsEnum.REGEXEMAIL.toString();
	    return mail.matches(regex);
	}


	@Override
	public Boolean validatePassword(String password) {
		String regex = ConstantsEnum.REGEXPASSWORD.toString();
		return password.matches(regex);
	}


	@Override
	public Boolean emailExists(String mail) {
		User user = userRepository.findByEmail(mail);
		return user != null;
	}

}
