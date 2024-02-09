package com.aditya.netclan.ui.parent_fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.aditya.netclan.adapters.view_pager_adapter.ViewPagerAdapter
import com.aditya.netclan.databinding.FragmentChatBinding
import com.aditya.netclan.ui.child_fragments.chat_fragments.CallsFragment
import com.aditya.netclan.ui.child_fragments.chat_fragments.ChatsFragment
import java.util.ArrayList

class ChatFragment : Fragment() {

    private var _binding: FragmentChatBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentChatBinding.inflate(inflater, container, false)
        val root: View = binding.root


        val fragmentArrayList = ArrayList<Fragment>()

        fragmentArrayList.add(ChatsFragment())
        fragmentArrayList.add(CallsFragment())


        val adapter = ViewPagerAdapter(requireContext(), childFragmentManager, fragmentArrayList, 2, listOf("Chats", "Calls"))

        binding.viewPager.adapter = adapter
        binding.tabs.setupWithViewPager(binding.viewPager)



        return root
    }
}