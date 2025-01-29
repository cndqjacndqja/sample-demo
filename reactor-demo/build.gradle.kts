plugins {
    kotlin("jvm")
}

dependencies {
    implementation("com.mysql:mysql-connector-j")
    implementation("org.springframework.boot:spring-boot-starter-jdbc")
    implementation("org.springframework.boot:spring-boot-starter-web")
}

kotlin {
    compilerOptions {
//        freeCompilerArgs.addAll("-Xjsr305=strict")
    }
}
