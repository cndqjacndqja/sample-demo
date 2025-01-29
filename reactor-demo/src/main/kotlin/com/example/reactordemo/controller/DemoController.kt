package com.example.reactordemo.controller

import com.example.reactordemo.client.SampleClient
import com.example.reactordemo.service.DemoService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/demo")
class DemoController(
    private val demoService: DemoService,
    private val sampleClient: SampleClient
) {
    @GetMapping
    fun getAll(): String {
        return sampleClient.getSomeData()
    }
}
