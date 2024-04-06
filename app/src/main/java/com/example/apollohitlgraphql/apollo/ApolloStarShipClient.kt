package com.example.apollohitlgraphql.apollo

import com.apollographql.apollo3.ApolloClient
import com.example.StarShipQuery
import com.example.apollohitlgraphql.model.StarShip
import com.example.apollohitlgraphql.model.StarShipDetail
import com.example.apollohitlgraphql.model.StarShipsQuery

class ApolloStarShipClient(private val apolloClient: ApolloClient):StarShipClient {


    override suspend fun getStarShips(): List<StarShip> {
        return apolloClient.query(com.example.StarShipsQuery()).
        execute()
            .data
            ?.allStarships
            ?.toStarShips()?: emptyList()


    }

    override suspend fun getStarShipDetail(code: String): StarShipDetail? {
        return apolloClient.query(StarShipQuery(code))
            .execute()
            .data
            ?.starship
            ?.toDetailPlanet()
    }
}