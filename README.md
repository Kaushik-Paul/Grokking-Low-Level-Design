# Grokking Low Level Design

This repository contains various Low Level System Design implementations with detailed requirements and expectations for each design. The project focuses on applying object-oriented design principles to create robust, maintainable, and scalable solutions for common software systems.

## Project Overview

The goal of this project is to demonstrate practical implementations of low-level design patterns and principles through real-world examples. Each implementation follows a structured approach:

1. Problem definition and requirements
2. Object-oriented analysis and design
3. Implementation with clean, maintainable code
4. Consideration of extensibility and scalability

## Implemented Systems

The repository currently includes the following system designs:

### Tic-Tac-Toe Game
A console-based implementation of the classic Tic-Tac-Toe game with support for:
- 3x3 game board
- Two players (X and O)
- Win detection
- Input validation
- [View detailed documentation](./src/com/example/lowleveldesign/tiktactoe/README.md)

### Parking Lot System
A comprehensive parking lot management system that supports:
- Multiple vehicle types (Car, Truck, Van, Motorcycle)
- Different parking spot types (Handicapped, Compact, Large, Motorcycle)
- Multiple entry and exit points
- Payment processing (Credit/Debit card, Cash)
- Display board for available spots
- [View detailed documentation](./src/com/example/lowleveldesign/parkinglot/README.md)

### Notify Me
A notification system implementation based on the Observer design pattern that:
- Allows users to subscribe to out-of-stock product notifications
- Supports multiple notification channels (Email, SMS)
- Implements the Observer pattern with Observable products and Observer users
- Provides real-time stock update notifications
- Demonstrates a flexible, extensible notification architecture
- [View detailed documentation](./src/com/example/lowleveldesign/notifyme/README.md)

### Elevator System
A multi-elevator control system that features:
- Multiple elevator cars in a building
- Internal and external request handling
- Efficient elevator dispatching algorithms
- Floor display and direction indicators
- Priority-based request processing
- [View detailed documentation](./src/com/example/lowleveldesign/elevatorsystem/README.md)

### Car Rental System
A modular car rental platform supporting:
- Multiple store locations and vehicle inventories
- Customer and store manager roles
- Reservation creation, modification, and cancellation
- Vehicle availability tracking
- Payment processing for rentals
- Support for various vehicle types and rental durations (hourly, daily, weekly)
- [View detailed documentation](./src/com/example/lowleveldesign/carrentalsytem/README.md)

### Logger System
A flexible and extensible logging utility that demonstrates the Chain of Responsibility design pattern:
- Supports multiple log levels: ERROR, DEBUG, INFO
- Processes log messages based on severity, passing unhandled messages along a processor chain
- Easily extensible to add new log levels or processors
- Provides a simple API for logging from the main application
- Includes a usage example and instructions for extension
- [View detailed documentation](./src/com/example/lowleveldesign/logger/README.md)

### Snakes and Ladders Game
A modular implementation of the classic Snakes and Ladders board game:
- Configurable square board with randomly placed snakes and ladders
- Two or more players, each starting at cell 0
- Turn-based dice rolling and movement
- Automatic handling of snakes (move down) and ladders (move up)
- First player to reach the last cell wins
- Extensible design for custom rules, board sizes, and dice
- [View detailed documentation](./src/com/example/lowleveldesign/snakenladder/README.md)

### Vending Machine System
A finite-state vending machine that:
- Accepts multiple coin denominations (penny, nickel, dime, quarter)
- Manages product inventory with coded shelves (COKE, PEPSI, JUICE, SODA)
- Handles state transitions (Idle → HasMoney → Selection → Dispense)
- Calculates and returns correct change
- Supports full refund before dispensing
- Easily extensible for new coins, products, or payment modes
- [View detailed documentation](./src/com/example/lowleveldesign/vendingmachine/README.md)

### ATM System
A comprehensive Automated Teller Machine implementation featuring:
- Card authentication with PIN verification
- Cash withdrawal with multiple denomination support
- Balance inquiry functionality
- Transaction management with receipt generation
- State pattern for managing ATM operations
- [View detailed documentation](./src/com/example/lowleveldesign/atm/README.md)

### BookMyShow LLD
An online ticket booking platform with:
- Movie search by city
- Theatre and show management
- Seat selection and booking
- Payment processing for bookings
- Extensible design for adding new features
- [View detailed documentation](./src/com/example/lowleveldesign/bookmyshow/README.md)

### Inventory Management System
A comprehensive system for tracking and managing inventory with features like:
- Product management with SKU and stock level tracking
- Purchase and sales order processing
- Real-time inventory control and alerts
- Role-based user access control
- Reporting and analytics
- Built with Java 21 and following SOLID principles
- [View detailed documentation](./src/com/example/lowleveldesign/inventorymanagementsystem/README.md)

### Null Pointer System
An implementation of the Null Object Pattern that demonstrates:
- Safe handling of null references
- Clean client code without null checks
- Default/neutral behavior for missing objects
- Vehicle type system with null object implementation
- Factory pattern for object creation
- [View detailed documentation](./src/com/example/lowleveldesign/nullpointersystem/README.md)

### Composite Pattern
A demonstration of the Composite design pattern with two implementations:
1. **Calculator**
   - Represents arithmetic expressions as a tree structure
   - Supports basic operations (+, -, *, /)
   - Enables uniform treatment of simple and complex expressions

2. **File System**
   - Models hierarchical file system with files and directories
   - Demonstrates recursive operations on composite structures
   - Shows how to treat individual and composite objects uniformly

- [View detailed documentation](./src/com/example/lowleveldesign/compositepattern/README.md)

### Adapter Design Pattern
A practical implementation of the Adapter pattern that:
- Bridges incompatible interfaces (pounds to kilograms)
- Demonstrates object composition for interface adaptation
- Follows Open/Closed Principle for extension
- Includes a concrete weight machine example
- Shows clean client usage with no modification to existing code
- [View detailed documentation](./src/com/example/lowleveldesign/adapterdesignpattern/README.md)

## How to Use

Each implementation is contained in its own package under `src/com/example/lowleveldesign/`. 
Some implementations include their own README files with specific requirements and design considerations.

To run any implementation, navigate to its main class and execute it.

## Design Principles Applied

- Single Responsibility Principle
- Open/Closed Principle
- Liskov Substitution Principle
- Interface Segregation Principle
- Dependency Inversion Principle
- Composition over Inheritance
- Encapsulation and Information Hiding

**Design Patterns Demonstrated:**
- Chain of Responsibility (Logger System)
- Composite (Calculator, File System)
- Null Object (Null Pointer System)
- Observer (Notify Me)
- Factory (Tic-Tac-Toe, Elevator System, Car Rental System)
- Singleton (Elevator System Dispatchers)
- Command (Elevator System)
- State (Vending Machine)

See individual module READMEs for more details on the specific patterns and principles used.

## Future Additions

More low-level design implementations will be added to this repository over time, covering various domains and complexity levels.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
