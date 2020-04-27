package com.nagarro.microservices.dto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nagarro.microservices.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
