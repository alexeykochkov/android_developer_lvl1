package com.example.hmw15

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class MainViewModel() : ViewModel() {

    private val checkValidateText = MutableLiveData<Unit>()
    val showValidate: LiveData<Unit> = checkValidateText

    var tableDao: TableDao? = null
    fun allTableText(): Flow<List<Table>>? {
        return this.tableDao?.getAll()
    }

    fun addText(text: String) {
        viewModelScope.launch {
           if (checkInputText(text) == true) {
             checkValidateText.value = Unit
               return@launch
           } else {
               val getItem = tableDao?.getItem(text)
               if (getItem == null) {
                   tableDao?.insert(Table(text, 1))
               } else {
                   tableDao?.update(Table(text, getItem.counter + 1))
               }
           }
        }
    }

    fun delete () {
        viewModelScope.launch {
            tableDao?.deleteAll()
        }
    }

    fun checkInputText (text: String): Boolean {
        return "[^a-zA-Z0-9-]".toRegex().find(text)?.value != null
    }
}