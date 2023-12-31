package com.example.hmw12

sealed class State() {
    object Loading: State()
    object Success: State ()
    data class Error(val textError: String?): State()
  }
