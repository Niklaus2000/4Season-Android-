package com.example.a4season

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.a4season.adapter.LoginAdapter
import com.example.a4season.databinding.ActivityLoginandregisterBinding
import com.google.android.material.tabs.TabLayoutMediator

class Loginandregister : AppCompatActivity() {
    private lateinit var binding: ActivityLoginandregisterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginandregisterBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

//        val viewpager = findViewById<ViewPager2>(R.id.view_pager)
//        val tablayout = findViewById<TabLayout>(R.id.tab_layout)


        val adapter = LoginAdapter(supportFragmentManager, lifecycle)
        binding.viewPager.adapter = adapter

        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            when (position) {
                0 -> {
                    tab.text = "First"
                }
                1 -> {
                    tab.text = "Second"
                }
            }
        }.attach()
    }
}


