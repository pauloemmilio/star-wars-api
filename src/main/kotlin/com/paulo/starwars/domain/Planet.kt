package com.paulo.starwars.domain

import javax.persistence.Entity
import javax.persistence.Id

@Entity
data class Planet(
    @Id
    val name: String,
    val climate: String,
    val terrain: String,
    val population: String
) {
}