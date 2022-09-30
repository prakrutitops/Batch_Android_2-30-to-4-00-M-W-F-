package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.GridView
import android.widget.ListView

class MainActivity : AppCompatActivity()
{
    lateinit var listView: GridView
    lateinit var list: MutableList<Model>


    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listView = findViewById(R.id.list)
        list = ArrayList()

        list.add(Model(R.drawable.f1,"Pizza","Paneer Pizza","Rs.150"))
        list.add(Model(R.drawable.f2,"Burger","Tiki Burger","Rs.70"))
        list.add(Model(R.drawable.f3,"Coke","Coke","Rs.40"))

        var adapter =MyAdapter(applicationContext,list)
        listView.adapter=adapter



    }
}