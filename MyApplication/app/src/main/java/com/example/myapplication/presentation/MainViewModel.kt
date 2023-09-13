package com.example.myapplication.presentation

import android.util.Log
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

class MainViewModel(val case: GetUsefulActivityUseCase) : ViewModel() {

    private val state_ = MutableStateFlow<UsefulActivity?>(null)

    companion object {

        val Factory: ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(
                modelClass: Class<T>,
                extras: CreationExtras
            ): T {
                val gto =
                    GetUsefulActivityUseCase(rerpository = UsefulActivitiesRepository(
                        RetrofitInstance.usefulActivityRepository)
                    )
                return MainViewModel(gto) as T
            }
        }
    }

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