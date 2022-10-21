package com.example.recyclerviewcardview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity()
{
    lateinit var recyclerView: RecyclerView
    lateinit var list: MutableList<Model>

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recycler)
        list = ArrayList()

        var manager : RecyclerView.LayoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager=manager

        list.add(Model(R.drawable.icon,"Abcd"))
        list.add(Model(R.drawable.icon,"Pqrs"))
        list.add(Model(R.drawable.icon,"Xyz"))
        list.add(Model(R.drawable.icon,"Efgh"))

        var adapter =MyAdapter(applicationContext,list)
        recyclerView.adapter=adapter

    }
}