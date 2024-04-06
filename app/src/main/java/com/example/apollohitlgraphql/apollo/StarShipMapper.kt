package com.example.apollohitlgraphql.apollo




import com.example.StarShipQuery
import com.example.StarShipsQuery
import com.example.apollohitlgraphql.model.*
import com.example.apollohitlgraphql.model.StarShip



fun com.example.StarShipsQuery.AllStarships.toStarShips():List<StarShip>{
    return starships!!.map { starship -> StarShip(
        id = starship?.id!!
        , name = starship.name!!
       , filmConnection = starship?.filmConnection?.totalCount
    ) }
}




fun StarShipQuery.Starship.toDetailPlanet() : StarShipDetail {
    return StarShipDetail(
        code = this.id ?: "",
        name =this.name.toString() ?: "No Data",
        model = this.model.toString() ?: "No Data",
         edited = this.edited.toString() ?: "No Data",
     created = this.created.toString() ?: "No Data",
        crew =this.crew.toString() ?: "No Data",
     passengers = this.passengers.toString() ?: "No Data"
    )

}




