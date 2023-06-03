package com.example.homework7

import android.content.Intent
import android.media.MediaActionSound
import android.media.MediaPlayer
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.activity.OnBackPressedCallback
import androidx.navigation.fragment.findNavController
import com.example.homework7.databinding.FragmentFirstBinding
import com.example.homework7.databinding.FragmentSecondBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [SecondFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SecondFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var bundle_ = Bundle()
    private var onBackPressedCallback: OnBackPressedCallback? = null

    override fun onDestroyView() {
        onBackPressedCallback?.isEnabled = false
        onBackPressedCallback?.remove()
        super.onDestroyView()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_second, container, false)
        onBackPressedCallback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                findNavController().navigate(R.id.firstFragment)
            }
        }.apply {
            activity?.onBackPressedDispatcher?.addCallback(this)
        }

        val yesSound = MediaPlayer.create(requireContext(), R.raw.right)
        val noSound = MediaPlayer.create(requireContext(), R.raw.wrong)

        super.onCreate(savedInstanceState)

        val binding = FragmentSecondBinding.inflate(layoutInflater)

        binding.back.setOnClickListener {
            findNavController().popBackStack()
        }

        class FirstBlock(
            var bundle: Bundle,
            var rightAnswer: String,
            var buttonsToDisable: MutableList<Button>,
            var answer: String = "answer"
        ) {
            var sound: MediaPlayer = noSound
            init {
                if (rightAnswer == "yes") {
                    sound = yesSound
                }
            }

            fun f() {
                bundle.putString(answer, rightAnswer)
                buttonsToDisable.forEach {
                    it.isEnabled = false
                }
                sound.start()
            }
        }

        var buttons =
            mutableListOf(binding.firstAnswer, binding.secondAnswer, binding.thirdAnswer)

        var firstBlocks = mutableListOf(
            FirstBlock(bundle_, "no", mutableListOf(binding.secondAnswer, binding.thirdAnswer)),
            FirstBlock(bundle_, "no", mutableListOf(binding.firstAnswer, binding.thirdAnswer)),
            FirstBlock(bundle_, "yes", mutableListOf(binding.firstAnswer, binding.secondAnswer))
        )

        for (i in 0 until firstBlocks.size) {
            buttons[i].setOnClickListener {
                firstBlocks[i].f()
            }
        }

        // Second Question
        var a = FirstBlock(
            bundle_,
            "no",
            mutableListOf(binding.secondAnswer2, binding.thirdAnswer3),
            "answer2"
        )
        var b = FirstBlock(
            bundle_,
            "no",
            mutableListOf(binding.secondAnswer1, binding.thirdAnswer3),
            "answer2"
        )
        var c = FirstBlock(
            bundle_,
            "yes",
            mutableListOf(binding.secondAnswer1, binding.secondAnswer2),
            "answer2"
        )

        binding.secondAnswer1.setOnClickListener {
            a.f()
        }

        binding.secondAnswer2.setOnClickListener {
            b.f()
        }

        binding.thirdAnswer3.setOnClickListener {
            c.f()
        }

        // Third Question
        binding.thirdAnswer1.setOnClickListener {
            bundle_.putString("answer3", "no")
            binding.thirdAnswer2.isEnabled = false
            binding.thirdAnswer33.isEnabled = false
        }

        binding.thirdAnswer2.setOnClickListener {
            bundle_.putString("answer3", "no")
            binding.thirdAnswer1.isEnabled = false
            binding.thirdAnswer33.isEnabled = false
        }

        binding.thirdAnswer33.setOnClickListener {
            bundle_.putString("answer3", "yes")
            binding.thirdAnswer1.isEnabled = false
            binding.thirdAnswer2.isEnabled = false
        }

        binding.next.setOnClickListener {
            findNavController().navigate(R.id.thirdFragment, bundle_)
        }
        return binding.root
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment SecondFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SecondFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}