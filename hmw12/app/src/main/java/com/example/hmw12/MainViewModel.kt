package com.example.hmw12

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    private val state_ = MutableStateFlow<State>(State.Success(""))
    val state = state_.asStateFlow()

    fun findText(text: String) {
        viewModelScope.launch {
            state_.value = State.Loading
            delay(5_000)
            state_.value = State.Success("по запросу \"${text}\" ничего не найдено")
        }
    }
}