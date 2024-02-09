package com.aditya.netclan.ui.parent_fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.aditya.netclan.adapters.view_pager_adapter.ViewPagerAdapter
import com.aditya.netclan.databinding.FragmentExploreBinding
import com.aditya.netclan.ui.child_fragments.explore_fragments.BusinessFragment
import com.aditya.netclan.ui.child_fragments.explore_fragments.MerchantFragment
import com.aditya.netclan.ui.child_fragments.explore_fragments.PersonalFragment
import java.util.ArrayList

class ExploreFragment : Fragment() {


    private var _binding: FragmentExploreBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentExploreBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val fragmentArrayList = ArrayList<Fragment>()

        fragmentArrayList.add(PersonalFragment())
        fragmentArrayList.add(BusinessFragment())
        fragmentArrayList.add(MerchantFragment())


        val adapter = ViewPagerAdapter(requireContext(), childFragmentManager, fragmentArrayList, 3, listOf("Personal", "Business", "Merchant"))

        binding.viewPager.adapter = adapter
        binding.tabs.setupWithViewPager(binding.viewPager)



        return root
    }
}