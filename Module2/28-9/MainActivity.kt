package com.example.myapplication

import android.Manifest.permission.CALL_PHONE
import android.Manifest.permission.CAMERA
import android.content.Intent
import android.content.pm.PackageManager.PERMISSION_GRANTED
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.annotation.RequiresApi
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity()
{
    lateinit var binding:ActivityMainBinding

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        if(checkSelfPermission(CALL_PHONE)!=PERMISSION_GRANTED)
        {
            requestPermissions(arrayOf(CALL_PHONE,CAMERA),101)
        }


        //1st way
       /* binding.txt1.setOnClickListener {

            Toast.makeText(applicationContext,"Success",Toast.LENGTH_LONG).show()
        }*/

        //2nd way
       /* binding.txt1.setOnClickListener(this)
        binding.txt2.setOnClickListener(this)*/
    }

  /*  override fun onClick(p0: View?)
    {

        if(p0==binding.txt1)
        {
            Toast.makeText(applicationContext,"Button 1",Toast.LENGTH_LONG).show()
        }
        if(p0==binding.txt2)
        {
            Toast.makeText(applicationContext,"Button 2",Toast.LENGTH_LONG).show()
        }

    }*/

    //3rd way
    fun t1(p0: View?)
    {
        Toast.makeText(applicationContext,"Button 1",Toast.LENGTH_LONG).show()
    }
    fun t2(p0: View?)
    {
            var num=binding.txt2.text.toString()
            var i = Intent(Intent.ACTION_CALL)
            i.setData(Uri.parse("tel:"+num))
            startActivity(i)

    }

}