package com.example.hmw15

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.widget.doAfterTextChanged
import androidx.lifecycle.lifecycleScope
import com.example.hmw15.databinding.ActivityMainBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity() {
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val tableDao: TableDao = (application as App).db.tableDao()
        viewModel.tableDao = tableDao

        binding.addText.setOnClickListener {
            viewModel.addText(binding.editText.text.toString())
            binding.editText.setText("")
        }

        binding.editText.doAfterTextChanged {
            binding.inputText.error = ""
        }

        lifecycleScope.launch {
            viewModel.showValidate.observe(this@MainActivity) {
                binding.inputText.error = "допустимы только буквы и дефисы"
            }
            viewModel.allTableText()?.collect() {
                val endOfCount = if (it.count() > 5) {
                    5
                } else {
                    it.count()
                }
                binding.textView.text =
                    it.subList(0, endOfCount).map { "${it.word}_${it.counter.toString()}" }
                        .joinToString("\n")
            }
        }
        binding.clearText.setOnClickListener {
            viewModel.delete()
        }
    }
}