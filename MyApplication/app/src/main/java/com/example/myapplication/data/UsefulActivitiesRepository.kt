package com.example.myapplication.data

import com.example.myapplication.entity.UsefulActivity
import javax.inject.Inject

class UsefulActivitiesRepository @Inject constructor (private val api: UsefulActivityRepository) {

    suspend fun getUsefulActivity(): UsefulActivity {
        return api.getActivity()
    }
}