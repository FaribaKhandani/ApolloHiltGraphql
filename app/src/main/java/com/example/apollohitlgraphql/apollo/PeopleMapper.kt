package com.example.apollohitlgraphql.apollo

import com.example.AllPeopleQuery
import com.example.PersonQuery
import com.example.apollohitlgraphql.model.PeopleQuery
import com.example.apollohitlgraphql.model.*




fun AllPeopleQuery.AllPeople.toPeople() :List<People>{

    return people!!.map{
        people ->
        com.example.apollohitlgraphql.model.People(
            id = people?.id!!
            , name = people.name!!
            , filmConnection = people?.filmConnection?.totalCount
        )
    }
}




fun PersonQuery.Person.toDetailPeople():PeopleDetail{
    return com.example.apollohitlgraphql.model.PeopleDetail(

        code  = this.id ?: "",
        name = this.name.toString() ?: "No Data",
        hairColor = this.hairColor.toString() ?: "No Data",
        gender  = this.gender.toString() ?: "No Data",
        eyeColor =this.eyeColor.toString() ?: "No Data",
        created = this.created.toString() ?: "No Data",
        birthYear = this.birthYear.toString() ?: "No Data"
    )

}




