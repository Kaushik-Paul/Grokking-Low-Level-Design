## Problem Definition

A **Null Pointer System** demonstrates the **Null Object Pattern**, a behavioral design pattern that provides an object as a surrogate for the absence of an object of a given type. This pattern is particularly useful for handling null references in a clean and object-oriented way, avoiding explicit null checks and NullPointerExceptions in the code.

## Requirements

1. **Vehicle Interface**: Define a common interface for all vehicle types with methods to get vehicle details.
2. **Concrete Vehicles**: Implement specific vehicle types (e.g., Car, Motorcycle) that implement the Vehicle interface.
3. **Null Object**: Create a null object implementation that provides default/neutral behavior.
4. **Factory Pattern**: Use a factory to create appropriate vehicle instances, returning a null object when an unknown vehicle type is requested.
5. **Client Code**: Demonstrate how the client code can use the vehicle objects without null checks.

## System Design

### Class Structure

- **Vehicle (Interface)**:
  - `getTankCapacity()`: Returns the fuel tank capacity
  - `getSeatCapacity()`: Returns the seating capacity

- **Concrete Vehicles**:
  - `Car`: Implements Vehicle with car-specific capacities
  - `Motorcycle`: Implements Vehicle with motorcycle-specific capacities

- **Null Object**:
  - `NullVehicle`: Implements Vehicle with neutral/default values (0 for capacities)

- **Factory**:
  - `VehicleFactory`: Creates appropriate vehicle instances based on input

### Design Patterns Used

1. **Null Object Pattern**:
   - Provides a null object that implements the expected interface but does nothing or provides default behavior
   - Eliminates the need for null checks in client code
   - Makes the code more maintainable and less error-prone

2. **Factory Pattern**:
   - Centralizes object creation logic
   - Decouples object creation from the client code
   - Makes it easy to add new vehicle types in the future

## How It Works

1. The client requests a vehicle from the `VehicleFactory` by specifying a vehicle type.
2. The factory returns an appropriate vehicle instance if the type is recognized.
3. If the requested vehicle type is not recognized, the factory returns a `NullVehicle` instance instead of null.
4. The client can call methods on the returned object without worrying about null checks.
5. The null object provides safe, neutral behavior (returning 0 for capacities in this case).

## Example Usage

```java
// Client code
Vehicle vehicle = VehicleFactory.getVehicle("boat"); // Returns NullVehicle
printVehicleDetails(vehicle); // Safely prints 0 for both capacities

public static void printVehicleDetails(Vehicle vehicle) {
    System.out.println("Seating Capacity: " + vehicle.getSeatCapacity());
    System.out.println("Tank Capacity: " + vehicle.getTankCapacity());
}
```

## Benefits

- **Eliminates null checks**: Client code doesn't need to check for null before using the object.
- **Simplifies code**: Reduces conditional logic and makes the code more readable.
- **Safer code**: Prevents NullPointerExceptions at runtime.
- **Extensible**: Easy to add new vehicle types without changing existing code.

## When to Use

- When you need to provide a default behavior for null objects
- When you want to avoid null checks in client code
- When you need to handle the absence of an object in a clean, object-oriented way