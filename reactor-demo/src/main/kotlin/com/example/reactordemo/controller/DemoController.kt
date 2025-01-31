package com.example.reactordemo.controller

import com.example.reactordemo.service.DemoService
import kotlinx.coroutines.*
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Mono
import kotlin.coroutines.CoroutineContext

@RestController
@RequestMapping("/api/demo")
class DemoController(
    private val demoService: DemoService,
    private val coroutineContext: CoroutineContext
) {
    @GetMapping
    suspend fun getAll(): String = withContext(coroutineContext) {
        log.info("Coroutine context: ${coroutineContext[CoroutineName]}, Thread: ${Thread.currentThread().name}")

        val result = awaitAll(
            async { demoService.find() },
            async { demoService.find() }
        )
        "${result[0]}, ${result[1]}"
    }

    companion object {
        private val log = LoggerFactory.getLogger(DemoController::class.java)
    }
}
