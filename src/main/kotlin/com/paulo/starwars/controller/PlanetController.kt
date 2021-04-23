package com.paulo.starwars.controller

import com.paulo.starwars.domain.Planet
import com.paulo.starwars.service.PlanetService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/planets")
class PlanetController(
    val planetService: PlanetService
) {

    @GetMapping("/{id}")
    fun search(@PathVariable id: String): ResponseEntity<Planet> {
        return try {
            planetService.search(id)
        } catch (e: Exception) {
            ResponseEntity.status(HttpStatus.NOT_FOUND).build()
        }
    }

    @GetMapping
    fun list(): ResponseEntity<List<Planet>> {
        return ResponseEntity.ok(planetService.list())
    }

    @PostMapping
    fun save(@RequestBody planet: Planet): ResponseEntity<Any> {
        return try {
            planetService.save(planet)
            ResponseEntity.status(HttpStatus.CREATED).build()
        } catch (e: Exception) {
            ResponseEntity.status(HttpStatus.BAD_REQUEST).build()
        }
    }
}