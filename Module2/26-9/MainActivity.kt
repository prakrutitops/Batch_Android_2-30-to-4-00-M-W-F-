package com.example.layoutsex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView

lateinit var linearLayout: LinearLayout
lateinit var txt:TextView

class MainActivity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
       // setContentView(R.layout.activity_main)
        linearLayout = LinearLayout(this)
        txt = TextView(this)

        var width =500
        var height=500

        txt.setText("Hello World")

        linearLayout.addView(txt,width,height)
        setContentView(linearLayout)

    }
}