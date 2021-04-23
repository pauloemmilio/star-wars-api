package com.paulo.starwars.service

import com.paulo.starwars.domain.Planet
import com.paulo.starwars.repository.PlanetRepository
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate


@Service
class PlanetService(
    val planetRepository: PlanetRepository
) {

    fun search(id: String): ResponseEntity<Planet> {
        val restTemplate = RestTemplate()
        val url = "https://swapi.dev/api/planets/${id}/"
        val result: ResponseEntity<Planet> = restTemplate.getForEntity(url, Planet::class.java)
        this.save(result.body!!)
        return result
    }

    fun save(planet: Planet) {
        val planetOptional = planetRepository.findById(planet.name)
        if(planetOptional.isPresent.not())
            planetRepository.save(planet)
    }

    fun list(): MutableList<Planet> {
        return planetRepository.findAll()
    }

}