package com.example.firstapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.firstapp.databinding.FragmentSecondBinding
import androidx.navigation.fragment.navArgs

// NOTE: SecondFragment
class SecondFragment : Fragment() {

    // NOTE: Private properties
    private var _binding: FragmentSecondBinding? = null
    private val binding get() = _binding!!
    private val args: SecondFragmentArgs by navArgs()

    // NOTE: Lifecycle
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.previousButton.setOnClickListener {
            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        }
        calculateRandomNumber()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    // NOTE: Private methods
    private fun calculateRandomNumber() {
        val count = args.myArg
        val countText = getString(R.string.random_heading, count)
        binding.textviewHeader.text = countText
        val random = java.util.Random()
        var randomNumber = 0
        if (count > 0) {
            randomNumber = random.nextInt(count + 1)
        }
        binding.textviewRandom.text = randomNumber.toString()
    }
}