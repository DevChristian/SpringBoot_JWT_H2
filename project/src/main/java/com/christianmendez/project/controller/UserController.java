package com.christianmendez.project.controller;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.christianmendez.project.entity.User;
import com.christianmendez.project.service.UserService;

/**
* This controller obtains the request sent by the client to be persisted.
*
* @author  Christian Mendez
* @version 1.0
* @since   2020-02-07 
*/

@RestController
public class UserController {
	
	private final static Logger LOGGER = Logger.getLogger(UserController.class.getName());
	
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/register", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public ResponseEntity<Map<String, Object>> registroUsuario(@RequestBody User user, @RequestHeader Map<String, String> headers) {
		
		 LOGGER.info("Obtained the request from client");
		 
		 Optional<User> userFinal = userService.insertUser(user, headers);
		 
		 Map<String, Object> finalResponse = new LinkedHashMap<>();
		 finalResponse.put("mensaje",userFinal);
		 
		 LOGGER.info("Return finalResponse");
		 
		 return new ResponseEntity<>(finalResponse, HttpStatus.OK);
	}
}