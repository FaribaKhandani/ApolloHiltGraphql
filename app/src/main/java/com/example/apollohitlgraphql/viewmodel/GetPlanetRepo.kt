package com.example.apollohitlgraphql.viewmodel

import com.example.apollohitlgraphql.apollo.PlanetClient
import com.example.apollohitlgraphql.model.PlanetDetail

class GetPlanetRepo(private val planetClient: PlanetClient) {

   suspend fun execute(code:String): PlanetDetail?{
       return planetClient
           .getPlanetDetail(code)

   }
}