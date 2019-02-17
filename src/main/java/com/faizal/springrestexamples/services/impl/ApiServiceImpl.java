package com.faizal.springrestexamples.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.faizal.springrestexamples.api.domain.User;
import com.faizal.springrestexamples.api.domain.UserData;
import com.faizal.springrestexamples.services.ApiService;

@Service
public class ApiServiceImpl implements ApiService {

	private RestTemplate restTemplate;

	public ApiServiceImpl(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	@Override
	public List<User> getUsers(Integer limit) {

		UserData userData = restTemplate.getForObject("http://apifaketory.com/api/user?limit=" + String.valueOf(limit),
				UserData.class);
		return userData.getData();
	}

}
