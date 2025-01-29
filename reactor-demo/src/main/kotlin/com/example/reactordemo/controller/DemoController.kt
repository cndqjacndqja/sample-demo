package com.example.reactordemo.controller

import com.example.reactordemo.service.DemoService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/api/demo")
class DemoController(
    private val demoService: DemoService,
) {
    @GetMapping
    fun getAll(): Mono<String> {
        return Mono.zip(
            demoService.find(),
            demoService.find()
        ) { result1, result2 ->
            "$result1, $result2"
        }
    }
}
