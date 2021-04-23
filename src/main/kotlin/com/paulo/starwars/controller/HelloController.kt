package com.paulo.starwars.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/hello")
class HelloController {

    @GetMapping
    fun hello1(): String {
        return "Hello Paulo"
    }

    @GetMapping("/{name}")
    fun hello2(@PathVariable name: String): String {
        return "Hello $name"
    }
}