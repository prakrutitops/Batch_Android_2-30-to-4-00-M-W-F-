package com.example.tabexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity()
{
    lateinit var toolbar: Toolbar
    lateinit var tabLayout: TabLayout
    lateinit var viewPager: ViewPager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolbar = findViewById(R.id.tool)
        setSupportActionBar(toolbar)

        viewPager = findViewById(R.id.view1)
        myviewpager()

        tabLayout = findViewById(R.id.tab)
        tabLayout.setupWithViewPager(viewPager)
    }

    private fun myviewpager()
    {
        var myAdapter = MyAdapter(supportFragmentManager)
        myAdapter.adddata(ChatFragment(),"CHAT")
        myAdapter.adddata(StatusFragment(),"STATUS")
        myAdapter.adddata(CallFragment(),"CALL")
        viewPager.adapter=myAdapter
    }
}