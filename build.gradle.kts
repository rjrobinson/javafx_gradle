plugins {
    java
    idea
    id("org.openjfx.javafxplugin") version "0.0.9"
    application
}

group = "com.scgrk"
version = "1.0-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.mockito", "mockito-junit-jupiter", "3.3.3")
    testImplementation("org.junit.jupiter", "junit-jupiter-api", "5.6.2")
    testRuntimeOnly("org.junit.jupiter", "junit-jupiter-engine", "5.6.2")
}


tasks.withType<Test> {
    useJUnitPlatform()
    testLogging {
        exceptionFormat = org.gradle.api.tasks.testing.logging.TestExceptionFormat.FULL
        events("passed", "failed", "skipped")
    }
}

val javaFXModuleNames = arrayOf("javafx.base",
                                "javafx.controls",
                                "javafx.fxml",
                                "javafx.graphics",
                                "javafx.media",
                                "javafx.swing",
                                "javafx.web")

javafx {
    modules(*javaFXModuleNames)
}

application {
    mainClassName = "com.scgrk.Main"
}

tasks.withType<Jar> {
    manifest {
        attributes["Main-Class"] = "com.scgrk.Launcher"
    }
    from(Callable {
        configurations.runtimeClasspath.map { configuration ->
            configuration.asFileTree.fold(files().asFileTree) { collection, file ->
                if (file.isDirectory) collection else collection.plus(zipTree(file))
            }
        }
    })
}