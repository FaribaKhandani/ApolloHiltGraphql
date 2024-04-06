package com.example.apollohitlgraphql.apollo

import com.apollographql.apollo3.ApolloClient
import com.example.PlanetQuery
import com.example.PlanetsQuery
import com.example.apollohitlgraphql.model.Planet
import com.example.apollohitlgraphql.model.PlanetDetail

class ApolloPlanetClient (private val apolloClient: ApolloClient): PlanetClient {


    override suspend fun getPlanets(): List<Planet> {

        return apolloClient
            .query(PlanetsQuery())
            .execute()
            .data
            ?.allPlanets
            ?.toPlanets() ?: emptyList()

    }

    override suspend fun getPlanetDetail(code: String): PlanetDetail? {
        return apolloClient
            .query(PlanetQuery(code))
            .execute()
            ?.data
            ?.planet
            ?.toDetailPlanet()
    }


}


