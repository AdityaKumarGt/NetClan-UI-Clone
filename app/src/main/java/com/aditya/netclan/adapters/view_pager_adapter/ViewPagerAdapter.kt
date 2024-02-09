package com.aditya.netclan.adapters.view_pager_adapter

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class ViewPagerAdapter(
    private val context: Context,
    fm: FragmentManager?,
    val list: ArrayList<Fragment>,
    val tabCount: Int,
    val tabTitles: List<String>
): FragmentPagerAdapter(fm!!){
    override fun getCount(): Int {
        return tabCount
    }

    override fun getItem(position: Int): Fragment {
        return list[position]
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return tabTitles[position]
    }

//    companion object{
//        val TAB_TITLES = arrayOf("Personal", "Business", "Merchant")
//    }

}