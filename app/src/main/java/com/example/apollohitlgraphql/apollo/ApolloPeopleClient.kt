package com.example.apollohitlgraphql.apollo

import com.apollographql.apollo3.ApolloClient
import com.example.AllPeopleQuery
import com.example.PersonQuery
import com.example.apollohitlgraphql.model.People
import com.example.apollohitlgraphql.model.PeopleDetail


class ApolloPeopleClient(private val apolloClient: ApolloClient) :PeopleClient{
    override suspend fun getPeople(): List<People> {

        return apolloClient
            .query(AllPeopleQuery())
            .execute()
            .data
            ?.allPeople
            ?.toPeople() ?: emptyList()
    }

    override suspend fun getPeopleDetail(code: String): PeopleDetail? {
        return apolloClient.query(PersonQuery(code))
            .execute()
            .data
            ?.person
            ?.toDetailPeople()
    }


}