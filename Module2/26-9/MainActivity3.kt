package com.example.layoutsex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView

class MainActivity3 : AppCompatActivity()
{
    lateinit var web:WebView

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        web =findViewById(R.id.web)
        web.loadUrl("https://www.javatpoint.com/")
    }
}