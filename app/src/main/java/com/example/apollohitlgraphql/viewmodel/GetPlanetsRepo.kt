package com.example.apollohitlgraphql.viewmodel

import com.example.apollohitlgraphql.apollo.PlanetClient
import com.example.apollohitlgraphql.model.Planet

class GetPlanetsRepo(private val planetClient: PlanetClient) {

    suspend fun execute():List<Planet>{
        return planetClient
            .getPlanets()
            .sortedBy { it.name }
    }

}