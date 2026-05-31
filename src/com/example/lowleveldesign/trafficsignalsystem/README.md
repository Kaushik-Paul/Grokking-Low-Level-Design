# Traffic Signal System LLD - Java

A comprehensive traffic signal management system demonstrating state pattern, layered architecture, and real-time traffic control logic.

## Overview

This traffic signal system simulates and manages traffic intersections with support for automatic signal cycling, dynamic timing adjustment based on traffic volume, and emergency vehicle priority. It demonstrates the application of several design patterns including State, Strategy, and Layered Architecture (Controller-Service-Repository).

## Features

- **Automatic Signal Cycling**: Four-directional traffic lights with automatic phase transitions (NORTH → EAST → SOUTH → WEST)
- **Dynamic Timing**: Adjusts green light duration based on real-time vehicle count
- **Emergency Priority**: Emergency vehicles can override normal cycles and get immediate green signal
- **State Pattern**: Traffic light states (RED, YELLOW, GREEN, OFF) with valid transition enforcement
- **Layered Architecture**: Clean separation with Controller, Service, and Repository layers
- **Real-time Monitoring**: Track intersection status, signal timing, and traffic counts
- **Extensible Design**: Easy to add new directions, timing strategies, or signal behaviors

## Architecture

### Core Components

- **TrafficLight**: Represents a single traffic light with state management using State pattern
- **TrafficLightState**: Interface for light states (RedState, YellowState, GreenState, OffState)
- **Intersection**: Manages all traffic lights at an intersection with emergency mode support
- **IntersectionCycle**: Tracks cycle phases, timing, and pause/resume functionality
- **SignalTiming**: Stores timing configuration per direction with dynamic timing support
- **VehicleCounter**: Tracks vehicle counts per direction for dynamic timing
- **EmergencyRequest**: Manages emergency vehicle requests with duration tracking

### Package Structure

```
com.example.lowleveldesign.trafficsignalsystem/
├── controller/      # API layer for user interactions
├── service/         # Business logic layer
├── repository/      # Data persistence layer
├── domain/          # Domain models and entities
│   └── state/       # State pattern implementations
└── TrafficSignalSimulation.java  # Demo and entry point
```

## Design Patterns Applied

- **State Pattern**: TrafficLightState with concrete states (RedState, YellowState, GreenState, OffState) for signal transitions
- **Layered Architecture**: Controller → Service → Repository separation of concerns
- **Strategy Pattern**: Dynamic timing adjustment based on traffic conditions
- **Repository Pattern**: Data access abstraction for intersections, cycles, timing, and emergency requests
- **Factory Pattern**: Direction enum provides factory methods for direction management

## Design Principles

- **Single Responsibility**: Each class has one clear purpose (controller handles API, service handles logic, repository handles data)
- **Open/Closed**: Open for extension (new states, timing strategies), closed for modification
- **Liskov Substitution**: All state implementations are interchangeable
- **Interface Segregation**: Small, focused interfaces for each layer
- **Dependency Inversion**: High-level controllers depend on service interfaces, not implementations

## Usage Examples

### Basic Intersection Setup

```java
IntersectionController intersectionController = new IntersectionController(intersectionService);
int intersectionId = 101;
intersectionController.createIntersection(intersectionId, "MG Road Junction");
intersectionController.startCycle(intersectionId);
```

### Traffic Monitoring

```java
TrafficController trafficController = new TrafficController(trafficService);
trafficController.updateVehicleCount(Direction.NORTH, 42);
trafficController.updateVehicleCount(Direction.EAST, 10);
trafficController.displayTrafficStatus();
```

### Dynamic Timing Adjustment

```java
TimingController timingController = new TimingController(timingService);
timingController.enableDynamicTiming(intersectionId, Direction.NORTH, true);
timingController.adjustTimingBasedOnTraffic(intersectionId, Direction.NORTH);
```

### Emergency Vehicle Priority

```java
EmergencyController emergencyController = new EmergencyController(emergencyService);
emergencyController.requestEmergency(intersectionId, Direction.SOUTH, 20);
emergencyController.getEmergencyStatus(intersectionId);
emergencyController.endEmergency(intersectionId);
```

## Compile and Run

From the project root:

```bash
# Compile all Java files
javac -d src $(find src/com/example/lowleveldesign/trafficsignalsystem -name "*.java")

# Run the simulation
java -cp src com.example.lowleveldesign.trafficsignalsystem.TrafficSignalSimulation
```

## Demo Features

The `TrafficSignalSimulation` class demonstrates:
1. Intersection creation and initialization
2. Automatic signal cycle startup
3. Traffic count updates and monitoring
4. Dynamic timing adjustment based on traffic
5. Manual cycle advancement
6. Emergency vehicle priority handling
7. Emergency mode termination and cycle resumption

## State Transitions

Traffic lights follow strict state transition rules:
- **RED** → GREEN (normal cycle)
- **GREEN** → YELLOW (normal cycle)
- **YELLOW** → RED (normal cycle)
- **Any State** → OFF (maintenance mode)
- **OFF** → Any State (maintenance complete)

Invalid transitions throw `InvalidStateTransitionException`.

## Extensibility

To add new functionality:

- **New State**: Implement `TrafficLightState` interface (e.g., FlashingState for caution)
- **New Timing Strategy**: Extend `TimingService` with custom algorithms (e.g., time-of-day based)
- **New Direction**: Add to `Direction` enum and update cycle logic
- **New Controller**: Add controller for additional features (e.g., pedestrian crossing)

## Requirements

- Java 21 or higher
- No external dependencies
