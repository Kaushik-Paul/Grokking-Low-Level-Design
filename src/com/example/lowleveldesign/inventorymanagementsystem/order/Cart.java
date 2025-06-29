package com.example.lowleveldesign.inventorymanagementsystem.order;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    private Map<Integer, Integer> productCategoryAndCountMap;

    public Cart() {
        this.productCategoryAndCountMap = new HashMap<>();
    }

    public void addItemToCart(int productCategoryId, int count) {
        if (this.productCategoryAndCountMap.containsKey(productCategoryId)) {
            this.productCategoryAndCountMap.put(productCategoryId, this.productCategoryAndCountMap.get(productCategoryId) + count);
        } else {
            this.productCategoryAndCountMap.put(productCategoryId, count);
        }
    }

    public void removeItemFromCart(int productCategoryId, int count) {
        if (this.productCategoryAndCountMap.containsKey(productCategoryId)) {
            this.productCategoryAndCountMap.put(productCategoryId, this.productCategoryAndCountMap.get(productCategoryId) - count);
        }
    }

    public void emptyCart() {
        this.productCategoryAndCountMap.clear();
    }

    public Map<Integer, Integer> getCartItems() {
        return this.productCategoryAndCountMap;
    }
}
