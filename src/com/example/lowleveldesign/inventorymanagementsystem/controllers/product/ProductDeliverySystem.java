package com.example.lowleveldesign.inventorymanagementsystem.controllers.product;

import com.example.lowleveldesign.inventorymanagementsystem.controllers.order.OrderController;
import com.example.lowleveldesign.inventorymanagementsystem.controllers.user.UserController;
import com.example.lowleveldesign.inventorymanagementsystem.controllers.warehouse.NearestWarehouseSelectionStrategy;
import com.example.lowleveldesign.inventorymanagementsystem.controllers.warehouse.WarehouseController;
import com.example.lowleveldesign.inventorymanagementsystem.controllers.warehouse.WarehouseSelectionCategory;
import com.example.lowleveldesign.inventorymanagementsystem.inventory.Inventory;
import com.example.lowleveldesign.inventorymanagementsystem.inventory.ProductCategory;
import com.example.lowleveldesign.inventorymanagementsystem.inventory.Warehouse;
import com.example.lowleveldesign.inventorymanagementsystem.order.Cart;
import com.example.lowleveldesign.inventorymanagementsystem.order.Order;
import com.example.lowleveldesign.inventorymanagementsystem.user.User;

import java.util.List;

public class ProductDeliverySystem {
    private UserController userController;
    private WarehouseController warehouseController;
    private OrderController orderController;

    public ProductDeliverySystem(List<User> userList, List<Warehouse> warehouseList) {
        this.userController = new UserController(userList);
        this.warehouseController = new WarehouseController(warehouseList, new NearestWarehouseSelectionStrategy());
        this.orderController = new OrderController();
    }

    public User getUser(int userId) {
        return this.userController.getUser(userId);
    }

    public Warehouse getWarehouse(WarehouseSelectionCategory warehouseSelectionCategory) {
        return this.warehouseController.selectWarehouse(warehouseSelectionCategory);
    }

    public Inventory getInventory(Warehouse warehouse) {
        return warehouse.getInventory();
    }

    public void addProductToCart(User user, ProductCategory productCategory, int count) {
        Cart cart = user.getUserCart();
        cart.addItemToCart(productCategory.getProductCategoryId(), count);
    }

    public Order placeOrder(User user, Warehouse warehouse) {
        return this.orderController.createNewOrder(user, warehouse);
    }

    public void checkout(Order order) {
        order.checkout();
    }
}
