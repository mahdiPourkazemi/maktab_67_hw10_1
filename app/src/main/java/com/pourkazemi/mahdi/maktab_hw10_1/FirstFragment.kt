package com.pourkazemi.mahdi.maktab_hw10_1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.pourkazemi.mahdi.maktab_hw10_1.databinding.FragmentFirstBinding


class FirstFragment : Fragment(R.layout.fragment_first) {
    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!
        /*arguments?.let {
        }*/
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentFirstBinding.bind(view)
            binding.btnNext.setOnClickListener {
                findNavController().navigate(R.id.fFg_to_sFg)
            }
            binding.btnPre.setOnClickListener {
                onDetach()
            }
            binding.btnCheat.setOnClickListener {
                val action=FirstFragmentDirections.toCheat(1)
                findNavController().navigate(action)
            }
            binding.btnTrue.setOnClickListener {
                Toast.makeText(requireContext(), "your answer is TRUE", Toast.LENGTH_SHORT).show()
            }
    }

    /*       FirstFragment().apply {
                    arguments = Bundle().apply {
                        putString(ARG_PARAM1, param1)
                        putString(ARG_PARAM2, param2)
                    }
    }*/
    override fun onDestroyView() {
        super.onDestroyView()
        _binding=null
    }
}