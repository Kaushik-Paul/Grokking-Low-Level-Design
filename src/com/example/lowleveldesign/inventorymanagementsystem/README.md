## Problem Definition

An **Inventory Management System** is a crucial component for businesses to track and manage their stock levels, orders, sales, and deliveries. This system helps businesses maintain optimal inventory levels, prevent stockouts, and streamline their supply chain operations.

## Requirements

1. **Product Management**:
   - Add, update, and remove products from inventory
   - Track product details (name, SKU, price, quantity, category)
   - Set minimum stock level alerts

2. **Order Processing**:
   - Create and manage purchase orders
   - Process sales orders
   - Track order status (pending, shipped, delivered, cancelled)

3. **Inventory Control**:
   - Real-time stock level tracking
   - Automatic stock replenishment alerts
   - Batch and expiry date tracking

4. **User Management**:
   - Role-based access control (Admin, Manager, Staff)
   - User authentication and authorization

5. **Reporting**:
   - Generate inventory reports
   - Sales and purchase history
   - Low stock alerts

## System Design

### Class Structure

1. **Core Components**:
   - **Product**: Represents items in inventory with details like name, SKU, price, quantity
   - **Inventory**: Manages the collection of products and stock levels
   - **Order**: Handles both purchase and sales orders
   - **User**: Manages system users and their roles
   - **Payment**: Handles payment processing for orders

2. **Controllers**:
   - **ProductController**: Manages product-related operations
   - **OrderController**: Handles order processing
   - **UserController**: Manages user authentication and authorization
   - **PaymentController**: Processes payments for orders

### Design Patterns Used

1. **MVC (Model-View-Controller)**:
   - Separates data models, business logic, and presentation
   - Improves code organization and maintainability

2. **Factory Pattern**:
   - Used for creating different types of orders (purchase/sales)
   - Simplifies object creation logic

3. **Observer Pattern**:
   - Notifies interested parties about inventory changes
   - Used for low stock alerts and order status updates

4. **Singleton Pattern**:
   - Ensures single instances of critical services like Inventory and Payment

## How to Use

1. **Setup**:
   - Ensure Java 21 is installed
   - Clone the repository
   - Navigate to the project directory

2. **Running the Application**:
   ```bash
   javac Main.java
   java Main
   ```

3. **Features**:
   - Add/View/Update products
   - Create and manage orders
   - Process payments
   - Generate reports

## Extensibility & Enhancements

1. **Database Integration**:
   - Add persistent storage using databases like MySQL or MongoDB

2. **REST API**:
   - Expose system functionality through RESTful endpoints

3. **UI/UX**:
   - Develop a web or desktop interface
   - Implement real-time updates using WebSockets

4. **Advanced Features**:
   - Barcode/QR code scanning
   - Multi-warehouse support
   - Supplier management
   - Automated reordering

## Example Usage

```java
// Initialize inventory and add products
Inventory inventory = Inventory.getInstance();
Product laptop = new Product("Laptop", "LP001", 999.99, 10);
inventory.addProduct(laptop);

// Create an order
Order order = new Order(OrderType.PURCHASE, "SUP001");
order.addItem(laptop, 2);

// Process payment
PaymentProcessor processor = new PaymentProcessor();
processor.processPayment(order, 1999.98, PaymentType.CREDIT_CARD);

// Update inventory
order.completeOrder();
```

## Contributing

Contributions are welcome! Please feel free to submit a Pull Request.
