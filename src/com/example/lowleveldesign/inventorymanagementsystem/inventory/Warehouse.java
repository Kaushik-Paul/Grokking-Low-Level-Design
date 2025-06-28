package com.example.lowleveldesign.inventorymanagementsystem.inventory;

import java.util.Map;

public class Warehouse {
    private Inventory inventory;
    private String address;

    public Warehouse() {
        this.inventory = new Inventory();
    }

    public void removeItemFromInventory(Map<Integer, Integer> productCategoryAndCountMap) {
        this.inventory.removeItems(productCategoryAndCountMap);
    }

    public void addItemToInventory(Map<Integer, Integer> productCategoryAndCountMap) {
        this.inventory.addItems(productCategoryAndCountMap);
    }
}
