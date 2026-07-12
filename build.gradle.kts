plugins {
    java
    id("io.qameta.allure") version "2.12.0"
}

group = "com.shopkart"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

val junitVersion = "5.13.4"
val cucumberVersion = "7.31.0"
val seleniumVersion = "4.35.0"
val selenideVersion = "7.9.3"
val restAssuredVersion = "5.5.6"
val testcontainersVersion = "1.21.3"
val flywayVersion = "11.11.2"
val mysqlVersion = "9.3.0"
val jacksonVersion = "2.20.0"
val allureVersion = "2.33.0"

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(22))
    }
}

dependencies {

    // JUnit
    testImplementation("org.junit.jupiter:junit-jupiter-api:$junitVersion")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:$junitVersion")

    // Cucumber
    testImplementation("io.cucumber:cucumber-java:$cucumberVersion")
    testImplementation("io.cucumber:cucumber-junit-platform-engine:$cucumberVersion")
    testImplementation("org.junit.platform:junit-platform-suite:1.13.4")

    // Selenide
    testImplementation("com.codeborne:selenide:$selenideVersion")

    // Selenium
    testImplementation("org.seleniumhq.selenium:selenium-java:$seleniumVersion")

    // REST Assured
    testImplementation("io.rest-assured:rest-assured:$restAssuredVersion")

    // Jackson
    testImplementation("com.fasterxml.jackson.core:jackson-databind:$jacksonVersion")

    // Testcontainers
    testImplementation(platform("org.testcontainers:testcontainers-bom:$testcontainersVersion"))
    testImplementation("org.testcontainers:junit-jupiter")
    testImplementation("org.testcontainers:mysql")


    // MySQL Driver
    testImplementation("com.mysql:mysql-connector-j:${mysqlVersion}")

    // Flyway
    testImplementation("org.flywaydb:flyway-core:$flywayVersion")
    testImplementation("org.flywaydb:flyway-mysql:${flywayVersion}")

    // Allure
    testImplementation("io.qameta.allure:allure-junit5:$allureVersion")
    testImplementation("io.qameta.allure:allure-rest-assured:$allureVersion")
    testImplementation("io.qameta.allure:allure-cucumber7-jvm:$allureVersion")

    // Logging
    testImplementation("org.slf4j:slf4j-simple:2.0.17")
}

tasks.test {

    useJUnitPlatform()

    systemProperty(
        "cucumber.plugin",
        "pretty,io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
    )

    testLogging {
        events("passed", "failed", "skipped")

        // Show System.out.println() output
        showStandardStreams = true

        exceptionFormat = org.gradle.api.tasks.testing.logging.TestExceptionFormat.FULL
    }
}

allure {
    version.set(allureVersion)
}