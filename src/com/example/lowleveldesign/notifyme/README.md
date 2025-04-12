## Problem Definition -
A **notification system** is an essential component in modern e-commerce platforms 
that allows users to be notified when products that are out of stock become 
available again. This system is particularly useful for popular products 
that sell out quickly and have customers waiting for restocking.
The notification system uses the Observer design pattern to notify 
registered users through different communication channels when a product 
becomes available again.

## Requirements - 
1. The system should allow users to subscribe for notifications when out-of-stock products become available.
2. Users should be able to receive notifications through different channels:
   - Email
   - SMS
3. The system should maintain a list of observers (subscribers) for each product.
4. When a product's stock changes from zero to a positive number, all subscribers should be notified.
5. Users should be able to unsubscribe from notifications at any time.
6. The notification should include relevant information about the product being back in stock.
7. The system should be extensible to add new notification channels in the future.
8. The system should handle stock updates efficiently, only notifying users when necessary.
9. Each notification channel should have its own implementation for sending alerts.
10. The system should be able to track the current stock count for each product.