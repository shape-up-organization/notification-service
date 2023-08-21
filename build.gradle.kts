plugins {
	java
	id("org.springframework.boot") version "3.1.2"
	id("io.spring.dependency-management") version "1.1.2"
	id("com.github.davidmc24.gradle.plugin.avro") version "1.8.0"
	id("io.freefair.lombok") version "8.2.2"
}

group = "br.com.shapeup"
version = "0.0.1"

java {
	sourceCompatibility = JavaVersion.VERSION_17
}

repositories {
	gradlePluginPortal()
	mavenCentral()
}

dependencies {

	/*
	* Variables
	* */
	val jacksonVersion = "2.15.2"
	val lombokVersion = "1.18.20"

	/*
	* Spring Boot
	* */
	implementation("org.springframework.boot:spring-boot-starter-data-mongodb")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springframework.boot:spring-boot-starter-websocket")
	implementation("org.springframework.kafka:spring-kafka")
	implementation("org.springframework.boot:spring-boot-starter-mail")

	/*
	* Jackson
	* */
	implementation("com.fasterxml.jackson.core:jackson-databind:$jacksonVersion")
	implementation("com.fasterxml.jackson.core:jackson-core:$jacksonVersion")

	/*
	* Test`
	* */
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.springframework.kafka:spring-kafka-test")

	/*
	* Lombok
	* */
	compileOnly("org.projectlombok:lombok:$lombokVersion")

	/*
	* Others
	* */
	implementation("com.google.code.gson:gson:2.10.1")
}

tasks.withType<Test> {
	useJUnitPlatform()
}
