package com.christianmendez.project.controller;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.util.ReflectionTestUtils;

import static org.mockito.Mockito.*;

import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import com.christianmendez.project.entity.Phones;
import com.christianmendez.project.entity.User;
import com.christianmendez.project.exception.ExistsEmailException;
import com.christianmendez.project.exception.InvalidFormatEmailException;
import com.christianmendez.project.exception.InvalidFormatPasswordException;
import com.christianmendez.project.repository.PhonesRepository;
import com.christianmendez.project.repository.UserRepository;
import com.christianmendez.project.service.impl.UserServiceImpl;


public class UserControllerTest {
	
	private static User user;
	private static Phones phones;
	private static UserController userController;
	private static UserServiceImpl userServiceImpl;
	private static Map<String,String> headers;
	
	@Autowired
	private static UserRepository userRepository;
	
	@Autowired
	private static PhonesRepository phonesRepository;
	
	@BeforeAll
	static void setUp() {
		user = new User();
		phones = new Phones();
		userController = new UserController();
		userServiceImpl = new UserServiceImpl();
		headers = new LinkedHashMap<>();
		userRepository = Mockito.mock(UserRepository.class);
		phonesRepository = Mockito.mock(PhonesRepository.class);
		user.setId("1");
		user.setName("Christian Mendez");
		user.setEmail("test@test.org");
		user.setPassword("passwordTest12");
		
		phones.setCitycode(1);
		phones.setCountrycode(2);
		phones.setNumber(3);
		
		Set<Phones> phoneSet = new HashSet<Phones>();
		phoneSet.add(phones);
		
		user.setPhones(phoneSet);
		
		headers.put("authorization", "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJjaHJpc3RpYW5AbWVuZGV6Lm9yZyIsImV4cCI6MTU4MTE1MDExNCwiaWF0IjoxNTgxMTMyMTE0fQ.BxoG4YRCenYRlm31lGwplTmeCwU2hP9CzV41sizeICNxTFyXKBrqtu0dVbULI_xJuKsVQUF0Ob1AySlQm8aXBw");
		
		
	}
	
	@Test
	public void registerTest() {
		ReflectionTestUtils.setField(userServiceImpl, "userRepository", userRepository);
		ReflectionTestUtils.setField(userServiceImpl, "phonesRepository", phonesRepository);
		ReflectionTestUtils.setField(userController, "userService", userServiceImpl);
		
		when(userRepository.findByEmail(user.getEmail())).thenReturn(null);
		when(userRepository.findById(user.getId())).thenReturn(Optional.of(user));
		user.setPassword("Hunter21");
		userController.registroUsuario(user, headers);
	}
	
	@Test
	public void exceptionExistsMailTest() {
		ReflectionTestUtils.setField(userServiceImpl, "userRepository", userRepository);
		ReflectionTestUtils.setField(userServiceImpl, "phonesRepository", phonesRepository);
		ReflectionTestUtils.setField(userController, "userService", userServiceImpl);
		
		
		when(userRepository.findByEmail(user.getEmail())).thenReturn(new User());
		
		Assertions.assertThrows(ExistsEmailException.class, () -> {
			userController.registroUsuario(user, headers);
		});
		
	}
	
	@Test
	public void exceptionInvalidFormatPasswordTest() {
		ReflectionTestUtils.setField(userServiceImpl, "userRepository", userRepository);
		ReflectionTestUtils.setField(userServiceImpl, "phonesRepository", phonesRepository);
		ReflectionTestUtils.setField(userController, "userService", userServiceImpl);
		
		
		when(userRepository.findByEmail(user.getEmail())).thenReturn(null);
		
		Assertions.assertThrows(InvalidFormatPasswordException.class, () -> {
			user.setPassword("test");
			userController.registroUsuario(user, headers);
		});
		
	}
	
	@Test
	public void exceptionInvalidFormatEmailTest() {
		ReflectionTestUtils.setField(userServiceImpl, "userRepository", userRepository);
		ReflectionTestUtils.setField(userServiceImpl, "phonesRepository", phonesRepository);
		ReflectionTestUtils.setField(userController, "userService", userServiceImpl);
		
		Assertions.assertThrows(InvalidFormatEmailException.class, () -> {
			user.setEmail("@test");
			userController.registroUsuario(user, headers);
		});
		
	}

}
