package com.example.shippingservice.service;

import com.example.shippingservice.model.ShippingDetails;
import org.springframework.stereotype.Service;

@Service
public class ShippingService {

    // Berechnung der Versandkosten und Lieferung basierend auf der Bestellung
    public ShippingDetails calculateShipping(String orderId, String shippingAddress) {
        // Dummy-Werte für Versandkosten und Lieferzeiten
        ShippingDetails shippingDetails = new ShippingDetails();
        shippingDetails.setOrderId(orderId);
        shippingDetails.setShippingAddress(shippingAddress);
        shippingDetails.setShippingCost(10.99);
        shippingDetails.setEstimatedDeliveryTime("3-5 Werktage");
        shippingDetails.setTrackingNumber("TRK12345");
        shippingDetails.setShippingStatus("Versand in Bearbeitung");

        return shippingDetails;
    }

    // Tracking der Sendung
    public ShippingDetails trackShipment(String trackingNumber) {
        // Dummy-Tracking-Informationen
        ShippingDetails shippingDetails = new ShippingDetails();
        shippingDetails.setTrackingNumber(trackingNumber);
        shippingDetails.setShippingStatus("Unterwegs");
        shippingDetails.setEstimatedDeliveryTime("3-5 Werktage");

        return shippingDetails;
    }
}
