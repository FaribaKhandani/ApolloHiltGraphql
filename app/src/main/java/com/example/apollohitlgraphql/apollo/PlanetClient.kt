package com.example.apollohitlgraphql.apollo

import com.example.apollohitlgraphql.model.Planet
import com.example.apollohitlgraphql.model.PlanetDetail

interface PlanetClient {

    suspend fun getPlanets(): List<Planet>
    suspend fun getPlanetDetail(code :String): PlanetDetail?
}