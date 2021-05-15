# To run directly
```shell
gradle run
```

# To build a FatJar
This requires the separate "Launcher" class to find and package the runtime dependencies.

```shell
gradle jar
java -jar build/lib/javafx_gradle-1.0-SNAPSHOT.jar
```
