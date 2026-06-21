package com.example.sports.network

import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface AuthApiService {

    @GET("users")
    suspend fun getUsers(): List<User>

    @POST("users")
    suspend fun registerUser(
        @Body user: User
    ): User
}