# Logging Framework LLD - Java

This project contains the Java implementation extracted from the pasted Logging Framework LLD response.

## Folder structure

```text
appenders/
core/
filter/
formatters/
main/
demo/
```

Note: `LevelFilter.java` and `SourceFilter.java` are placed in `filter/` to match the pasted/file-tree structure, while their Java package is `filters`.

## Compile and run

From this directory:

```bash
javac -d out $(find . -name "*.java")
java -cp out main.LoggingDemo
```
