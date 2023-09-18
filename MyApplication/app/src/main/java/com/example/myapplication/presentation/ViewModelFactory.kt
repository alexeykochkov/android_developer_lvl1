package com.example.myapplication.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import com.example.myapplication.data.RetrofitInstance
import com.example.myapplication.data.UsefulActivitiesRepository
import com.example.myapplication.domain.GetUsefulActivityUseCase
import javax.inject.Inject


class ViewModelFactory @Inject constructor (private val mainViewModel: MainViewModel) {

    val Factory: ViewModelProvider.Factory = object : ViewModelProvider.Factory {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(
            modelClass: Class<T>,
            extras: CreationExtras
        ): T {
            return mainViewModel as T
        }
    }
}