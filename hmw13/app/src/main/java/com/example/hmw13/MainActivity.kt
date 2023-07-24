package com.example.hmw13

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.hmw13.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        val binding: ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)
//        setContentView (binding.root)

        DataBindingUtil.setContentView<ActivityMainBinding>(this,R.layout.activity_main )
        setContentView(R.layout.activity_main)
    }
}