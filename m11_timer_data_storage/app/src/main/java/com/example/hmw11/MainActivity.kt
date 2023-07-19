package com.example.hmw11

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.hmw11.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var preference = Repository(this)
        binding.textView.text = preference.getText()

        binding.save.setOnClickListener {
            preference.saveText(binding.editText.text.toString())
            binding.textView.text = preference.getText()
        }

        binding.delet.setOnClickListener {
            preference.clearText()
            binding.textView.text = preference.getText()
        }
    }
}