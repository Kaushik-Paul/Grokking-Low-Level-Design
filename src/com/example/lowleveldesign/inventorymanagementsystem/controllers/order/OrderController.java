package com.example.lowleveldesign.inventorymanagementsystem.controllers.order;

import com.example.lowleveldesign.inventorymanagementsystem.inventory.Warehouse;
import com.example.lowleveldesign.inventorymanagementsystem.order.Order;
import com.example.lowleveldesign.inventorymanagementsystem.user.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderController {

    private List<Order> orderList;
    Map<Integer, List<Order>> userIdsVsOrders;

    public OrderController() {
        this.orderList = new ArrayList<>();
        this.userIdsVsOrders = new HashMap<>();
    }

    public Order createNewOrder(User user, Warehouse warehouse) {
        Order order = new Order(user, warehouse);
        this.orderList.add(order);

        if (this.userIdsVsOrders.containsKey(user.getUserId())) {
            this.userIdsVsOrders.get(user.getUserId()).add(order);
        } else {
            List<Order> orderList = new ArrayList<>();
            orderList.add(order);
            this.userIdsVsOrders.put(user.getUserId(), orderList);
        }
        return order;
    }

    public void removeOrder(Order order) {
        this.orderList.remove(order);
    }

    public List<Order> getOrderByCustomerId(int userId) {
        return this.userIdsVsOrders.get(userId);
    }

    public Order getOrderByOrderId(int orderId) {
        for (Order order : this.orderList) {
            if (order.getOrderId() == orderId) {
                return order;
            }
        }
        return null;
    }
}
