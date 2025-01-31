package com.example.productcatalogservice.controller;

import com.example.productcatalogservice.model.Product;
import com.example.productcatalogservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable String id) {
        return productService.getProduct(id);
    }

    @PostMapping("/")
    public String addProduct(@RequestBody Product product) {
        productService.addProduct(product);
        return "Produkt hinzugefügt!";
    }
}
