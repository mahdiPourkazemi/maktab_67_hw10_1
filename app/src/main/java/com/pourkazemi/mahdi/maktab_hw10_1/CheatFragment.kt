package com.pourkazemi.mahdi.maktab_hw10_1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import androidx.navigation.NavArgs
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.pourkazemi.mahdi.maktab_hw10_1.databinding.FragmentCheatBinding


class CheatFragment : Fragment(R.layout.fragment_cheat) {
    private val mNav: CheatFragmentArgs by navArgs()
    private var _binding: FragmentCheatBinding? = null
    private val binding get() = _binding!!
    private var value = 0
    private var isCheated = false
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentCheatBinding.bind(view)
        value = mNav.quz
        /* arguments?.let {
             value = it.getInt("quz")
         }*/
        binding.btnCheated.setOnClickListener {
            binding.tvAnswer.text = "your $value quz answer is True"
            isCheated = true
        }
    }

    override fun onPause() {
        super.onPause()
        setFragmentResult(
            "cheated",
            bundleOf("cheat" to isCheated)
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}