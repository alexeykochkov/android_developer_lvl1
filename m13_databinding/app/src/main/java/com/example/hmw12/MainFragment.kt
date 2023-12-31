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
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

//        binding.button.setOnClickListener {
//            val text: String = binding.edit.text.toString()
//            viewModel.findText(text)
//        }

//        viewLifecycleOwner.lifecycleScope
//            .launchWhenStarted {
//                viewModel.state
//                    .collect { State ->
//                        binding.textview.text = State.text
//                        when (State) {
//                            is State.Success -> {
//                                binding.progress.isVisible = false
//                            }
//                            is State.Loading -> {
//                                binding.progress.isVisible = true
//                            }
//                        }
//                    }
//            }
    }
}