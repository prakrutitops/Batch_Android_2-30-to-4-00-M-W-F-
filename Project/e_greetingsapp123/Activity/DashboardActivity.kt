package com.example.e_greetingsapp123.Activity

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.e_greetingsapp123.Adapter.DashboardAdapter
import com.example.e_greetingsapp123.ApiClient
import com.example.e_greetingsapp123.Apiinterface
import com.example.e_greetingsapp123.LoginActivity
import com.example.e_greetingsapp123.Model.DashboardModel
import com.example.e_greetingsapp123.R
import com.example.e_greetingsapp123.databinding.ActivityDashboardBinding
import com.example.e_greetingsapp123.databinding.ActivityLoginBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DashboardActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDashboardBinding
    lateinit var sharedPreferences: SharedPreferences
    lateinit var recyclerView: RecyclerView
    lateinit var apiinterface: Apiinterface
    lateinit var list:MutableList<DashboardModel>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDashboardBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        sharedPreferences=getSharedPreferences("user_session", Context.MODE_PRIVATE)
        Toast.makeText(applicationContext,"Welcome : "+sharedPreferences.getString("mob",""),Toast.LENGTH_LONG).show()
        recyclerView = findViewById(R.id.recycler)
        list=ArrayList()
        var layoutManager:RecyclerView.LayoutManager= GridLayoutManager(this,2)
        recyclerView.layoutManager=layoutManager

        apiinterface = ApiClient.getapiclient()!!.create(Apiinterface::class.java)


        var dashboardata: Call<List<DashboardModel?>?>? = apiinterface.dashboard_view

        dashboardata!!.enqueue(object:Callback<List<DashboardModel?>?>
        {
            override fun onResponse(call: Call<List<DashboardModel?>?>, response: Response<List<DashboardModel?>?>)
            {
                    list = response.body() as MutableList<DashboardModel>

                    var adapter = DashboardAdapter(applicationContext,list)
                    recyclerView.adapter=adapter
            }

            override fun onFailure(call: Call<List<DashboardModel?>?>, t: Throwable)
            {
                Toast.makeText(applicationContext,"No Internet",Toast.LENGTH_LONG).show()
            }
        })






    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean
    {
        menuInflater.inflate(R.menu.option,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId)
        {
            R.id.logout->
            {
                sharedPreferences.edit().clear().commit()
                finish()
                startActivity(Intent(applicationContext,LoginActivity::class.java))
            }
        }

        return super.onOptionsItemSelected(item)
    }

    override fun onBackPressed() {
        finishAffinity()
    }
}