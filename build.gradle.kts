import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.8.0"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

// No custom sourceSets needed: all your Kotlin files live in src/test/kotlin,
// which is Gradle's default convention for Kotlin test sources. src/main
// doesn't exist in this repo, so we leave it out entirely.

val junitVersion = "5.9.2"
val seleniumVersion = "3.141.59"
val browsermobVersion = "2.1.5"
val lambdatestVersion = "1.0.7"
val slf4jVersion = "1.7.32"

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation(kotlin("stdlib"))

    implementation("io.appium:java-client:7.6.0")
    implementation("org.seleniumhq.selenium:selenium-java:$seleniumVersion")
    implementation("net.lightbody.bmp:browsermob-core:$browsermobVersion")
    implementation("com.github.lambdatest:lambdatest-tunnel-binary:$lambdatestVersion")
    implementation("org.slf4j:slf4j-simple:$slf4jVersion")

    implementation("junit:junit:4.13.2")
    implementation("org.junit.platform:junit-platform-runner:1.9.2")

    testImplementation("org.junit.jupiter:junit-jupiter-engine:$junitVersion")
    testImplementation("org.junit.jupiter:junit-jupiter-api:$junitVersion")
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "17"
}

tasks.test {
    useJUnitPlatform()
}