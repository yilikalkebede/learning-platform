package com.maleda.learningplatform.service;


import com.maleda.learningplatform.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maleda.learningplatform.dto.CartRequest;
import com.maleda.learningplatform.entity.Cart;
import com.maleda.learningplatform.entity.Course;
import com.maleda.learningplatform.repository.CartRepository;
import com.maleda.learningplatform.repository.CourseRepository;
import com.maleda.learningplatform.repository.UserRepository;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CourseRepository courseRepository;

    public Cart addToCart(CartRequest cartRequest) {
        User user = userRepository.findById(cartRequest.getUserId()).orElse(null);
        Course course = courseRepository.findById(cartRequest.getCourseId()).orElse(null);

        if (user != null && course != null) {
            Cart cartItem = new Cart();
            cartItem.setUser(user);
            cartItem.setCourse(course);
            return cartRepository.save(cartItem);
        }
        return null;
    }

    public void removeFromCart(Long id) {
        cartRepository.deleteById(id);
    }
}

