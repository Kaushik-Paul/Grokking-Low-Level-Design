# Logging Framework LLD - Java

A flexible and extensible logging framework implementation demonstrating key object-oriented design principles and patterns.

## Overview

This logging framework provides a robust, thread-safe logging utility with support for multiple log levels, output destinations (appenders), message formatting, and filtering. It demonstrates the application of several design patterns including Strategy, Builder, and Interface Segregation.

## Features

- **Multiple Log Levels**: DEBUG, INFO, WARNING, ERROR, FATAL with priority-based filtering
- **Multiple Appenders**: Console, File, and Database output destinations
- **Custom Formatters**: Pluggable message formatting with pattern support
- **Flexible Filters**: Level-based and source-based message filtering
- **Thread-Safe**: Synchronized logging for concurrent environments
- **Builder Pattern**: Immutable LogMessage construction
- **Extensible Design**: Easy to add new appenders, formatters, and filters

## Architecture

### Core Components

- **Logger**: Main interface defining logging operations
- **LoggerImpl**: Thread-safe implementation with appender and filter management
- **LogLevel**: Enum representing log severity with priority comparison
- **LogMessage**: Immutable data class with builder pattern for log message construction
- **LogAppender**: Interface for output destinations (console, file, database)
- **LogFormatter**: Interface for message formatting (simple, detailed)
- **LogFilter**: Interface for message filtering (level, source)
- **LogConfiguration**: Configuration settings for the framework

### Package Structure

```
com.example.lowleveldesign.loggingframework/
├── core/           # Core interfaces and implementations
├── appenders/      # Output destination implementations
├── formatters/     # Message formatting implementations
├── filter/         # Message filtering implementations
└── main/           # Demo and entry point
```

## Design Patterns Applied

- **Strategy Pattern**: LogAppender, LogFormatter, and LogFilter interfaces allow pluggable behavior
- **Builder Pattern**: LogMessage.Builder for immutable object construction
- **Interface Segregation**: Separate interfaces for appenders, formatters, and filters
- **Singleton Pattern**: Each logger instance manages its own appenders and filters
- **Template Method**: LoggerImpl defines the logging workflow with customizable steps

## Design Principles

- **Single Responsibility**: Each class has a single, well-defined purpose
- **Open/Closed**: Open for extension (new appenders, formatters, filters), closed for modification
- **Liskov Substitution**: All implementations can be substituted for their interfaces
- **Interface Segregation**: Small, focused interfaces for specific concerns
- **Dependency Inversion**: High-level modules depend on abstractions, not concrete implementations

## Usage Examples

### Basic Logging

```java
Logger logger = new LoggerImpl("MyLogger");
logger.debug("Debug message");
logger.info("Info message");
logger.warning("Warning message");
logger.error("Error message");
logger.fatal("Fatal message");
```

### Multiple Appenders

```java
Logger logger = new LoggerImpl("MultiAppenderLogger");
FileAppender fileAppender = new FileAppender("app.log");
logger.addAppender(fileAppender);
logger.info("This goes to both console and file");
```

### Custom Formatters

```java
SimpleFormatter formatter = new SimpleFormatter("[%LEVEL] %TIMESTAMP - %MESSAGE");
ConsoleAppender appender = new ConsoleAppender();
appender.setFormatter(formatter);
logger.addAppender(appender);
```

### Filters

```java
Logger logger = new LoggerImpl("FilterLogger");
LevelFilter filter = new LevelFilter(LogLevel.WARNING);
logger.addFilter(filter);
logger.debug("This will be filtered out");
logger.error("This will be shown");
```

## Compile and Run

From the project root:

```bash
# Compile all Java files
javac -d src $(find src/com/example/lowleveldesign/loggingframework -name "*.java")

# Run the demo
java -cp src com.example.lowleveldesign.loggingframework.main.LoggingDemo
```

## Demo Features

The `LoggingDemo` class demonstrates:
1. Basic logging with different levels
2. Multiple appenders (console + file)
3. Custom formatters with pattern support
4. Level-based filtering
5. Thread safety with concurrent logging

## Extensibility

To add new functionality:

- **New Appender**: Implement `LogAppender` interface (e.g., SyslogAppender, KafkaAppender)
- **New Formatter**: Implement `LogFormatter` interface (e.g., JsonFormatter, XmlFormatter)
- **New Filter**: Implement `LogFilter` interface (e.g., TimeFilter, RegexFilter)

## Requirements

- Java 21 or higher
- No external dependencies
