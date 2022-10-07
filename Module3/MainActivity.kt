package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.daimajia.slider.library.SliderTypes.BaseSliderView
import com.daimajia.slider.library.SliderTypes.TextSliderView


class MainActivity : AppCompatActivity()
{
    lateinit var btn1:Button

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn1 = findViewById(R.id.btn1)

        btn1.setOnClickListener {

            var fragment1 = BlankFragment()
            var fm = supportFragmentManager
            var ft = fm.beginTransaction()
            ft.replace(R.id.frmid,fragment1).commit()


        }

    }
}