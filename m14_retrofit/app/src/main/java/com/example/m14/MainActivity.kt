package com.example.m14

import androidx.lifecycle.lifecycleScope
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.m14.databinding.ActivityMainBinding
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {


    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)

        viewModel.asyncGetRandomUser()
//        val retrofit = RetrofitInstance.searchUserApi

//        CoroutineScope(Dispatchers.IO).launch {
//            try {
//               var user = retrofit.getRandomUser()
//                println("XUI ${user.results}")
//            } catch (e: Throwable) {
//                e.message?.let { Log.e("My error", it) }
//            }
//        }
        lifecycleScope.launch {
            viewModel.state.collect {
                CoroutineScope(Dispatchers.Main).launch {
                    if (it != null) {
                        userReceived(it, binding)
                    }
                }
                println("I am collecting message $it")
            }

            // do your Coroutine Stuff here, i.e. call a suspend fun:
//            repeat(100) {
//                delay(1000)
//                println("111111111111111111111111111111111111111111111")
//                coroutineFunction()
//            }
        }
        println("QQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQ")
        binding.button.setOnClickListener {
            viewModel.asyncGetRandomUser()
        }
    }

    fun userReceived(user: User, binding: ActivityMainBinding) {
        binding.text.text = user.results[0].gender
//        только здесь можно присваивать значение юзера
    }

}