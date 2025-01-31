plugins {
    kotlin("jvm")
}

dependencies {
    implementation("com.mysql:mysql-connector-j")
    implementation("org.springframework.boot:spring-boot-starter-jdbc")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core") // 코루틴 기본 라이브러리
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor") // Reactor와 코루틴 변환 지원
}

kotlin {
    compilerOptions {
//        freeCompilerArgs.addAll("-Xjsr305=strict")
    }
}
