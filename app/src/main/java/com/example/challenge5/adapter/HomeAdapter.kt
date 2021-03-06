package com.example.challenge5.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class homeAdapter(fa: FragmentActivity): FragmentStateAdapter(fa) {
    private val data = mutableListOf<Fragment>()

    fun setData(data: MutableList<Fragment>){
        this.data.clear()
        this.data.addAll(data)

    }
    override fun getItemCount(): Int =data.size
    override fun createFragment(position: Int): Fragment = data[position]

}