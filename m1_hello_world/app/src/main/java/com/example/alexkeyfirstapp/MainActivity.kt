package com.example.alexkeyfirstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import com.example.alexkeyfirstapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    var counter_ = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        binding.bottomText.text = counter_.toString()
        setContentView(binding.root)
        binding.centerText.text = "Все места свободны"

        binding.minus.setOnClickListener {
            counter_--
            if (counter_ > 0) {
                binding.minus.isEnabled = true
                binding.plus.isEnabled = true
                binding.reset.visibility = View.INVISIBLE
                binding.centerText.text = getString(R.string.process, counter_)
                binding.centerText.setTextColor(
                    ContextCompat.getColor(
                        applicationContext,
                        R.color.blu
                    )
                )
            } else if (counter_ == 0) {
                binding.centerText.text = "Все места свободны"
                binding.centerText.setTextColor(
                    ContextCompat.getColor(
                        applicationContext,
                        R.color.green
                    )
                )
                binding.minus.isEnabled = false

            } else if (counter_ < 0) {
                counter_ = 0
                binding.minus.isEnabled = false
            }
            binding.bottomText.text = counter_.toString()
        }

        binding.plus.setOnClickListener {
            counter_++
            if (counter_ < 50) {
                binding.plus.isEnabled = true
                binding.minus.isEnabled = true
                binding.reset.visibility = View.INVISIBLE
                binding.centerText.text = getString(R.string.process, counter_)
                binding.centerText.setTextColor(
                    ContextCompat.getColor(
                        applicationContext,
                        R.color.blu
                    )
                )
            } else if (counter_ == 50) {
                binding.reset.visibility = View.VISIBLE
                binding.plus.isEnabled = false
                binding.centerText.text = "Пассажиров слишком много"
                binding.centerText.setTextColor(
                    ContextCompat.getColor(
                        applicationContext,
                        R.color.red
                    )
                )
            }
            binding.bottomText.text = counter_.toString()
        }
        binding.reset.setOnClickListener {
            counter_++
            when {
                counter_ == 51 -> counter_ = 0
            }
            binding.reset.visibility = View.INVISIBLE
            binding.centerText.text = "Все места свободны"
            binding.centerText.setTextColor(
                ContextCompat.getColor(
                    applicationContext,
                    R.color.green
                )
            )
            binding.bottomText.text = counter_.toString()
            binding.plus.isEnabled = true
            binding.minus.isEnabled = true
        }
    }
}