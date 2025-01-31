package com.example.inventoryservice.service;

import com.example.inventoryservice.model.InventoryItem;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

@Service
public class InventoryService {

    private final Map<String, InventoryItem> inventory = new HashMap<>();

    // Beispiel: Initialer Lagerbestand
    public InventoryService() {
        InventoryItem item1 = new InventoryItem();
        item1.setProductId("P001");
        item1.setProductName("Produkt 1");
        item1.setStock(100);

        InventoryItem item2 = new InventoryItem();
        item2.setProductId("P002");
        item2.setProductName("Produkt 2");
        item2.setStock(50);

        inventory.put("P001", item1);
        inventory.put("P002", item2);
    }

    public List<InventoryItem> getAllItems() {
        return new ArrayList<>(inventory.values());
    }

    public InventoryItem getItemById(String productId) {
        return inventory.get(productId);
    }

    public void updateStock(String productId, int quantity) {
        InventoryItem item = inventory.get(productId);
        if (item != null) {
            int newStock = item.getStock() - quantity;
            if (newStock >= 0) {
                item.setStock(newStock);
            } else {
                throw new IllegalArgumentException("Nicht genügend Bestand!");
            }
        }
    }
}
