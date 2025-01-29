package com.example.reactordemo.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/api/demo")
class DemoController(
    private val webClient: WebClient,
) {
    @GetMapping
    fun getAll(): Mono<String> {
        return webClient
            .get()
            .uri("/api/demo")
            .retrieve()
            .bodyToMono(String::class.java)
            .onErrorResume { error ->
                // 에러 처리 로직
                Mono.error(error)
            }
    }
}
