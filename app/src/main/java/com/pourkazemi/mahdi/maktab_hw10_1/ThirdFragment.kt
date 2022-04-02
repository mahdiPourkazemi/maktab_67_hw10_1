package com.pourkazemi.mahdi.maktab_hw10_1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.setFragmentResultListener
import androidx.navigation.fragment.findNavController
import com.pourkazemi.mahdi.maktab_hw10_1.databinding.FragmentThirdBinding

class ThirdFragment : Fragment(R.layout.fragment_third) {
    private var _binding: FragmentThirdBinding? = null
    private val binding get() = _binding!!
    private var isCheated: Boolean? = null
    private val myViewModel: MyViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setFragmentResultListener("cheated") { key, bundle ->
            isCheated = bundle.getBoolean("cheat")
            isCheated?.let { myViewModel.addToList(2, it) }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentThirdBinding.bind(view)
        myViewModel.bList.observe(viewLifecycleOwner) {
            isCheated = it[2]

        }
        isCheated?.let {
            Toast.makeText(
                requireContext(),
                "your cheating is $isCheated",
                Toast.LENGTH_SHORT
            ).show()
        }
        binding.btnNext.setOnClickListener {
            findNavController().navigate(R.id.tFragment_to_fFragment)
        }
        binding.btnPre.setOnClickListener {
            findNavController().popBackStack()
        }
        binding.btnCheat.setOnClickListener {
            val action = FirstFragmentDirections.toCheat(3)
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

    override fun onSaveInstanceState(outState: Bundle) {
        outState.run {
            isCheated?.let { putBoolean("cheat", it) }
        }
        super.onSaveInstanceState(outState)
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        isCheated = savedInstanceState?.getBoolean("cheat")
        isCheated?.let {
            Toast.makeText(
                requireContext(),
                "${savedInstanceState?.getBoolean("cheat")}",
                Toast.LENGTH_SHORT
            ).show()
        }
        super.onViewStateRestored(savedInstanceState)
    }

    override fun onResume() {
        super.onResume()
        isCheated?.let {
            Toast.makeText(
                requireContext(),
                "you are cheating is $it",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}