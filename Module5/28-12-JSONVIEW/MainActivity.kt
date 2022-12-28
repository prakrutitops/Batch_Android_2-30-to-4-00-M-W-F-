package com.tops.jsonview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.tops.jsonview.databinding.ActivityMainBinding
import org.json.JSONArray
import org.json.JSONException


class MainActivity : AppCompatActivity()
{
    lateinit var list: MutableList<Model>
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        list = ArrayList()
        //request create
        var stringRequest = StringRequest(Request.Method.POST,MyURL.url,{response->
            try
            {
                        var jsonArray = JSONArray(response)
                        for(i in 0..jsonArray.length())
                        {
                            var jsonObject = jsonArray.getJSONObject(i)

                            var p_name = jsonObject.getString("product_name")
                            var p_price = jsonObject.getString("product_price")
                            var p_image = jsonObject.getString("product_image")



                            var m = Model()
                            m.p_name=p_name
                            m.p_price=p_price
                            m.p_image=p_image
                            list.add(m)

                        }




            }
            catch (e:JSONException)
            {

                e.printStackTrace()
            }

            var adapter1 = MyAdapter(applicationContext,list)
            binding.list.adapter=adapter1
        })
        {
                Toast.makeText(applicationContext,"No Internet",Toast.LENGTH_LONG).show()
        }
        //Call Request
        var queue: RequestQueue = Volley.newRequestQueue(this)
        queue.add(stringRequest)


    }
}