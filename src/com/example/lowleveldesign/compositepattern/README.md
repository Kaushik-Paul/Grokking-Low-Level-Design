# Composite Pattern Implementation

## Problem Definition

The **Composite Pattern** is a structural design pattern that lets you compose objects into tree structures to represent part-whole hierarchies. It allows clients to treat individual objects and compositions of objects uniformly. This implementation demonstrates the pattern through two examples:
1. A calculator for arithmetic expressions
2. A file system representation

## 1. Calculator Implementation

### Requirements

1. The system should be able to represent both simple numbers and complex arithmetic expressions.
2. Support for basic arithmetic operations: addition (+), subtraction (-), multiplication (*), and division (/).
3. The system should evaluate expressions and return the correct result.
4. The design should allow for easy extension to support more operations or expression types.
5. The evaluation process should be transparent to the client, treating both simple and complex expressions uniformly.

### Class Structure

- **ArithmeticExpression (Interface):**
  - Defines the common interface for all components (both simple and composite).
  - Declares the `evaluate()` method that must be implemented by all concrete classes.

- **ArithmeticNumber (Leaf):**
  - Represents a terminal (leaf) object in the composition.
  - Implements the `evaluate()` method to return its numeric value.

- **Expression (Composite):**
  - Represents a composite component that contains other expressions.
  - Maintains child expressions and an operator.
  - Implements the `evaluate()` method by evaluating its children and applying the operator.

- **Operator (Enum):**
  - Defines the supported arithmetic operations (ADD, SUBTRACT, MULTIPLY, DIVIDE).

### Example Usage

```java
// Simple number
ArithmeticExpression number1 = new ArithmeticNumber(5);

// Another number
ArithmeticExpression number2 = new ArithmeticNumber(10);

// Expression: 5 + 10
ArithmeticExpression expression1 = new Expression(number1, Operator.ADD, number2);

// Expression: (5 + 10) * 3
ArithmeticExpression expression2 = new Expression(
    expression1, 
    Operator.MULTIPLY, 
    new ArithmeticNumber(3)
);

int result = expression2.evaluate(); // Outputs 45
```

## 2. File System Implementation

### Requirements

1. The system should be able to represent both files and directories in a hierarchical structure.
2. Directories can contain other files and directories.
3. Both files and directories should support common operations like `ls()` to list contents.
4. The client code should be able to treat files and directories uniformly.
5. The structure should be easily extensible to support new types of file system elements.

### Class Structure

- **FileSystem (Interface):**
  - Defines the common interface for all file system components.
  - Declares the `ls()` method that must be implemented by all concrete classes.

- **File (Leaf):**
  - Represents a file in the file system.
  - Implements the `ls()` method to display the file name.

- **Directory (Composite):**
  - Represents a directory that can contain other file system elements.
  - Maintains a collection of `FileSystem` objects (files and subdirectories).
  - Implements the `ls()` method to list all contained elements recursively.
  - Provides methods to add and retrieve file system elements.

### Example Usage

```java
// Create a directory for movies
Directory movieDirectory = new Directory("Movie");

// Add a file to the movie directory
File border = new File("Border");
movieDirectory.add(border);

// Create a subdirectory for comedy movies
Directory comedyMovieDirectory = new Directory("ComedyMovie");
File hulchul = new File("Hulchul");
comedyMovieDirectory.add(hulchul);

// Add the subdirectory to the movie directory
movieDirectory.add(comedyMovieDirectory);

// List all contents
movieDirectory.ls();
/* Output:
   Directory name: Movie
   File name: Border
   Directory name: ComedyMovie
   File name: Hulchul
*/
```

## Design Patterns Used

### Composite Pattern
- **Calculator:**
  - Treats both simple numbers and complex expressions uniformly through the `ArithmeticExpression` interface.
  - Enables building complex expressions from simpler ones.
  - Simplifies client code by allowing it to work with expressions without knowing their concrete types.

- **File System:**
  - Treats both files and directories uniformly through the `FileSystem` interface.
  - Enables building complex directory structures from simple components.
  - Simplifies operations like listing directory contents recursively.

## Extensibility & Enhancements

### Calculator:
1. **New Operations:**
   - Add new operations by extending the `Operator` enum.
2. **New Expression Types:**
   - Add new types of expressions by implementing the `ArithmeticExpression` interface.
3. **Error Handling:**
   - Add input validation and error handling for division by zero.
4. **Visitor Pattern:**
   - Implement the Visitor pattern to add new operations without modifying existing classes.
5. **Parsing:**
   - Add a parser to convert string expressions into the composite structure.

### File System:
1. **New File Types:**
   - Add specialized file types (e.g., `ImageFile`, `TextFile`) by implementing the `FileSystem` interface.
2. **File Operations:**
   - Extend the `FileSystem` interface with additional operations like `copy()`, `move()`, or `delete()`.
3. **File Metadata:**
   - Add file metadata (size, creation date, permissions) and corresponding getters/setters.
4. **Composite Operations:**
   - Implement operations that work across the entire hierarchy, like calculating total size or finding files by pattern.
5. **Iterator Pattern:**
   - Implement an iterator to traverse the file system structure.

---

These implementations demonstrate the power of the Composite Pattern in creating flexible and maintainable hierarchical structures, making it easier to work with complex tree structures of objects in various domains.