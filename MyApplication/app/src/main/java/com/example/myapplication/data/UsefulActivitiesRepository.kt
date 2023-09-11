package com.example.myapplication.data

import com.example.myapplication.entity.UsefulActivity

class UsefulActivitiesRepository (private val api: UsefulActivityRepository) {

    suspend fun getUsefulActivity(): UsefulActivity {
        return api.getActivity()
    }
}