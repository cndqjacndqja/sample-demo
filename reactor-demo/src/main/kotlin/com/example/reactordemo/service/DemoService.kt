package com.example.reactordemo.service

import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.currentCoroutineContext
import kotlinx.coroutines.reactive.awaitSingle
import kotlinx.coroutines.withContext
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Mono
import kotlin.coroutines.CoroutineContext

@Service
class DemoService(
    private val webClient: WebClient,
    @Autowired private val coroutineContext: CoroutineContext
) {
    suspend fun find(): String = withContext(coroutineContext) {
        log.info("Service coroutine context: ${coroutineContext[CoroutineName]}, Thread: ${Thread.currentThread().name}")

        webClient
            .get()
            .uri("/api/demo")
            .retrieve()
            .bodyToMono(String::class.java)
            .doOnSubscribe {
                log.info("Reactor subscribe - Thread: ${Thread.currentThread().name}")
            }
            .doOnNext {
                log.info("Reactor onNext - Thread: ${Thread.currentThread().name}")
            }
            .doOnSuccess {
                log.info("Reactor onSuccess - Thread: ${Thread.currentThread().name}")
            }
            .doOnError { error ->
                log.error("Error occurred - Thread: ${Thread.currentThread().name}", error)
            }
            .awaitSingle()
    }

    companion object {
        private val log = LoggerFactory.getLogger(DemoService::class.java)
    }
}
