package com.faizal.springrestexamples.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import com.faizal.springrestexamples.api.domain.User;
import com.faizal.springrestexamples.api.domain.UserData;
import com.faizal.springrestexamples.services.ApiService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ApiServiceImpl implements ApiService {

	private RestTemplate restTemplate;

	private final String api_url;

	public ApiServiceImpl(RestTemplate restTemplate, @Value("${api.url}") String api_url) {
		this.restTemplate = restTemplate;
		this.api_url = api_url;
	}

	@Override
	public List<User> getUsers(Integer limit) {

		UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromUriString(api_url).queryParam("limit",
				limit);

		UserData userData = restTemplate.getForObject(uriComponentsBuilder.toUriString(), UserData.class);
		return userData.getData();
	}

	@Override
	public Flux<User> getUsers(Mono<Integer> limit) {

		return WebClient.create(api_url)
				.get()
				.uri(uriBuilder -> uriBuilder.queryParam("limit", limit.block()).build())
				.accept(MediaType.APPLICATION_JSON)
				.exchange()
				.flatMap(resp -> resp.bodyToMono(UserData.class))
				.flatMapIterable(UserData::getData);
	}

}
