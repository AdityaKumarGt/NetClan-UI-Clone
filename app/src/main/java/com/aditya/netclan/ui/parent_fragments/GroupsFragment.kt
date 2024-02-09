package com.aditya.netclan.ui.parent_fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.aditya.netclan.adapters.view_pager_adapter.ViewPagerAdapter
import com.aditya.netclan.databinding.FragmentGroupsBinding
import com.aditya.netclan.ui.child_fragments.groups_fragments.AllGroupFragment
import com.aditya.netclan.ui.child_fragments.groups_fragments.EventsFragment
import com.aditya.netclan.ui.child_fragments.groups_fragments.MyGroupsFragment
import java.util.ArrayList


class GroupsFragment : Fragment() {
    private var _binding: FragmentGroupsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentGroupsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val fragmentArrayList = ArrayList<Fragment>()

        fragmentArrayList.add(AllGroupFragment())
        fragmentArrayList.add(MyGroupsFragment())
        fragmentArrayList.add(EventsFragment())


        val adapter = ViewPagerAdapter(requireContext(), childFragmentManager, fragmentArrayList, 3, listOf("All", "My Groups", "Events"))

        binding.viewPager.adapter = adapter
        binding.tabs.setupWithViewPager(binding.viewPager)






        return root
    }



}