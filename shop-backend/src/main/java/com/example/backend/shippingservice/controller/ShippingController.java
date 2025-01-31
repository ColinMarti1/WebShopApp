package com.example.shippingservice.controller;

import com.example.shippingservice.model.ShippingDetails;
import com.example.shippingservice.service.ShippingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/shipping")
public class ShippingController {

    @Autowired
    private ShippingService shippingService;

    @PostMapping("/calculate/{orderId}")
    public ShippingDetails calculateShipping(@PathVariable String orderId, @RequestBody String shippingAddress) {
        return shippingService.calculateShipping(orderId, shippingAddress);
    }

    @GetMapping("/tracking/{trackingNumber}")
    public ShippingDetails trackShipment(@PathVariable String trackingNumber) {
        return shippingService.trackShipment(trackingNumber);
    }
}
