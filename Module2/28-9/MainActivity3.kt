package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.SearchView
import android.widget.Spinner
import com.example.myapplication.databinding.ActivityMain2Binding
import com.example.myapplication.databinding.ActivityMain3Binding

class MainActivity3 : AppCompatActivity() {
    lateinit var binding: ActivityMain3Binding
    lateinit var list:MutableList<String>
    lateinit var spin:Spinner
    var city = arrayOf("aaa","brerv","crew")
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityMain3Binding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        list = ArrayList()

        list.add("Android")
        list.add("Java")
        list.add("Php")
        list.add("ios")

        var adapter =ArrayAdapter(this,android.R.layout.simple_list_item_1,list)
        binding.list.adapter=adapter

        binding.search.setOnQueryTextListener(object:SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(p0: String?): Boolean {

                /*if(list.contains(p0))
                {
                    adapter.filter.filter(p0)
                }
*/
                return false
            }

            override fun onQueryTextChange(p0: String?): Boolean {

                adapter.filter.filter(p0)

                return false
            }
        })
      /*  var adapter2 =ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,city)
        binding.spin.adapter=adapter2*/

        binding.a1.threshold=2
        var adapter3 =ArrayAdapter(this,android.R.layout.select_dialog_item,city)
        binding.a1.setAdapter(adapter3)
    }


}