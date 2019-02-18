package com.faizal.springrestexamples.services;

import java.util.List;

import com.faizal.springrestexamples.api.domain.User;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ApiService {

	List<User> getUsers(Integer limit);
	
	Flux<User> getUsers(Mono<Integer> limit);
}
