
plugins {
    java
    id("jamal-gradle-plugin") version "1.0.0-SNAPSHOT"
}

repositories {
    mavenCentral()
    google()
    maven(url = "https://jitpack.io/")
}

JamalConvertFile {
}
