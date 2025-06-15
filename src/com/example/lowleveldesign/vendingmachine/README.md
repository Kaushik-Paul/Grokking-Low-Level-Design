## Problem Definition
A **Vending Machine** is an automated device that dispenses products (drinks, snacks, etc.) to customers after they insert coins and make a product selection. It must accurately track inserted money, manage product inventory, deliver change, and transition through well-defined operational states. Designing a vending machine is a classic object-oriented design exercise that demonstrates finite-state machines, inventory management, and payment handling.

---

## Requirements
1. **Accepted Coins:** The machine accepts four U.S. coin denominations – `PENNY (1)`, `NICKEL (5)`, `DIME (10)`, and `QUARTER (25)`.
2. **Product Catalog & Pricing:** Supports multiple product types (`COKE`, `PEPSI`, `JUICE`, `SODA`) stored in coded shelves. Each shelf keeps price, product, and sold-out status.
3. **Inventory Capacity:** Machine is initialised with a fixed number of shelves (configurable; demo uses *5 shelves × 2 rows* = 10 slots).
4. **User Workflow:**
   - Insert Coin → Start Product Selection → Choose Product → Dispense Item & Change.
5. **States:** Machine operates through four states:
   - **IdleState** – waiting for user.
   - **HasMoneyState** – coins inserted; awaiting selection.
   - **SelectionState** – product code entered; validating funds & availability.
   - **DispenseState** – dispenses product & returns change.
6. **Error Handling:**
   - Reject selection if insufficient balance or item sold-out.
   - Support *Refund* to return all inserted coins anytime before dispense.
7. **Extensibility:** Design should allow adding new coin types, products, payment modes, or promotional logic with minimal changes.

---

## System Design

### Class Structure
| Package | Class / Enum | Responsibility |
|---------|--------------|----------------|
| `payment` | `Coin` | Enum of supported coin denominations with integer value. |
| `products` | `VendingMachine` | Context class holding current `State`, `Inventory`, and inserted `Coin` list. |
| | `Inventory` | Aggregates fixed-size array of `ItemShelf`. |
| | `ItemShelf` | Represents a single product slot (code, `Item`, sold-out flag). |
| | `Item` | Holds `ItemType` and price. |
| | `ItemType` | Enum of product SKUs (COKE, PEPSI, JUICE, SODA). |
| `vendingmachinestate` | `State` (interface) | Defines actions: insertCoin, chooseProduct, refund, dispense, etc. |
| | `IdleState` | Concrete state – initial no-coin stage. |
| | `HasMoneyState` | Concrete state – coins accepted. |
| | `SelectionState` | Concrete state – product selection in progress. |
| | `DispenseState` | Concrete state – dispensing product & change. |
| root | `Main` | Demo driver that fills inventory, simulates user interaction, and logs output. |

### Design Patterns Used
1. **State Pattern:** Encapsulates behaviour for each machine state, enabling clean transition logic.
2. **Factory / Builder (potential):** Can be applied to construct `Item` or configure machine, though not implemented in demo.

### State Transition Diagram
```
IdleState --clickInsertCoin--> HasMoneyState --startSelection--> SelectionState --dispense--> DispenseState --reset--> IdleState
      ^                              |                             |
      |----refundFullMoney-----------|----refundFullMoney---------|
```

### Sequence of Operations
1. User clicks **InsertCoinButton** → Machine switches to `HasMoneyState`.
2. User inserts one or more coins; values are accumulated.
3. User presses **StartProductSelectionButton** → enters `SelectionState`.
4. User inputs shelf code. Machine verifies:
   - Item available.
   - Inserted amount ≥ price.
5. Machine changes to `DispenseState` to:
   - Eject product.
   - Calculate & return change.
6. Machine returns to `IdleState` for the next customer.

---

## How to Run the Demo
1. Compile / run the `Main` class.
2. Console output will show:
   - Inventory initialisation.
   - Coin insertion.
   - Product selection & dispensing.
   - Remaining inventory.
3. Modify `Main` to test other scenarios (insufficient funds, sold-out, refund).

---
This project illustrates a clean, modular implementation of a Finite-State Vending Machine, showcasing good OO practices and extensibility for further enhancements (e.g., card payments, touch UI, remote monitoring).