package com.dejina.timepicker.models

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class VIewPageAdapter (
    private val listFragments : ArrayList<Fragment>,
    fragmentManager: FragmentManager,
    lifecycle: Lifecycle
) : FragmentStateAdapter(fragmentManager, lifecycle) {


    override fun getItemCount(): Int {
        return listFragments.size
    }

    override fun createFragment(position: Int): Fragment {
        return listFragments[position]
    }

}