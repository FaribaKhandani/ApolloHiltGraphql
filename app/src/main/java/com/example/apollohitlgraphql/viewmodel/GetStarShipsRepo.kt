package com.example.apollohitlgraphql.viewmodel

import com.example.apollohitlgraphql.apollo.StarShipClient
import com.example.apollohitlgraphql.model.StarShip

class GetStarShipsRepo(private val  starShipClient: StarShipClient) {

    suspend fun execute():List<StarShip>{
        return starShipClient
            .getStarShips()
            .sortedBy { it.name }
    }
}