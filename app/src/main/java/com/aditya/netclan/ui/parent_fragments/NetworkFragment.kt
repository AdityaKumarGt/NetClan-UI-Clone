package com.aditya.netclan.ui.parent_fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aditya.netclan.R
import com.aditya.netclan.databinding.FragmentExploreBinding
import com.aditya.netclan.databinding.FragmentNetworkBinding


class NetworkFragment : Fragment() {

    private var _binding: FragmentNetworkBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentNetworkBinding.inflate(inflater, container, false)
        val root: View = binding.root




        return root
    }


}