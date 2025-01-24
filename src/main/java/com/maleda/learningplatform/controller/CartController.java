package com.maleda.learningplatform.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.maleda.learningplatform.dto.CartRequest;
import com.maleda.learningplatform.entity.Cart;
import com.maleda.learningplatform.service.CartService;

@RestController
@RequestMapping("/api/carts")
public class CartController {

    @Autowired
    private CartService cartService;

    @PostMapping
    public Cart addToCart(@RequestBody CartRequest cartRequest) {
        return cartService.addToCart(cartRequest);
    }

    @DeleteMapping("/{id}")
    public void removeFromCart(@PathVariable Long id) {
        cartService.removeFromCart(id);
    }
}