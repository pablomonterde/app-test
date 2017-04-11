package com.agiletdd.application.service;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.agiletdd.application.domain.InMemoryUserRepository;
import com.agiletdd.application.domain.User;
import com.agiletdd.application.domain.UserRepository;

public class DefaultUserServiceTest {

	DefaultUserService userService;
	UserRepository userRepository;
	
	@Before
	public void setUp() throws Exception {
		userRepository = new InMemoryUserRepository();
		userService = new DefaultUserService(userRepository);
	}

	@Test
	public void should_create_new_users() {
		userService.createUser("foo");
		
		User createdUser = userRepository.findAll().get(0);
		
		assertEquals("foo", createdUser.getName());
	}

}
