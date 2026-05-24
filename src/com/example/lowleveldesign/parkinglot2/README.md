# Parking Lot System 2

A comprehensive parking lot management system with a clean, layered architecture demonstrating modern object-oriented design principles and patterns.

## Overview

This implementation provides a complete parking lot solution with support for multiple vehicle types, dynamic pricing, multiple payment gateways, and real-time status tracking. The system follows a layered architecture with clear separation of concerns.

## Features

### Vehicle Management
- **Multiple Vehicle Types**: Two-wheelers, Four-wheelers, and Heavy vehicles
- **Dedicated Parking Slots**: Each vehicle type has its own slot allocation
- **Vehicle Tracking**: License plate-based vehicle identification

### Parking Lot Operations
- **Multi-Floor Support**: Add and manage multiple floors
- **Dynamic Slot Allocation**: Automatic slot assignment based on vehicle type
- **Real-time Status**: Track available and occupied slots per vehicle type
- **Ticket System**: Generate tickets on entry with timestamp tracking

### Pricing System
- **Flexible Pricing Models**: 
  - Hourly rate-based pricing
  - Flat rate pricing
- **Vehicle-Specific Rates**: Different pricing for different vehicle types
- **Minimum Charge**: Ensures minimum flat rate is always applied
- **Configurable Rules**: Admin can update pricing rules dynamically

### Payment Processing
- **Multiple Payment Gateways**: Support for Razorpay and Stripe
- **Adapter Pattern**: Extensible design for adding new payment providers
- **Retry Mechanism**: Automatic retry on payment failure (configurable attempts)
- **Payment Tracking**: Record all payment attempts with status
- **Fallback Support**: Try multiple gateways if one fails

### Receipt Generation
- **Detailed Receipts**: Include ticket ID, entry/exit times, fee, and payment status
- **Payment Confirmation**: Mark receipts as paid upon successful payment

## Architecture

The system follows a layered architecture with clear separation of concerns:

```
┌─────────────────────────────────────────┐
│           Main (Simulation)             │
└─────────────────────────────────────────┘
                  │
┌─────────────────────────────────────────┐
│          Controllers                    │
│  (AdminController, EntryController,     │
│   ExitController)                       │
└─────────────────────────────────────────┘
                  │
┌─────────────────────────────────────────┐
│           Services                      │
│  (AdminService, PaymentService,         │
│   PricingService, TicketService,       │
│   SlotService, ReceiptService)         │
└─────────────────────────────────────────┘
                  │
┌─────────────────────────────────────────┐
│         Repositories                    │
│  (FloorRepository, SlotRepository,      │
│   TicketRepository, PaymentRepository,  │
│   PricingRuleRepository)               │
└─────────────────────────────────────────┘
                  │
┌─────────────────────────────────────────┐
│           Domain Models                 │
│  (Vehicle, Ticket, ParkingSlot, Floor,  │
│   Payment, Receipt, PricingRule, etc.)  │
└─────────────────────────────────────────┘
                  │
┌─────────────────────────────────────────┐
│           Adapters                      │
│  (PaymentGatewayAdapter, RazorpayAdapter,│
│   StripeAdapter)                        │
└─────────────────────────────────────────┘
```

## Package Structure

- **adapter**: Payment gateway adapters implementing the Adapter pattern
- **controller**: Request handlers for entry, exit, and admin operations
- **domain**: Core business entities and enums
- **repository**: Data access layer for persistence
- **service**: Business logic and orchestration
- **main**: Simulation and entry point

## Design Patterns Used

### Adapter Pattern
- `PaymentGatewayAdapter` interface provides a common interface for different payment gateways
- `RazorpayAdapter` and `StripeAdapter` implement the adapter interface
- Allows easy addition of new payment providers without modifying existing code

### Repository Pattern
- Separates data access logic from business logic
- Each entity has its own repository (FloorRepository, SlotRepository, etc.)
- Provides in-memory storage with CRUD operations

### Service Layer Pattern
- `AdminService`, `PaymentService`, `PricingService`, etc. encapsulate business logic
- Controllers delegate to services for complex operations
- Promotes reusability and testability

### Controller Pattern
- `AdminController`, `EntryController`, `ExitController` handle user interactions
- Coordinate between services and return simplified results
- Use inner result classes (EntryResult, ExitResult) for clean API

## Design Principles Applied

- **Single Responsibility Principle**: Each class has one clear responsibility
- **Open/Closed Principle**: Open for extension (new payment gateways), closed for modification
- **Dependency Inversion**: High-level modules depend on abstractions (interfaces)
- **Interface Segregation**: Focused interfaces (PaymentGatewayAdapter)
- **Composition over Inheritance**: Services compose repositories and adapters

## How to Run

Compile and run the simulation:

```bash
javac -d classes src/com/example/lowleveldesign/parkinglot2/main/ParkingLotSimulation.java
java -cp classes com.example.lowleveldesign.parkinglot2.main.ParkingLotSimulation
```

## Example Output

```
Initial status: {TWO_WHEELER=5 available / 5 total, FOUR_WHEELER=5 available / 5 total, HEAVY_VEHICLE=2 available / 2 total}
EntryResult{success=true, ticketId=c786d159-9b78-4b4f-afb9-227eab9002c5, slotId=d4666994-7a05-4e41-93c9-445c7be81742, message='Entry successful'}
After entry: {TWO_WHEELER=5 available / 5 total, FOUR_WHEELER=4 available / 5 total, HEAVY_VEHICLE=2 available / 2 total}
[ADAPTER] Razorpay processing payment for ticket c786d159-9b78-4b4f-afb9-227eab9002c5, amount: 80.0
ExitResult{success=true, receiptId=8bba9cfd-1298-4984-99d4-e09b5c14ae42, fee=80.0, message='Exit successful'}
After exit: {TWO_WHEELER=5 available / 5 total, FOUR_WHEELER=5 available / 5 total, HEAVY_VEHICLE=2 available / 2 total}
```

## Key Classes

### Controllers
- **AdminController**: Manages parking lot setup (floors, slots, pricing)
- **EntryController**: Handles vehicle entry and ticket generation
- **ExitController**: Handles vehicle exit, payment, and receipt generation

### Services
- **AdminService**: Core admin operations for parking lot management
- **PaymentService**: Payment processing with retry logic
- **PricingService**: Fee calculation based on duration and vehicle type
- **TicketService**: Ticket lifecycle management
- **SlotService**: Slot allocation and release
- **ReceiptService**: Receipt generation and management

### Domain Models
- **Vehicle**: Represents a vehicle with license plate and type
- **Ticket**: Parking ticket with entry time and status
- **ParkingSlot**: Individual parking space with type and occupancy
- **Floor**: Container for parking slots on a floor
- **Payment**: Payment record with gateway and status
- **Receipt**: Payment receipt with exit time and fee
- **PricingRule**: Pricing configuration for vehicle types

## Extensibility

The system is designed for easy extension:

1. **Add New Vehicle Types**: Extend `VehicleType` enum and update pricing rules
2. **Add New Payment Gateways**: Implement `PaymentGatewayAdapter` interface
3. **Add New Pricing Models**: Extend `PricingRuleType` enum
4. **Add Persistence**: Replace repository implementations with database storage
5. **Add Multiple Entry/Exit Points**: Extend controllers with location tracking

## Technology Stack

- **Java 21**: Modern Java features and syntax
- **In-Memory Storage**: Repository pattern with ArrayList-based storage
- **UUID**: Unique identifiers for tickets, slots, and receipts
- **Java Time API**: Duration and timestamp handling

## Future Enhancements

- Database persistence for production use
- Multiple entry/exit point support
- Vehicle owner registration
- Monthly/seasonal pass support
- Real-time display board integration
- Parking reservation system
- Vehicle type validation (size-based)
- Peak hour pricing
- Long-term parking discounts
