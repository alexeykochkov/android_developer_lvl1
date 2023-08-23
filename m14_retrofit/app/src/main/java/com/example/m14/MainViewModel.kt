package com.example.m14

import android.util.Log
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    val retrofit = RetrofitInstance.searchUserApi
    private val state_ = MutableStateFlow<User?>(null)
    val state = state_.asStateFlow()

    fun asyncGetRandomUser() {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                println("IO")
               state_.value = retrofit.getRandomUser()

            } catch (e: Throwable) {
                e.message?.let { Log.e("My error", it) }
            }
        }
    }
}