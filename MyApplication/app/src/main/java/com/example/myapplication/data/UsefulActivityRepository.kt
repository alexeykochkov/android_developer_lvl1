package com.example.myapplication.data

import retrofit2.http.GET

interface UsefulActivityRepository {

    @GET("activity/")
    suspend fun getActivity(): UsefulActivityDto

}


