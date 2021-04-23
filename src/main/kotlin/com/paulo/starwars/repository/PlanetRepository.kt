package com.paulo.starwars.repository

import com.paulo.starwars.domain.Planet
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface PlanetRepository: JpaRepository<Planet, String> {
    fun findByName(name: String): Optional<Planet>
}