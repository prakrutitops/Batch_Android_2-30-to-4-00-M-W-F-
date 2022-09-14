package com.example.formexample

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity()
{
    lateinit var e1:EditText
    lateinit var e2:EditText
    lateinit var b1:Button

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        e1=findViewById(R.id.edt1)
        e2=findViewById(R.id.edt2)
        b1=findViewById(R.id.btn1)

        b1.setOnClickListener {

            var num =e1.text.toString()
            var pass=e2.text.toString()

            if(num.length==0 && pass.length==0)
            {
                e1.setError("Please Enter Name")
                e2.setError("Please Enter Password")
            }
            else if(num.length==0)
            {
                e1.setError("Please Enter Name")
            }
            else if(pass.length==0)
            {
                e2.setError("Please Enter Password")
            }
            else
            {

                if(num.equals("9724004242") && pass.equals("1234"))
                {
                    Toast.makeText(this,"Login Success",Toast.LENGTH_LONG).show()
                    var i =Intent(this,MainActivity2::class.java)
                    startActivity(i)
                }
                else
                {
                    Toast.makeText(this,"Login Fail",Toast.LENGTH_LONG).show()

                }
            }




        }

    }

    override fun onBackPressed() {


            finishAffinity()


    }
}