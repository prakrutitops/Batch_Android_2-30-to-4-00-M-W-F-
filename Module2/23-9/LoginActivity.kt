package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class LoginActivity : AppCompatActivity()
{
    lateinit var edt1:EditText
    lateinit var edt2:EditText
    lateinit var btn1:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        edt1=findViewById(R.id.edt1)
        edt2=findViewById(R.id.edt2)
        btn1=findViewById(R.id.btn1)

        btn1.setOnClickListener {

            var mobile = edt1.text.toString()
            var pass= edt2.text.toString()

            if(mobile.length==0 && pass.length==0)
            {
                edt1.setError("Please enter proper mobile number")
                edt2.setError("Please enter proper password")
            }
            else if(mobile.length==0)
            {
                edt1.setError("Please enter proper mobile number")
            }
            else if(pass.length==0)
            {
                edt2.setError("Please enter proper password")
            }
            else
            {
                if(mobile.equals("9999999999") && pass.equals("1234"))
                {
                    var i = Intent(this,DashboardActivity::class.java)
                    startActivity(i)
                }
                else
                {
                    Toast.makeText(applicationContext,"Error",Toast.LENGTH_LONG).show()
                }
            }
        }
    }

    override fun onBackPressed() {
        finishAffinity()
    }
}