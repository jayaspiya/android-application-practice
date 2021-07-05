package com.example.androidapplicationpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.androidapplicationpractice.adapter.ViewPagerAdapter
import com.example.androidapplicationpractice.fragments.AreaFragment
import com.example.androidapplicationpractice.fragments.SumFragment
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class TabLayoutActivity : AppCompatActivity() {
    private lateinit var lstTitle: ArrayList<String>
    private lateinit var lstFragments: ArrayList<Fragment>
    private lateinit var viewPager: ViewPager2
    private lateinit var tabLayout: TabLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tab_layout)
        viewPager = findViewById(R.id.viewPager)
        tabLayout = findViewById(R.id.tabLayout)

        populateList()

        val adapter = ViewPagerAdapter(lstFragments, supportFragmentManager, lifecycle)
        viewPager.adapter = adapter
        TabLayoutMediator(tabLayout, viewPager){
            tab, position ->
            tab.text = lstTitle[position]
        }.attach()
    }
    private fun populateList(){
        lstTitle = ArrayList()
        lstTitle.add("Sum")
        lstTitle.add("Area of Circle")
        lstFragments = ArrayList<Fragment>()
        lstFragments.add(SumFragment())
        lstFragments.add(AreaFragment())
    }
}