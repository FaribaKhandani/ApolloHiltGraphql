package com.example.apollohitlgraphql.model

data class PeopleQuery(
    val allPeople:AllPeople
)

data class AllPeople(
    val people: List<People>
)

data class People(
    val id:String
    ,val name :String
    ,val filmConnection: Int?
)

data class FilmPConnection(
    val totalCount: Int?
)