package com.example.lowleveldesign.inventorymanagementsystem.order;

import com.example.lowleveldesign.inventorymanagementsystem.inventory.Warehouse;
import com.example.lowleveldesign.inventorymanagementsystem.payment.CardPaymentMode;
import com.example.lowleveldesign.inventorymanagementsystem.payment.Invoice;
import com.example.lowleveldesign.inventorymanagementsystem.payment.Payment;
import com.example.lowleveldesign.inventorymanagementsystem.payment.PaymentMode;
import com.example.lowleveldesign.inventorymanagementsystem.user.Address;
import com.example.lowleveldesign.inventorymanagementsystem.user.User;

import java.util.Map;

public class Order {
    private int orderId;
    private User user;
    private Address deliveryAddress;
    private Map<Integer, Integer> productCategoryAndCountMap;
    private Warehouse warehouse;
    private Invoice invoice;
    private Payment payment;
    private OrderStatus orderStatus;

    public Order(User user, Warehouse warehouse) {
        this.orderId = (int) (Math.random() * 1000) + 1;
        this.user = user;
        this.warehouse = warehouse;
        this.productCategoryAndCountMap = user.getUserCart().getCartItems();
        this.deliveryAddress = user.getAddress();
        this.invoice = new Invoice();
        generateOrderInvoice();
    }

    public void checkout() {

        // 1. Update Inventory
        this.warehouse.removeItemFromInventory(this.productCategoryAndCountMap);

        // 2. Make payment
        boolean isPaymentSuccessful = makePayment(new CardPaymentMode());

        // 3. Update order status
        if (isPaymentSuccessful) {
            this.orderStatus = OrderStatus.ORDER_PLACED;
            this.user.getUserCart().emptyCart();
        } else {
            this.orderStatus = OrderStatus.UNDELIVERED;
            this.warehouse.addItemToInventory(this.productCategoryAndCountMap);
        }
    }

    public int getOrderId() {
        return orderId;
    }

    private boolean makePayment(PaymentMode paymentMode) {
        this.payment = new Payment(paymentMode);
        return this.payment.makePayment();
    }

    private void generateOrderInvoice() {
        this.invoice.generateInvoice(this);
    }
}
