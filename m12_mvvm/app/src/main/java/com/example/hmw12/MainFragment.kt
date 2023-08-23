package com.example.hmw12

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.hmw12.databinding.FragmentMainBinding

import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay

import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var binding: FragmentMainBinding
    private val viewModel: MainViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.button.setOnClickListener {
            val text: String = binding.edit.text.toString()
//            if (text.length < 3) {
//                binding.button.isEnabled = false
//
//            }
//            if (text.length > 3) {
//                binding.button.isEnabled = true
                viewModel.findText(text)
//            }
        }

        viewLifecycleOwner.lifecycleScope
            .launchWhenStarted {
                viewModel.state

                    .collect { State ->

                        when (State) {
                            is State.Success -> {
                                val text: String = binding.edit.text.toString()
                                binding.progress.isVisible = false
                                binding.edit.error = null
                                binding.button.isEnabled = true
                                if (text.length > 3) {
                                    binding.textview.text = ("по запросу \"${text}\" ничего не найдено")
                                }
                            }
                            is State.Loading -> {
                                binding.progress.isVisible = true

                                binding.edit.error = null
                                binding.button.isEnabled = false
                            }
                            is State.Error -> {
                                binding.progress.isVisible = false
                                binding.edit.error = State.textError
                                binding.button.isEnabled = true

                            }
                        }
                    }
            }

        viewLifecycleOwner.lifecycleScope
            .launchWhenStarted {
                viewModel.error
                    .collect() { message ->
                        Snackbar.make(requireView(), message, Snackbar.LENGTH_SHORT).show()
                    }
            }
    }
}