package com.example.hmw12

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    private val state_ = MutableStateFlow<State>(State.Success)
    val state = state_.asStateFlow()

    private val error_ = Channel<String>()
    val error = error_.receiveAsFlow()

    fun findText(text: String) {
        viewModelScope.launch {
            var isTextEmpty = text.length
            if (isTextEmpty <= 3) {
                var textError: String? = null
                state_.value = State.Error(textError)
                error_.send("должно быть больше 3 символов")
            } else {
                state_.value = State.Loading
                delay(5_000)
                state_.value = State.Success
            }
        }
    }
}