package com.example.myapplication.data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    private const val BASE_URL = "https://www.boredapi.com/api/"

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create()) //Библиотека сериализатор который будет преобразовывать входящий json в объет который мы укажем в коллбэке call
//            функции getRandomUser
        .build()

    val usefulActiv ityRepository: UsefulActivityRepository = retrofit.create(UsefulActivityRepository::class.java) //это создание ретрофит сервиса

}