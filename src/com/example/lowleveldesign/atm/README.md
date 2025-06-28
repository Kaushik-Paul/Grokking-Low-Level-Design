## Problem Definition

An **Automated Teller Machine (ATM)** is an electronic banking outlet that enables customers to complete basic transactions without the aid of a branch representative or teller. This implementation demonstrates a simplified ATM system that handles cash withdrawals, balance inquiries, and card authentication while following object-oriented design principles.

## Requirements

1. **Card Authentication**: The system should authenticate users using their ATM card and PIN.
2. **Cash Withdrawal**: Users should be able to withdraw cash in multiples of a fixed denomination.
3. **Balance Inquiry**: Users should be able to check their account balance.
4. **Transaction Limits**: The system should enforce daily withdrawal limits.
5. **Cash Availability**: The ATM should track and manage available cash.
6. **Session Management**: The system should handle user sessions and timeouts.
7. **Receipt Generation**: Option to print a transaction receipt.
8. **Error Handling**: Proper handling of invalid inputs and error conditions.

## System Design

### Class Structure

1. **ATM**: Main class representing the ATM machine, managing the overall flow.
2. **ATMCard**: Represents the user's ATM card with card details.
3. **BankAccount**: Represents the user's bank account with balance information.
4. **ATMState**: Interface defining ATM states (Idle, HasCard, SelectOperation, etc.).
5. **CashWithdrawal**: Handles the cash withdrawal process.
6. **CardReader**: Handles card reading and authentication.
7. **Keypad**: Handles user input.
8. **Screen**: Handles output display to the user.
9. **CashDispenser**: Manages the cash dispenser mechanism.

### Design Patterns Used

1. **State Pattern**: Manages different states of the ATM (Idle, HasCard, SelectOperation, etc.).
2. **Chain of Responsibility**: Handles the dispense chain for different currency notes.
3. **Factory Pattern**: Creates appropriate state objects.
4. **Singleton Pattern**: Ensures single instances of key components like CashDispenser.

### State Transitions

```
IdleState → CardInsertedState → HasCardState → SelectOperationState → 
[WithdrawState → DispenseState → TransactionEndState] or
[CheckBalanceState → TransactionEndState] → CardEjectState → IdleState
```

## How to Use

1. **Insert Card**: The ATM starts in IdleState.
2. **Enter PIN**: After card insertion, enter your PIN for authentication.
3. **Select Operation**: Choose between withdrawal, balance inquiry, or other available options.
4. **Enter Amount**: For withdrawals, enter the desired amount.
5. **Complete Transaction**: Collect cash (if withdrawn) and take your card.
6. **Receipt**: Option to print a transaction receipt.

## Extensibility & Enhancements

1. **Additional Operations**: Add support for fund transfers, bill payments, or mobile top-ups.
2. **Multiple Accounts**: Support for checking, savings, and credit card accounts.
3. **Biometric Authentication**: Add fingerprint or facial recognition.
4. **Multi-Currency Support**: Handle multiple currencies with exchange rates.
5. **Remote Monitoring**: Add functionality for remote diagnostics and cash level monitoring.
6. **Enhanced Security**: Implement additional security measures like OTP or transaction limits.

## Implementation Notes

- The system is designed to be modular and extensible.
- Each component has a single responsibility.
- Error handling is implemented for invalid inputs and edge cases.
- The code follows clean code principles and is well-documented.

## Running the Project

1. Compile all Java files in the project.
2. Run the `Main` class to start the ATM simulation.
3. Follow the on-screen instructions to interact with the ATM.

---

This implementation provides a solid foundation for understanding how an ATM system works internally and demonstrates key object-oriented design principles and patterns in practice.