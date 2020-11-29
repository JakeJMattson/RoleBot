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
    implementation("com.gitlab.aberrantfox:KUtils:0.16.0")
}

tasks.compileKotlin {
    kotlinOptions.jvmTarget = "1.8"
}