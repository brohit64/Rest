package com.javahelps.restservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.javahelps.restservice.entity.User;
import org.springframework.data.rest.core.annotation.RestResource;

@RestResource(exported=false)
public interface UserRepository extends JpaRepository<User, String> {

}

