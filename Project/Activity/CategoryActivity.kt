package com.example.e_greetingsapp123.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.e_greetingsapp123.Adapter.CategoryAdapter
import com.example.e_greetingsapp123.ApiClient
import com.example.e_greetingsapp123.Apiinterface
import com.example.e_greetingsapp123.Model.Category_Model
import com.example.e_greetingsapp123.Model.DashboardModel
import com.example.e_greetingsapp123.R
import com.example.e_greetingsapp123.databinding.ActivityCategoryBinding
import com.example.e_greetingsapp123.databinding.ActivityLoginBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CategoryActivity : AppCompatActivity()
{

    lateinit var apiinterface: Apiinterface
    private lateinit var binding: ActivityCategoryBinding
    lateinit var list:MutableList<Category_Model>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCategoryBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        var i = intent
        var position = i.getIntExtra("pos",111)
        Toast.makeText(applicationContext,""+position,Toast.LENGTH_LONG).show()
        list = ArrayList()
        apiinterface = ApiClient.getapiclient()!!.create(Apiinterface::class.java)
        var layoutManager: RecyclerView.LayoutManager= GridLayoutManager(this,2)
        binding.recycler.layoutManager=layoutManager

        if(position==0)
        {
            var diwalidata: Call<List<Category_Model?>?>? =  apiinterface.diwali_view
            diwalidata!!.enqueue(object :Callback<List<Category_Model?>?>{
                override fun onResponse(call: Call<List<Category_Model?>?>, response: Response<List<Category_Model?>?>)
                {
                   list = response.body() as MutableList<Category_Model>


                    var adapter = CategoryAdapter(applicationContext,list)
                    binding.recycler.adapter=adapter
                }

                override fun onFailure(call: Call<List<Category_Model?>?>, t: Throwable) {
                   Toast.makeText(applicationContext,"No Internet",Toast.LENGTH_LONG).show()
                }
            })
        }
        if(position==1)
        {
            var diwalidata: Call<List<Category_Model?>?>? =  apiinterface.holi_view
            diwalidata!!.enqueue(object :Callback<List<Category_Model?>?>{
                override fun onResponse(call: Call<List<Category_Model?>?>, response: Response<List<Category_Model?>?>)
                {
                    list = response.body() as MutableList<Category_Model>


                    var adapter = CategoryAdapter(applicationContext,list)
                    binding.recycler.adapter=adapter
                }

                override fun onFailure(call: Call<List<Category_Model?>?>, t: Throwable) {
                    Toast.makeText(applicationContext,"No Internet",Toast.LENGTH_LONG).show()
                }
            })
        }
        if(position==2)
        {

        }
        if(position==3)
        {

        }

    }
}