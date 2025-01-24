package com.maleda.learningplatform.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maleda.learningplatform.entity.Cart;

public interface CartRepository extends JpaRepository<Cart, Long> {
}

