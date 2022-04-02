package com.pourkazemi.mahdi.maktab_hw10_1

import android.app.Activity
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.setFragmentResultListener
import androidx.navigation.fragment.findNavController
import com.pourkazemi.mahdi.maktab_hw10_1.databinding.FragmentFirstBinding


class FirstFragment : Fragment(R.layout.fragment_first) {
    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!
    private var isCheated: Boolean? = null
    private val myViewModel: MyViewModel by activityViewModels()

    /*arguments?.let {
    }*/
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setFragmentResultListener("cheated") { key, bundle ->
            isCheated = bundle.getBoolean("cheat")
            isCheated?.let { myViewModel.addToList(0, it) }
        }
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentFirstBinding.bind(view)
        myViewModel.bList.observe(viewLifecycleOwner){
            isCheated=it[0]
            binding.tvCheat.text="your cheating is $isCheated"
        }

        binding.btnNext.setOnClickListener {
            findNavController().navigate(R.id.fFg_to_sFg)
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