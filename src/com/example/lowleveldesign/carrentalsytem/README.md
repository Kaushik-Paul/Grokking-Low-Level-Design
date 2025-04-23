## Problem Definition
A **Car Rental System** is a platform that allows customers to search, reserve, and rent vehicles from various locations for specific periods. The system manages vehicle inventory, reservations, payments, and user accounts for both customers and store managers. It also tracks vehicle availability, rental status, and supports different vehicle types and rental plans.

## Requirements
1. **Vehicle Inventory**: Manage multiple types of vehicles (car, van, bike, etc.) at various store locations.
2. **Store Locations**: Support for multiple rental stores, each with its own inventory.
3. **User Roles**: Two main user types: Customer and Store Manager.
4. **Reservations**: Customers can search, reserve, modify, and cancel vehicle reservations.
5. **Payments**: Support payment processing for completed rentals.
6. **Rental Status**: Track status of vehicles (available, reserved, rented, maintenance).
7. **Reservation Types**: Allow hourly, daily, and weekly rentals.
8. **Notifications**: Notify users on reservation confirmation, cancellation, and reminders.
9. **Error Handling**: Handle invalid operations and provide appropriate feedback.

## System Design

### Class Structure
- **Main**: Entry point to the application.
- **Store**: Represents a rental store with location and inventory.
- **StoreLocation**: Details about the store's address and contact info.
- **Vehicle**: Base class for all vehicles; subclasses for specific vehicle types.
- **Reservation**: Handles reservation details, status, and type.
- **ReservationType**: Enum for rental duration (hourly, daily, weekly).
- **ReservationStatus**: Enum for reservation state (active, cancelled, completed).
- **User**: Base class for system users.
- **Customer**: Extends User; can search, reserve, and rent vehicles.
- **StoreManager**: Extends User; manages inventory and reservations.
- **Payment**: Handles payment processing and status.

### Design Patterns Used
- **Factory Pattern**: For creating vehicle and reservation instances.
- **Strategy Pattern**: For different pricing and payment calculation strategies.
- **MVC**: Separation of data models, business logic, and user interface.

### System Flow
1. The customer searches for available vehicles at a store location.
2. The customer creates a reservation for a selected vehicle and rental period.
3. The system updates vehicle status and reservation records.
4. Upon vehicle pickup, the reservation is activated.
5. Payment is processed at the end of the rental period.
6. The store manager can manage vehicle inventory and oversee reservations.

## How to Use
1. Run the `Main` class to start the system.
2. Customers can search for vehicles, make reservations, and manage their bookings.
3. Store managers can add/remove vehicles and manage reservations.
4. Payments are processed upon rental completion.
5. The system provides notifications for reservation status and reminders.

---
This project demonstrates a modular, object-oriented approach to designing a scalable Car Rental System. Refer to the code for further implementation details and class responsibilities.
