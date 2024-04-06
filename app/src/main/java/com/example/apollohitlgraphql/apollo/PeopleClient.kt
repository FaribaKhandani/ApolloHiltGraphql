package com.example.apollohitlgraphql.apollo

import com.example.apollohitlgraphql.model.People
import com.example.apollohitlgraphql.model.PeopleDetail

interface PeopleClient {

    suspend fun getPeople(): List<People>
    suspend fun getPeopleDetail(code :String): PeopleDetail?
}