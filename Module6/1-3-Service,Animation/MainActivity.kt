package com.example.serviceex

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity()
{
    lateinit var btn1:Button
    lateinit var btn2:Button
    lateinit var btn3:Button
    lateinit var img:ImageView
    lateinit var animationDrawable: AnimationDrawable
    lateinit var img2:ImageView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn1 = findViewById(R.id.btn1)
        btn2 = findViewById(R.id.btn2)
        btn3 = findViewById(R.id.btnStart)
        img = findViewById(R.id.imageView)
        animationDrawable = img.background as AnimationDrawable
        img2 = findViewById(R.id.img2)


        btn1.setOnClickListener {

            startService(Intent(applicationContext,MyService::class.java))
        }
        btn2.setOnClickListener {

            stopService(Intent(applicationContext,MyService::class.java))
        }
        btn3.setOnClickListener {

         /*   if(animationDrawable.isRunning()){
                animationDrawable.stop();
            }
            else{
                animationDrawable.start();
            }*/

            var anim= AnimationUtils.loadAnimation(applicationContext,R.anim.myanimation)
            img2.startAnimation(anim)



        }

    }
}