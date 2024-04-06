package com.example.apollohitlgraphql.viewmodel

import com.example.apollohitlgraphql.apollo.PeopleClient
import com.example.apollohitlgraphql.model.PeopleDetail


class GetPersonRepo (private val peopleClient: PeopleClient) {

    suspend fun execute(code: String): PeopleDetail? {
        return peopleClient
            .getPeopleDetail(code)

    }

}