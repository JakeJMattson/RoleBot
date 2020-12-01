group = "me.jakejmattson"
version = "1.0-SNAPSHOT"

plugins {
    kotlin("jvm") version "1.4.20"
}

repositories {
    mavenCentral()
    jcenter()
}

dependencies {
    implementation("me.jakejmattson:DiscordKt:0.21.3")
}

tasks.compileKotlin {
    kotlinOptions.jvmTarget = "1.8"
}