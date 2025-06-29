package com.example.lowleveldesign.inventorymanagementsystem;

import com.example.lowleveldesign.inventorymanagementsystem.controllers.product.ProductDeliverySystem;
import com.example.lowleveldesign.inventorymanagementsystem.controllers.warehouse.NearestWarehouseSelectionStrategy;
import com.example.lowleveldesign.inventorymanagementsystem.inventory.Inventory;
import com.example.lowleveldesign.inventorymanagementsystem.inventory.Product;
import com.example.lowleveldesign.inventorymanagementsystem.inventory.ProductCategory;
import com.example.lowleveldesign.inventorymanagementsystem.inventory.Warehouse;
import com.example.lowleveldesign.inventorymanagementsystem.order.Order;
import com.example.lowleveldesign.inventorymanagementsystem.user.Address;
import com.example.lowleveldesign.inventorymanagementsystem.user.User;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args){
        Main mainObj = new Main();

        //1. create warehouses in the system
        List<Warehouse> warehouseList = new ArrayList<>();
        warehouseList.add(mainObj.addWarehouseAndItsInventory());

        //2. create users in the system
        List<User> userList = new ArrayList<>();
        userList.add(mainObj.createUser());

        //3. feed the system with the initial informations
        ProductDeliverySystem productDeliverySystem = new ProductDeliverySystem(userList, warehouseList);


        mainObj.runDeliveryFlow(productDeliverySystem, 1);
    }



    private Warehouse addWarehouseAndItsInventory(){

        Warehouse warehouse = new Warehouse();

        Inventory inventory = new Inventory();

        inventory.addProductCategory(0001, "Peppsii Large Cold Drink" , 100);
        inventory.addProductCategory(0004, "Doovee small Soap" , 50);

        //CREATE 3 Products

        Product product1 = new Product();
        product1.setProductId(1);
        product1.setProductName("Peepsii");

        Product product2 = new Product();
        product2.setProductId(2);
        product2.setProductName("Peepsii");

        Product product3 = new Product();
        product1.setProductId(3);
        product1.setProductName("Doovee");


        inventory.addProduct(product1, 0001);
        inventory.addProduct(product2, 0001);
        inventory.addProduct(product3, 0004);

        warehouse.setInventory(inventory);
        return warehouse;
    }


    private User createUser(){
        User user = new User();
        user.setUserId(1);
        user.setUserName("SJ");
        user.setAddress(new Address("city", "state", "country", 1234));
        return user;
    }

    private void runDeliveryFlow(ProductDeliverySystem productDeliverySystem, int userId){


        //1. Get the user object
        User user = productDeliverySystem.getUser(userId);

        //2. get warehouse based on user preference
        Warehouse warehouse = productDeliverySystem.getWarehouse(new NearestWarehouseSelectionStrategy());

        //3. get all the inventory to show the user
        Inventory inventory = productDeliverySystem.getInventory(warehouse);

        ProductCategory productCategoryIWantToOrder = null;
        for(ProductCategory productCategory : inventory.getProductCategoryList()){

            if(productCategory.getProductCategoryName().equals("Peppsii Large Cold Drink")){
                productCategoryIWantToOrder = productCategory;
            }
        }


        //4. add product to the cart
        assert productCategoryIWantToOrder != null;
        productDeliverySystem.addProductToCart(user, productCategoryIWantToOrder, 2);

        //4. place order
        Order order = productDeliverySystem.placeOrder(user, warehouse);

        //5. checkout
        productDeliverySystem.checkout(order);

    }

}
