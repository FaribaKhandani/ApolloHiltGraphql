package com.example.apollohitlgraphql.viewmodel

import com.example.apollohitlgraphql.apollo.StarShipClient
import com.example.apollohitlgraphql.model.StarShipDetail

class GetStarShipRepo(private val starShipClient: StarShipClient) {
    suspend fun execute(code:String):StarShipDetail?{
        return starShipClient
            .getStarShipDetail(code)
    }
}