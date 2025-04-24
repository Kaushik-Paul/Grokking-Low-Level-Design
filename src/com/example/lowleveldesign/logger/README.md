## Problem Definition
A **Logger System** is a critical utility in software applications, responsible for recording log messages that help developers monitor application behavior, trace errors, and debug issues. Logging is essential for production systems to diagnose problems, audit actions, and ensure maintainability. This logger implementation supports multiple log levels (ERROR, DEBUG, INFO) and processes log messages according to their severity. The system demonstrates the Chain of Responsibility design pattern, making it flexible, extensible, and easy to maintain.

## Requirements
1. **Multiple Log Levels**: Support for ERROR, DEBUG, and INFO log levels to categorize messages by severity.
2. **Log Message Routing**: Messages are handled by the appropriate processor based on their level; unhandled messages are passed to the next processor in the chain.
3. **Extensibility**: Easy to add new log levels or processors without modifying existing code.
4. **Simple API**: Provide a straightforward interface for logging messages from the application.
5. **Separation of Concerns**: Each processor should handle only its designated log level.
6. **Demonstration via Main**: The system should include an example of usage in a main application class.

## System Design

### Overview
The logger is designed using the Chain of Responsibility pattern, where each log processor is responsible for a specific log level. If a processor cannot handle a message, it passes it to the next processor in the chain. This approach decouples the sender and receiver, allowing for flexible message handling and easy extension.

### Class Structure
- **Main**: Entry point of the application. Demonstrates usage by logging messages at different levels.
- **LogProcessor**: Abstract base class for all log processors. Maintains a reference to the next processor and contains the core logic for processing and forwarding log messages. Includes a static `create()` method to build the processor chain.
- **DebugLogProcessor**: Handles DEBUG level log messages.
- **ErrorLogProcessor**: Handles ERROR level log messages.
- **InfoLogProcessor**: Handles INFO level log messages.
- **LogLevel**: Enum defining the supported log levels (ERROR, DEBUG, INFO).

#### Class Diagram (Text Form)
```
Main
  |
  v
LogProcessor (abstract)
  |-- ErrorLogProcessor
  |-- DebugLogProcessor
  |-- InfoLogProcessor

LogLevel (enum)
```

### How Chain of Responsibility Works
- The chain is set up as: ErrorLogProcessor → DebugLogProcessor → InfoLogProcessor.
- When a log message is sent, it starts at the beginning of the chain.
- Each processor checks if it can handle the message based on the log level:
    - If yes, it processes the message (e.g., prints it to the console).
    - If not, it forwards the message to the next processor in the chain.
- This continues until the message is handled or the end of the chain is reached.

### Design Patterns Used
- **Chain of Responsibility Pattern**: Enables flexible log message handling and easy extensibility.
- **Factory Method (via static create())**: Simplifies the creation of the processor chain.

## Usage Example
```java
LogProcessor logObject = LogProcessor.create();
logObject.log(LogLevel.ERROR, "Exception occurred");
logObject.log(LogLevel.DEBUG, "Debug message");
logObject.log(LogLevel.INFO, "Info message");
```

### Example Output
```
ERROR: Exception occurred
DEBUG: Debug message
INFO: Info message
```

## Extending the Logger
To add a new log level (e.g., WARN):
1. Create a new processor class (e.g., WarnLogProcessor) extending LogProcessor.
2. Update the chain in the `create()` method to include the new processor.
3. Add the new level to the LogLevel enum.

This modular approach ensures that new functionality can be added with minimal changes to the existing codebase.

## Summary
This logger system provides a robust, extensible way to handle log messages of varying severity in Java applications. It demonstrates important design patterns and is easy to adapt for more complex or production-grade logging needs.