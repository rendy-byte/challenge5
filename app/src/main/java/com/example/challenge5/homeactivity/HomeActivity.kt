package com.example.challenge5.homeactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.example.challenge5.R
import com.example.challenge5.adapter.homeAdapter
import com.example.challenge5.fragment.pageDuaFragment
import com.example.challenge5.fragment.pageSatuFragment
import com.example.challenge5.fragment.pageTigaFragment
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator

class homeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val dataFragment = mutableListOf(pageSatuFragment(), pageDuaFragment(), pageTigaFragment())
        val adapter = homeAdapter(this)
        adapter.setData(dataFragment)

        val viewPager= findViewById<ViewPager2>(R.id.viewpager2)
        val dotsIndicator = findViewById<DotsIndicator>(R.id.dots_indicator)
        viewPager.adapter=adapter
        dotsIndicator.setViewPager2(viewPager)

        viewPager.currentItem=0
    }

}