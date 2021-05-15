# JavaFX Gradle (with Kotlin DSL) Template
A very basic template for creating JavaFX (using OpenJFX 11)[https://openjfx.io/javadoc/11/] 
project with Gradle using Kotlin DSL.

Uses Java for the code but can be adapted to use Kotlin (or other JVM languages).

The build file includes all JavaFX modules as dependencies for reference, but it is rare one will 
need all of these for any given project. As such, you can remove those you do not use from the 
build file by modifying the `javaFXModuleNames` array to only include those you need.

This also includes a task configuration to create a "fatjar" for running the application with `java 
-jar app.jar`.

## Running the application
Either use the wrapper, `gradlew` for UNIX or `gradlew.bat` for Windows, to start the `run` task:
```shell
gradle run
```

## To build a fatjar
This requires the separate "Launcher" class to find and package the runtime dependencies.

```shell
gradle jar
java -jar build/lib/javafx_gradle-1.0-SNAPSHOT.jar
```
