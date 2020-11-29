group = "me.jakejmattson"
version = "1.0-SNAPSHOT"

plugins {
    kotlin("jvm") version "1.4.20"
}

repositories {
    mavenCentral()
    jcenter()
    maven("https://jitpack.io")
}

dependencies {
    implementation("me.jakejmattson:DiscordKt:0.19.1")
}

tasks.compileKotlin {
    kotlinOptions.jvmTarget = "1.8"
}