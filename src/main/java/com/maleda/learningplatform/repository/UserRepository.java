package com.maleda.learningplatform.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maleda.learningplatform.entity.User;

public interface UserRepository extends JpaRepository<User, Long> { 

	User findByEmail(String email);

	User findByEmailAndPassword(String email, String password);
}
