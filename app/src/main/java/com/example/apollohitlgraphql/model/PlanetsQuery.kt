package com.example.apollohitlgraphql.model

data class PlanetsQuery(
    val allPlanets: AllPlanets
)

data class AllPlanets(
    val planets: List<Planet>
)

data class Planet(
    val id :String,
    val name: String?,
    val filmConnection: Int?,

)


data class FilmConnection(
    val totalCount: Int?
)
