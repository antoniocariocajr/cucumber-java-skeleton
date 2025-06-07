plugins {
    java
}
dependencies {
    testImplementation(platform("org.junit:junit-bom:5.13.1"))
    testImplementation(platform("io.cucumber:cucumber-bom:7.23.0"))
    testImplementation(platform("org.assertj:assertj-bom:3.27.3"))

    testImplementation("io.cucumber:cucumber-java")
    testImplementation("io.cucumber:cucumber-junit-platform-engine")
    testImplementation("org.junit.platform:junit-platform-suite")
    testImplementation("org.assertj:assertj-core")

    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

repositories {
    mavenCentral()
}

tasks.withType<Test> {
    useJUnitPlatform()
    // Work around. Gradle does not include enough information to disambiguate
    // between different examples and scenarios.
    systemProperty("cucumber.junit-platform.naming-strategy", "long")
}
