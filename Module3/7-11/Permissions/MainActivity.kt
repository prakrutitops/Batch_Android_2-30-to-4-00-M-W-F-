package com.example.permissionexample

import android.Manifest.permission.CAMERA
import android.Manifest.permission.SEND_SMS
import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.PackageManager.PERMISSION_GRANTED
import android.graphics.Bitmap
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore.ACTION_IMAGE_CAPTURE
import android.telephony.SmsManager
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.annotation.RequiresApi

class MainActivity : AppCompatActivity()
{
    lateinit var btn1:Button
    lateinit var img1:ImageView
    lateinit var edt1:EditText
    lateinit var edt2:EditText
    lateinit var btn2:Button

    @SuppressLint("MissingInflatedId")
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn1 = findViewById(R.id.btn1)
        img1 = findViewById(R.id.img)
        edt1 = findViewById(R.id.edt1)
        edt2 = findViewById(R.id.edt2)
        btn2 = findViewById(R.id.btn2)

        if(checkSelfPermission(ACTION_IMAGE_CAPTURE)!=PERMISSION_GRANTED && checkSelfPermission(
                SEND_SMS)!= PERMISSION_GRANTED)
        {
            requestPermissions(arrayOf(CAMERA, SEND_SMS),101)
        }


        btn1.setOnClickListener {

                var i = Intent(ACTION_IMAGE_CAPTURE)
                startActivityForResult(i,1)

        }
        btn2.setOnClickListener {

            var num=edt1.text.toString()
            var msg =edt2.text.toString()

            var i  = Intent(this,MainActivity::class.java)
            var sms=SmsManager.getDefault()
            sms.sendTextMessage(num,null,msg,null,null)
            startActivity(i)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?)
    {
        super.onActivityResult(requestCode, resultCode, data)

        var bm:Bitmap = data!!.extras!!.get("data") as Bitmap
        img1.setImageBitmap(bm)
    }

}