package com.example.mvcdemo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients

@SpringBootApplication
@EnableFeignClients
class MvcDemoApplication

fun main(args: Array<String>) {
    runApplication<MvcDemoApplication>(*args)
}
