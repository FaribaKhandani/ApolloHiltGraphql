package com.example.apollohitlgraphql.model

data class StarShipsQuery (
    val allStarShips:AllStarShips
        )

data class AllStarShips(
    val starShips: List<StarShip>
)

data class StarShip(
    val id:String
    ,val name :String
    ,val filmConnection: Int?
)

data class FilmSConnection(
    val totalCount: Int?
)