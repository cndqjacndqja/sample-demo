package com.example.reactordemo.config

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.Dispatchers
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.client.WebClient

@Configuration
class WebClientConfig {
    @Bean
    fun webClient(): WebClient {
        return WebClient.builder()
            .baseUrl("http://localhost:8081")
            .build()
    }

    @Bean
    fun coroutineContext(
        coroutineDispatcher: CoroutineDispatcher
    ) = CoroutineName("demo-coroutine") + coroutineDispatcher

    @Bean
    fun coroutineDispatcher(): CoroutineDispatcher {
        return Dispatchers.Default.limitedParallelism(5)
    }
}
