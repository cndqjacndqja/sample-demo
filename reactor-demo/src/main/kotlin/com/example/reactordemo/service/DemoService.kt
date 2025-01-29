package com.example.reactordemo.service

import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Mono

@Service
class DemoService(
    private val webClient: WebClient
) {
    fun find(): Mono<String> {
        return webClient
            .get()
            .uri("/api/demo")
            .retrieve()
            .bodyToMono(String::class.java)
            .onErrorResume { error ->
                // 에러 처리 로직
                Mono.error(error)
            }
            .log()
    }
}
