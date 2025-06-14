## Problem Definition

We have a **Weight-Machine** device that always returns the weight of a person in **pounds (lbs)**.  
In many parts of the world the **kilogram (kg)** is the preferred unit, and existing client
code expects that unit.  We need a solution that allows the **existing machine** to be used
*without modifying its source code* while still providing data in kilograms to the rest of
the system.

This is a textbook scenario for the **Adapter Design Pattern**.  The goal is to create a
wrapper (adapter) that converts the interface of an existing class (`WeightMachine` → lbs)
into the interface expected by the clients (`WeightMachineAdapter` → kg).

---

## Requirements

1. The system must support at least one concrete implementation of the weight machine
   (`WeightMachineForBabies`) that returns weight in pounds.
2. Client code must obtain the weight **only in kilograms**; the conversion logic should be
   encapsulated.
3. No changes are allowed inside the existing `WeightMachine` or its concrete classes.
4. The design should be open for adding new kinds of machines (e.g., adult scale) or new
   target units (e.g., stones) with minimal code changes.
5. The solution should demonstrate clean separation of concerns and follow SOLID
   principles.

---

## System Design

### Class Structure

| Class / Interface | Responsibility |
| ----------------- | -------------- |
| `WeightMachine` *(Adaptee)* | Interface that exposes `getWeightInPounds()`.
| `WeightMachineForBabies` | Concrete implementation that returns a fixed weight in pounds (dummy data for demo).
| `WeightMachineAdapter` *(Target)* | Interface expected by clients; exposes `getWeightInKg()`.
| `WeightMachineAdapterImpl` *(Adapter)* | Wraps a `WeightMachine` instance and converts pounds → kilograms.
| `Main` *(Client)* | Demonstrates usage; depends **only** on the adapter interface.

### Sequence Diagram

```
Client(Main) ──> WeightMachineAdapterImpl ──> WeightMachineForBabies
      ^                 |                              |
      |                 |  (conversion lbs → kg)       |
      |<────────────────┘<──────────────────────────────┘
```

1. `Main` asks the adapter for weight in kg.
2. Adapter delegates to the adaptee for pounds.
3. Adapter converts the value `(lbs × 0.45359237)` and returns kg to the client.

### Design Patterns Used

- **Adapter Pattern (Object Adapter)** – Bridges two incompatible interfaces.
- **Interface Segregation Principle** – Clients depend only on what they use (`getWeightInKg()`).

---

## Extensibility & Enhancements

- **Additional Units**: Create new adapter implementations, e.g., `WeightMachineStoneAdapter` for stones.
- **Different Scales**: Add new classes that implement `WeightMachine` without touching adapter code.
- **Bi-directional Conversion**: Extend the adapter interface with more methods if clients ever need pounds again.
- **Unit Tests**: Add tests to validate conversion accuracy.

---

## How to Run

```bash
# Compile (from repo root)
$ javac $(find src -name '*.java')

# Execute the demo
$ java -cp src com.example.lowleveldesign.adapterdesignpattern.client.Main
```

Expected output:
```
Weight in kilograms: 9.0718474
```

---

This module provides a concise illustration of the **Adapter Design Pattern** in Java 21.
It demonstrates how to introduce new interfaces to legacy code safely and cleanly.