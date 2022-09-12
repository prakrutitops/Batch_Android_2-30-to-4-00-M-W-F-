package com.example.myapplication2

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity()
{
    lateinit var img1 :ImageView
    lateinit var txt1:TextView

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        img1 = findViewById(R.id.img)
        txt1 = findViewById(R.id.txt)

        img1.setOnClickListener {

            Toast.makeText(this,"Welcome to India",Toast.LENGTH_LONG).show()
            //Explcit
            var i2 = Intent(this,MainActivity2::class.java)
            startActivity(i2)
        }

        txt1.setOnClickListener {

            //Implicit
            var url="https://www.india.gov.in/"
            var i =Intent(Intent.ACTION_VIEW)
            i.setData(Uri.parse(url))
            startActivity(i)

        }



    }
}