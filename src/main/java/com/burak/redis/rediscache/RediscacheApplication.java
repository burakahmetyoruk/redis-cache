package com.burak.redis.rediscache;

import com.burak.redis.rediscache.entity.User;
import com.burak.redis.rediscache.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
@RequiredArgsConstructor
public class RediscacheApplication implements CommandLineRunner {

	private final Logger LOG = LoggerFactory.getLogger(getClass());

	private final UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(RediscacheApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//Populating embedded database here
		LOG.info("Saving users. Current user count is {}.", userRepository.count());
		User a = new User("A");
		User b = new User("B");
		User c = new User("C");
		User d = new User("D");
		User e = new User("E");
		User f = new User("F");
		User g = new User("G");

		userRepository.save(a);
		userRepository.save(b);
		userRepository.save(c);
		userRepository.save(d);
		userRepository.save(e);
		userRepository.save(f);
		userRepository.save(g);
		LOG.info("Done saving users. Data: {}.", userRepository.findAll());
	}
}
