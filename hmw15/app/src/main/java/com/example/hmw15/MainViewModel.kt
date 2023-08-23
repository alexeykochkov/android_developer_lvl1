package com.example.hmw15

import androidx.lifecycle.ViewModel

class MainViewModel(private val userDao: UserDao): ViewModel() {

    val allUsers = this.userDao.getAll()
}