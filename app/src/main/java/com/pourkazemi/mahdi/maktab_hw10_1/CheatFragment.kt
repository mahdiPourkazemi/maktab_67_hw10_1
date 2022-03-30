package com.pourkazemi.mahdi.maktab_hw10_1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.pourkazemi.mahdi.maktab_hw10_1.databinding.FragmentCheatBinding


class CheatFragment : Fragment(R.layout.fragment_cheat) {
    private var _binding: FragmentCheatBinding? = null
    private val binding get() = _binding!!
    private var value = 0
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentCheatBinding.bind(view)
        arguments?.let {
            value = it.getInt("quz")
        }
        binding.btnCheated.setOnClickListener {
            binding.tvAnswer.text = "your $value quz answer is True"
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}