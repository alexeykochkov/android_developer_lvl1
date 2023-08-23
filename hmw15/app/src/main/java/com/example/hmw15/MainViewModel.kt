package com.example.hmw15

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class MainViewModel(): ViewModel() {

    var tableDao: TableDao? = null
    fun allTableText (): Flow<List<Table>>? {
        return this.tableDao?.getAll()
    }

    fun addText(text: String){
       viewModelScope.launch {
           tableDao?.insert(Table(text,1))
       }
    }

//    fun addText(text: String){
//
//    }

}