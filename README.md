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

## Future Additions

More low-level design implementations will be added to this repository over time, covering various domains and complexity levels.
