package com.example.e_greetingsapp123

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler


class MainActivity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Handler().postDelayed(Runnable {

                var i = Intent(applicationContext,LoginActivity::class.java)
                startActivity(i)

        },3000)

    }

    override fun onBackPressed() {
        finishAffinity()
    }
}