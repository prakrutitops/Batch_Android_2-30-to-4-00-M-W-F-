package com.example.roomdbex.Activity

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.example.roomdbex.Adapter.UserAdapter
import com.example.roomdbex.Database.DatabaseClass
import com.example.roomdbex.Entity.User
import com.example.roomdbex.R
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity()
{
    lateinit var floatingActionButton: FloatingActionButton
    lateinit var recyclerView: RecyclerView
    lateinit var list: MutableList<User>
    var db: DatabaseClass? = null
    var mAdapter: UserAdapter? = null

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recycler)
        list = ArrayList()

        var l1:RecyclerView.LayoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager=l1

        db = Room.databaseBuilder(applicationContext,
            DatabaseClass::class.java, "myDatabase").allowMainThreadQueries().build()

        getalldata()

        floatingActionButton = findViewById(R.id.fab)
        floatingActionButton.setOnClickListener {

                startActivity(Intent(this,AdduserActivity::class.java))

        }

    }

    private fun getalldata()
    {
        list = db!!.daoClass().getUsers()
        if (list.size > 0)
        {
            mAdapter =  UserAdapter(list)
            recyclerView.setAdapter(mAdapter)

        }
        else
        {
            Toast.makeText(this, "No data ", Toast.LENGTH_SHORT).show();
        }
    }
}