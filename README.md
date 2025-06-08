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

### Parking Lot System
A comprehensive parking lot management system that supports:
- Multiple vehicle types (Car, Truck, Van, Motorcycle)
- Different parking spot types (Handicapped, Compact, Large, Motorcycle)
- Multiple entry and exit points
- Payment processing (Credit/Debit card, Cash)
- Display board for available spots

### Notify Me
A notification system implementation based on the Observer design pattern that:
- Allows users to subscribe to out-of-stock product notifications
- Supports multiple notification channels (Email, SMS)
- Implements the Observer pattern with Observable products and Observer users
- Provides real-time stock update notifications
- Demonstrates a flexible, extensible notification architecture

### Elevator System
A multi-elevator control system that features:
- Multiple elevator cars in a building
- Internal and external request handling
- Efficient elevator dispatching algorithms
- Floor display and direction indicators
- Priority-based request processing

### Car Rental System
A modular car rental platform supporting:
- Multiple store locations and vehicle inventories
- Customer and store manager roles
- Reservation creation, modification, and cancellation
- Vehicle availability tracking
- Payment processing for rentals
- Support for various vehicle types and rental durations (hourly, daily, weekly)

### Logger System
A flexible and extensible logging utility that demonstrates the Chain of Responsibility design pattern:
- Supports multiple log levels: ERROR, DEBUG, INFO
- Processes log messages based on severity, passing unhandled messages along a processor chain
- Easily extensible to add new log levels or processors
- Provides a simple API for logging from the main application
- Includes a usage example and instructions for extension

### Snakes and Ladders Game
A modular implementation of the classic Snakes and Ladders board game:
- Configurable square board with randomly placed snakes and ladders
- Two or more players, each starting at cell 0
- Turn-based dice rolling and movement
- Automatic handling of snakes (move down) and ladders (move up)
- First player to reach the last cell wins
- Extensible design for custom rules, board sizes, and dice

### BookMyShow LLD
An online ticket booking platform with:
- Movie search by city
- Theatre and show management
- Seat selection and booking
- Payment processing for bookings
- Extensible design for adding new features

### Null Pointer System
An implementation of the Null Object Pattern that demonstrates:
- Safe handling of null references
- Clean client code without null checks
- Default/neutral behavior for missing objects
- Vehicle type system with null object implementation
- Factory pattern for object creation

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
- Command, State (Elevator System)

See individual module READMEs for more details on the specific patterns and principles used.

## Future Additions

More low-level design implementations will be added to this repository over time, covering various domains and complexity levels.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

```
MIT License

Copyright (c) 2025 Kaushik Paul

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```
