package com.example.hmw12

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.util.Observable

class MainViewModel : ViewModel() {
    private val state_ = MutableStateFlow<State>(State.Success(""))
    val state = state_.asStateFlow()
    val observer = MyObservable()
    var jobFindText: Job? = null

    fun findText(text: String) {
//        jobFindText?.cancel()
        if (text.length <= 3) {
            jobFindText?.cancel()
            state_.value = State.Success("должно быть больше 3 символов")
            return
        }
        if (jobFindText != null) {
            jobFindText!!.cancel()
        }
        jobFindText = viewModelScope.launch {
            delay(3_000)
            state_.value = State.Loading
            delay(5_000)
            state_.value = State.Success("по запросу \"${text}\" ничего не найдено")
        }


//       observer.debounce(300).onEach {
//            Log.d(it)
//        }.launchIn(viewModelScope)
    }

    inner class MyObservable: BaseObservable () {
        @Bindable
        var text: String = ""
        set(value) {
            field = value
            findText(value)
            notifyPropertyChanged(BR.text)
        }
    }
}