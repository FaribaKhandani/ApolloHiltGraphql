package com.example.apollohitlgraphql.viewmodel

import com.example.apollohitlgraphql.apollo.PeopleClient
import com.example.apollohitlgraphql.model.People

class GetPeopleRepo(private val peopleClient: PeopleClient) {

    suspend fun execute():List<People>{
        return peopleClient
            .getPeople()
            .sortedBy { it.name }
    }
}