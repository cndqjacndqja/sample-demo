package com.example.reactordemo.client

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping

@FeignClient(name = "sampleClient", url = "http://localhost:8081")
interface SampleClient {
    @GetMapping("/api/demo")
    fun getSomeData(): String // 예제용 반환 타입
}
