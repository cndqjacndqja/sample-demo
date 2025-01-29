package com.example.reactordemo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients

@SpringBootApplication
@EnableFeignClients
class SampleDemoApplication

fun main(args: Array<String>) {
    runApplication<SampleDemoApplication>(*args)
}
