package com.burak.redis.rediscache.repository;

import com.burak.redis.rediscache.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Long> {
}
