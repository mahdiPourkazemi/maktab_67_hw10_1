package com.pourkazemi.mahdi.maktab_hw10_1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.setFragmentResultListener
import androidx.navigation.fragment.findNavController
import com.pourkazemi.mahdi.maktab_hw10_1.databinding.FragmentNineBinding

class NineFragment : Fragment(R.layout.fragment_nine) {
    private var _binding: FragmentNineBinding? = null
    private val binding get() = _binding!!
    private var isCheated: Boolean? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setFragmentResultListener("cheated") { key, bundle ->
            isCheated = bundle.getBoolean("cheat")
        }

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentNineBinding.bind(view)
        isCheated?.let {
            Toast.makeText(
                requireContext(),
                "your cheating is $isCheated",
                Toast.LENGTH_SHORT
            ).show()
        }
        binding.btnNext.setOnClickListener {
            findNavController().navigate(R.id.nineFragment_to_tenFragment)
        }
        binding.btnPre.setOnClickListener {
            findNavController().popBackStack()
        }
        binding.btnCheat.setOnClickListener {
            val action = FirstFragmentDirections.toCheat(1)
            findNavController().navigate(action)
        }
        binding.btnTrue.setOnClickListener {
            Toast.makeText(
                requireContext(), "your answer is TRUE",
                Toast.LENGTH_SHORT
            ).show()
        }
        binding.btnFalse.setOnClickListener {
            Toast.makeText(
                requireContext(), "your answer is FALSE",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}