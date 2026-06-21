package com.example.sports.network

import retrofit2.http.GET

interface ApiService {

    @GET("athletes")
    suspend fun getAthletes(): List<ApiAthlete>

}