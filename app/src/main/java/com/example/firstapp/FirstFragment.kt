package com.example.firstapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.firstapp.databinding.FragmentFirstBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.randomButton.setOnClickListener {
            randomButtonTapped()
        }

        binding.toastButton.setOnClickListener {
            toastButtonTapped()
        }

        binding.countButton.setOnClickListener {
            countMe(view)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun randomButtonTapped() {
        val showCountTextView = binding.textviewFirst
        val currentCount = showCountTextView.text.toString().toInt()
        val action = FirstFragmentDirections.actionFirstFragmentToSecondFragment(currentCount)
        findNavController().navigate(action)
    }

    private fun toastButtonTapped() {
        val myToast = Toast.makeText(context, "Hello Toast!", Toast.LENGTH_SHORT)
        myToast.show()
    }

    private fun countMe(view: View) {
        val showCountTextView = binding.textviewFirst
        val countString = showCountTextView.text.toString()
        var count = countString.toInt()
        count++
        showCountTextView.text = count.toString()
    }
}