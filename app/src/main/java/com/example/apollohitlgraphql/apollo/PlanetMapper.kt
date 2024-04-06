package com.example.apollohitlgraphql.apollo

import com.example.PlanetQuery
import com.example.PlanetsQuery
import com.example.apollohitlgraphql.model.Planet
import com.example.apollohitlgraphql.model.PlanetDetail

fun PlanetsQuery.AllPlanets.toPlanets() :List<Planet>{
    return planets!!.map { planet ->
        Planet(
            id = planet!!.id,
            name = planet?.name,
            filmConnection = planet?.filmConnection?.totalCount
        )
    }
}




fun PlanetQuery.Planet.toDetailPlanet(): PlanetDetail {
    return PlanetDetail(
        code = this.id ?: "",
        name = this.name ?: "No Data",
        gravity = this.gravity?.toString() ?: "No Data",
        population = this.population?.toFloat()?: 0f,
        rotationPeriod = this.rotationPeriod?.toInt() ?: 0,
        edited = this.edited?.toString() ?: "No Dta",
        created = this.created?.toString() ?: "No Data"
    )
}







