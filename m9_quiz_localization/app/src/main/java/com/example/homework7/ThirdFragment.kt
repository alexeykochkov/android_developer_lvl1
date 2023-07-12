package com.example.homework7

import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.homework7.Result
import com.example.homework7.databinding.FragmentSecondBinding
import com.example.homework7.databinding.FragmentThirdBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ThirdFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ThirdFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    private val args: ThirdFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        // Inflate the layout for this fragment
        val binding = FragmentThirdBinding.inflate(layoutInflater)
        val bundle = args.answer
        if (bundle != null) {
            var result = Result()
            result.deSerialize(bundle)
            binding.results.text = result.get(Result.ANSWER1)
            binding.results2.text = result.get(Result.ANSWER2)
            binding.results3.text = result.get(Result.ANSWER3)
        }

        binding.restart.setOnClickListener {
            findNavController().popBackStack()
        }

        ObjectAnimator.ofFloat(0F, 360F).apply {
            duration = 4000
            addUpdateListener {
                val value = it.animatedValue as Float
                binding.results.rotation = value
                binding.results2.rotation = value
                binding.results3.rotation = value
            }
            start()
        }


        activity?.onBackPressedDispatcher?.addCallback(object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                findNavController().popBackStack(R.id.firstFragment, false)
            }
        }
        )

        return binding.root
//        return inflater.inflate(R.layout.fragment_third, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ThirdFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ThirdFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}