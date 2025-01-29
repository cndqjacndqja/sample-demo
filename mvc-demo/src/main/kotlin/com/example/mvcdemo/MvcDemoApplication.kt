package com.example.mvcdemo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class MvcDemoApplication

fun main(args: Array<String>) {
    runApplication<MvcDemoApplication>(*args)
}
