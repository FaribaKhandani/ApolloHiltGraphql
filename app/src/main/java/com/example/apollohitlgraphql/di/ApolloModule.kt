package com.example.apollohitlgraphql.di

import com.apollographql.apollo3.ApolloClient
import com.example.apollohitlgraphql.apollo.ApolloPeopleClient
import com.example.apollohitlgraphql.viewmodel.GetPlanetRepo
import com.example.apollohitlgraphql.viewmodel.GetPlanetsRepo
import com.example.apollohitlgraphql.apollo.PlanetClient
import com.example.apollohitlgraphql.apollo.ApolloPlanetClient
import com.example.apollohitlgraphql.apollo.ApolloStarShipClient
import com.example.apollohitlgraphql.apollo.PeopleClient
import com.example.apollohitlgraphql.apollo.StarShipClient
import com.example.apollohitlgraphql.viewmodel.GetPeopleRepo
import com.example.apollohitlgraphql.viewmodel.GetPersonRepo
import com.example.apollohitlgraphql.viewmodel.GetStarShipRepo
import com.example.apollohitlgraphql.viewmodel.GetStarShipsRepo
import com.example.apollohitlgraphql.viewmodel.StarShipsViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApolloModule {


    @Provides
    @Singleton
    fun provideApolloClient(): ApolloClient {
        return ApolloClient.Builder()
            .serverUrl("https://swapi-graphql.netlify.app/.netlify/functions/index")
            .build()
    }


    @Provides
    @Singleton
    fun providePlanetClient(apolloClient: ApolloClient): PlanetClient {
        return ApolloPlanetClient(apolloClient)
    }


    @Provides
    @Singleton
    fun providesPlanetsRepo(planetClient: PlanetClient): GetPlanetsRepo {
        return GetPlanetsRepo(planetClient)
    }

    @Provides
    @Singleton
    fun providesPlanetRepo(planetClient: PlanetClient): GetPlanetRepo {
        return GetPlanetRepo(planetClient)
    }



    @Provides
    @Singleton
    fun provideStarShipClient(apolloClient: ApolloClient): StarShipClient {
        return ApolloStarShipClient(apolloClient)
    }


    @Provides
    @Singleton
    fun providesStarShipsRepo(starShipClient: StarShipClient):GetStarShipsRepo {
        return GetStarShipsRepo(starShipClient)
    }


    @Provides
    @Singleton
    fun providesStarShipRepo(starShipClient: StarShipClient):GetStarShipRepo {
        return GetStarShipRepo(starShipClient)
    }





    @Provides
    @Singleton
    fun providePeopleClient(apolloClient: ApolloClient): PeopleClient {
        return ApolloPeopleClient(apolloClient)
    }


    @Provides
    @Singleton
    fun providePeopleRepo(peopleClient: PeopleClient): GetPeopleRepo {
        return GetPeopleRepo(peopleClient)
    }

    @Provides
    @Singleton
    fun providePersonRepo(peopleClient: PeopleClient): GetPersonRepo {
        return GetPersonRepo(peopleClient)
    }


}