package com.example.lowleveldesign.inventorymanagementsystem.inventory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Inventory {
    private List<ProductCategory> productCategoryList;

    public Inventory() {
        this.productCategoryList = new ArrayList<>();
    }

    public List<ProductCategory> getProductCategoryList() {
        return productCategoryList;
    }

    public void addProductCategory(int categoryId, String categoryName, double price) {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setProductCategoryId(categoryId);
        productCategory.setProductCategoryName(categoryName);
        productCategory.setPrice(price);
        productCategoryList.add(productCategory);
    }

    public void addProduct(Product product, int productCategoryId) {
        ProductCategory productCategory = null;

        for (ProductCategory category : productCategoryList) {
            if (category.getProductCategoryId() == productCategoryId) {
                productCategory = category;
                break;
            }
        }

        if (productCategory != null) {
            productCategory.addProduct(product);
        }
    }

    public void removeItems(Map<Integer, Integer> productCategoryAndCountMap) {
        for (Map.Entry<Integer, Integer> entry : productCategoryAndCountMap.entrySet()) {
            ProductCategory productCategory = null;
            for (ProductCategory category : productCategoryList) {
                if (category.getProductCategoryId() == entry.getKey()) {
                    productCategory = category;
                    break;
                }
            }
            if (productCategory != null) {
                productCategory.removeProduct(productCategory.getProducts().getFirst());
            }
        }
    }

    public void addItems(Map<Integer, Integer> productCategoryAndCountMap) {
        for (Map.Entry<Integer, Integer> entry : productCategoryAndCountMap.entrySet()) {
            ProductCategory productCategory = null;
            for (ProductCategory category : productCategoryList) {
                if (category.getProductCategoryId() == entry.getKey()) {
                    productCategory = category;
                    break;
                }
            }
            if (productCategory != null) {
                productCategory.addProduct(productCategory.getProducts().getFirst());
            }
        }
    }
}
