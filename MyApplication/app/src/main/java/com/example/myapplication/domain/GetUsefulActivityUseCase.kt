package com.example.myapplication.domain

import com.example.myapplication.data.UsefulActivitiesRepository
import com.example.myapplication.data.UsefulActivityRepository
import com.example.myapplication.entity.UsefulActivity
import javax.inject.Inject

class GetUsefulActivityUseCase @Inject constructor(private val rerpository: UsefulActivitiesRepository) {

    suspend fun execute(): UsefulActivity {
        return rerpository.getUsefulActivity()
    }
}