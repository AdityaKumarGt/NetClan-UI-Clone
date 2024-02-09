package com.aditya.netclan.ui.parent_fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.aditya.netclan.adapters.view_pager_adapter.ViewPagerAdapter
import com.aditya.netclan.databinding.FragmentContactsBinding
import com.aditya.netclan.ui.child_fragments.contacts_fragments.ContactBusinessFragment
import com.aditya.netclan.ui.child_fragments.contacts_fragments.ContactMerchantFragment
import com.aditya.netclan.ui.child_fragments.contacts_fragments.ContactPersonalFragment
import java.util.ArrayList

class ContactsFragment : Fragment() {
    private var _binding: FragmentContactsBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentContactsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val fragmentArrayList = ArrayList<Fragment>()

        fragmentArrayList.add(ContactPersonalFragment())
        fragmentArrayList.add(ContactBusinessFragment())
        fragmentArrayList.add(ContactMerchantFragment())


        val adapter = ViewPagerAdapter(requireContext(), childFragmentManager, fragmentArrayList, 3, listOf("Personal", "Business", "Merchant"))

        binding.viewPager.adapter = adapter
        binding.tabs.setupWithViewPager(binding.viewPager)

        return root
    }

}