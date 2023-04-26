package com.example.project2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.project2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.custom.changeText1("Верхняя строчка")
        binding.custom.changeText2("нижняя строчка")

    }
}