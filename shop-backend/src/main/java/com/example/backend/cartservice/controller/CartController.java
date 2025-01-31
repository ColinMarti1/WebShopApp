package com.example.cartservice.controller;

import com.example.cartservice.model.Cart;
import com.example.cartservice.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @PostMapping("/add")
    public String addProductToCart(@RequestBody Cart product) {
        cartService.addProductToCart(product);
        return "Produkt hinzugefügt!";
    }

    @GetMapping("/total")
    public double getCartTotal() {
        return cartService.getTotalPrice();
    }

    @GetMapping("/")
    public Cart getCart() {
        return cartService.getCart();
    }
}
