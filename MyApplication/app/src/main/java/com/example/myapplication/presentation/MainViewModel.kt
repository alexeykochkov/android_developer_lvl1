package com.example.myapplication.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.CreationExtras
import com.example.myapplication.data.RetrofitInstance
import com.example.myapplication.data.UsefulActivitiesRepository
import com.example.myapplication.domain.GetUsefulActivityUseCase
import com.example.myapplication.entity.UsefulActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(val case: GetUsefulActivityUseCase) : ViewModel() {

    private val state_ = MutableStateFlow<UsefulActivity?>(null)
    val state = state_.asStateFlow()


    fun reloadUsefulActivity() {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                println("IO")
                state_.value = case.execute()

            } catch (e: Throwable) {
                e.message?.let { Log.e("My error", it) }
            }
        }
    }
}