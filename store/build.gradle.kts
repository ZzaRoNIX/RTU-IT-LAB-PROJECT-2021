import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "2.4.3"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
    kotlin("jvm") version "1.4.30"
    kotlin("plugin.spring") version "1.4.30"
    kotlin("plugin.jpa") version "1.4.30"
}

group = "com.saprikin"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

repositories {
    mavenCentral()
}
subprojects {
    apply(plugin = "java")
    apply(plugin = "org.jetbrains.kotlin.jvm")

    dependencies {
        val implementation by configurations
        implementation(kotlin("utility"))
    }
}
dependencies {
    implementation ("org.springdoc:springdoc-openapi-ui:1.5.2")
    implementation ("com.google.code.gson:gson:2.7")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    runtimeOnly("org.postgresql:postgresql")
    }

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "11"
    }
}


