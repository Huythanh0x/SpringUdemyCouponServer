plugins {
    java
    id("org.springframework.boot") version "3.1.0"
    id("io.spring.dependency-management") version "1.1.0"
    id ("io.freefair.lombok") version "6.6.1"
}

group = "com.huythanh0x"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-security")
    developmentOnly("org.springframework.boot:spring-boot-devtools")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    implementation("mysql:mysql-connector-java:8.0.28")
    implementation("org.json:json:20220320")
    implementation("org.jsoup:jsoup:1.15.4")
    implementation("org.projectlombok:lombok:1.18.20")
    implementation("io.jsonwebtoken:jjwt-impl:0.11.5")
    implementation("io.jsonwebtoken:jjwt-api:0.11.5")
    implementation("io.jsonwebtoken:jjwt-jackson:0.11.5")
//    implementation("org.springframework.boot:spring-boot-starter-validation:3.1.0")

}

tasks.withType<Test> {
    useJUnitPlatform()
}
