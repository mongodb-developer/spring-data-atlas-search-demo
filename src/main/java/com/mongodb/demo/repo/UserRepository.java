package com.mongodb.demo.repo;

import com.mongodb.demo.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UserRepository extends MongoRepository<User, String>{

    List<User> findByName(String name);
}
