package com.tops.jsoncrudapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.tops.jsoncrudapp.databinding.ActivityMain2Binding
import com.tops.jsoncrudapp.databinding.ActivityMainBinding
import org.json.JSONArray
import org.json.JSONException

class MainActivity2 : AppCompatActivity()
{
    private lateinit var binding: ActivityMain2Binding
    lateinit var list:MutableList<Model>

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        list = ArrayList()

        var stringRequest =StringRequest(Request.Method.POST,MyAPI.VIEW,{response->try {

                var jsonArray = JSONArray(response)
                for(i in 0 until  jsonArray.length())
                {
                    var jsonobject = jsonArray.getJSONObject(i)
                    var name=jsonobject.getString("product_name")
                    var price=jsonobject.getString("product_price")
                    var des=jsonobject.getString("product_description")

                    var m = Model()
                    m.pname=name
                    m.pprice=price
                    m.pdes=des
                    list.add(m)
                }



        }
        catch (e:JSONException)
        {
            print(e)
        }

            var adapter = MyAdapter(applicationContext,list)
            binding.list.adapter=adapter
        })



        {
            Toast.makeText(applicationContext,"No Internet",Toast.LENGTH_LONG).show()
        }
        var queue: RequestQueue = Volley.newRequestQueue(this)
        queue.add(stringRequest)



    }
}