package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class BillActivity : AppCompatActivity() {

    lateinit var txt1:TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bill)

        var i =intent

        txt1 = findViewById(R.id.txt1)

        txt1.setText(i.getStringExtra("Bill"))

    }

  
}