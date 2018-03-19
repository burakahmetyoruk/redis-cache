package com.burak.redis.rediscache.controller;

import com.burak.redis.rediscache.entity.User;
import com.burak.redis.rediscache.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class UserController {

	private final Logger LOG = LoggerFactory.getLogger(getClass());

	private final UserRepository userRepository;


	@GetMapping(value = "/get/user/{userId}")
	@Cacheable(value = "users", key = "#userId", unless = "#result.id < 5",)
	public User getUser(@PathVariable String userId) {

		LOG.info("Getting user with ID {}.", userId);
		Optional<User> optUser = userRepository.findById(Long.valueOf(userId));

		User user = optUser.isPresent() ? optUser.get() : null;


		return user;
	}
}
