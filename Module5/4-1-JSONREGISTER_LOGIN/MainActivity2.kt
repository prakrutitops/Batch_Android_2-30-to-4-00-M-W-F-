package com.tops.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.AuthFailureError
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.tops.myapplication.databinding.ActivityMain2Binding


class MainActivity2 : AppCompatActivity() {
    private lateinit var binding: ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.btn1.setOnClickListener {


            var email = binding.edt1.text.toString()
            var pass = binding.edt2.text.toString()


            var stringRequest:StringRequest = object:StringRequest(Request.Method.POST,"https://vyasprakruti.000webhostapp.com/Greetings123/mylogin.php",Response.Listener {
                response->
                if(response.trim{ it <= ' ' } == "0")
                {
                    Toast.makeText(applicationContext, "Login Fail", Toast.LENGTH_LONG).show()

                }
                else
                {
                    Toast.makeText(applicationContext, "Login Done", Toast.LENGTH_LONG).show()


                }


            },Response.ErrorListener {

                Toast.makeText(applicationContext, "No Internet", Toast.LENGTH_LONG).show()
            })
            {
                override fun getParams(): MutableMap<String, String>?
                {

                    var map = HashMap<String,String>()

                    map["email"]=email
                    map["password"]=pass

                    return map
                }
            }
            var queue:RequestQueue = Volley.newRequestQueue(this)
            queue.add(stringRequest)
        }

    }
}





