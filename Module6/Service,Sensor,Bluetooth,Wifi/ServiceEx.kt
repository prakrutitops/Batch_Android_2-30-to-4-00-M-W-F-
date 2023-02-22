package com.example.sensorex

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class ServiceEx : AppCompatActivity()
{
    lateinit var btn1:Button
    lateinit var btn2:Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_service_ex)

        btn1 = findViewById(R.id.btn1)
        btn2 = findViewById(R.id.btn2)

        btn1.setOnClickListener {

            var i = Intent(applicationContext,MyService::class.java)
            startService(i)

        }
        btn2.setOnClickListener {
            var i = Intent(applicationContext,MyService::class.java)
            stopService(i)
        }

    }
}