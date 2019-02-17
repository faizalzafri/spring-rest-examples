package com.faizal.springrestexamples.services;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.faizal.springrestexamples.api.domain.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApiServiceImpl {

	@Autowired
	private ApiService apiService;

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGetUsers() {
		List<User> userData = apiService.getUsers(3);
		assertEquals(4, userData.size());
	}

}
