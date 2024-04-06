package com.example.apollohitlgraphql.apollo



import com.example.apollohitlgraphql.model.StarShip
import com.example.apollohitlgraphql.model.StarShipDetail

interface StarShipClient {

    suspend fun getStarShips(): List<StarShip>
    suspend fun getStarShipDetail(code :String): StarShipDetail?
}