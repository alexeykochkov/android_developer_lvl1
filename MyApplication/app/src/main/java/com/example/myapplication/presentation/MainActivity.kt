package com.example.myapplication.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewModelScope
import com.example.myapplication.R
import com.example.myapplication.data.RetrofitInstance
import com.example.myapplication.data.UsefulActivitiesRepository
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.di.DaggerAppComponent
import com.example.myapplication.domain.GetUsefulActivityUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels {
        DaggerAppComponent.create().mainViewModelFactory().Factory}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.refresh.setOnClickListener {
            viewModel.reloadUsefulActivity()
        }

        lifecycleScope.launch {
            viewModel.state.collect() {
                binding.text.text = it?.activity
            }
        }
//        val view = MainViewModel(gto)
//        view.reloadUsefulActivity()

//        val gto = GetUsefulActivityUseCase(rerpository = UsefulActivitiesRepository(RetrofitInstance.usefulActivityRepository))
//
        //        val retrofit = RetrofitInstance.usefulActivityRepository
//
//        CoroutineScope(Dispatchers.IO).launch {
//            try {
//                var user = gto.execute()
//                println("XUI ${user.activity}")
//            } catch (e: Throwable) {
//                e.message?.let { Log.e("My error", it) }
//            }
//        }

    }
}