package com.example.sharedprefrenceex

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity()
{
    lateinit var edt1:EditText
    lateinit var edt2:EditText
    lateinit var btn1:Button
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edt1 = findViewById(R.id.edt1)
        edt2 = findViewById(R.id.edt2)
        btn1 = findViewById(R.id.btnlogin)
        sharedPreferences = getSharedPreferences("User_Session",Context.MODE_PRIVATE)

        if (sharedPreferences.getBoolean("User_Session", false) &&
            !sharedPreferences.getString("name", "")!!.isEmpty())
        {
            startActivity(Intent(this@MainActivity, MainActivity2::class.java))
            finish()
        }


        btn1.setOnClickListener {

                var name =edt1.text.toString()
                var pass = edt2.text.toString()

                var edit1 :SharedPreferences.Editor = sharedPreferences.edit()
                edit1.putBoolean("User_Session",true)
                edit1.putString("name",name)
                edit1.putString("pass",pass)
                edit1.commit()

                var i =Intent(this,MainActivity2::class.java)
                startActivity(i)



        }

    }
}