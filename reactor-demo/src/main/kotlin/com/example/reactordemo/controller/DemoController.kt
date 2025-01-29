package com.example.reactordemo.controller

import com.example.sampledemo.service.DemoService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/demo")
class DemoController(
    private val demoService: DemoService
) {
    @GetMapping
    fun getAll() {

    }
}
