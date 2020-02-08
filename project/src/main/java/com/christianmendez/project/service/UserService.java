package com.christianmendez.project.service;

import java.util.Map;
import java.util.Optional;

import com.christianmendez.project.entity.User;

public interface UserService {

	Optional<User> insertUser(User user,Map<String, String> headers);
	
	Boolean validateEmail(String mail);
	
	Boolean validatePassword(String password);
	
	Boolean emailExists(String mail);
}
