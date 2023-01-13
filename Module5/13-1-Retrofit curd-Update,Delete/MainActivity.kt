package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.ActivityAddBinding
import com.example.myapplication.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {


    lateinit var binding:ActivityMainBinding
    lateinit var apiinterface:Apiinterface
    lateinit var list:MutableList<Model>

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)


        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        var layoutManager:RecyclerView.LayoutManager = LinearLayoutManager(this)
        binding.recycler.layoutManager=layoutManager


        binding.f1.setOnClickListener {
            startActivity(Intent(this,AddActivity::class.java))
        }


        apiinterface = ApiClient.getapiclient().create(Apiinterface::class.java)

        var call: Call<List<Model>> = apiinterface.getdata()

        call.enqueue(object:Callback<List<Model>>
        {
            override fun onResponse(call: Call<List<Model>>, response: Response<List<Model>>) {


                list = response.body() as MutableList<Model>

                var adapter = MyAdapter(applicationContext,list)
                binding.recycler.adapter = adapter


            }

            override fun onFailure(call: Call<List<Model>>, t: Throwable) {

                Toast.makeText(applicationContext,"No Internet",Toast.LENGTH_LONG).show()

            }
        })



    }
}