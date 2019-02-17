package com.faizal.springrestexamples.services;

import java.util.List;

import com.faizal.springrestexamples.api.domain.User;

public interface ApiService {

	List<User> getUsers(Integer limit);
}
