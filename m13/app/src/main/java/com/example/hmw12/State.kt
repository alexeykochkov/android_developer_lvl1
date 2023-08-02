package com.example.hmw12

sealed class State(open var text: String) {
    object Loading: State("")
    class Success(override var text: String): State(text)
}
