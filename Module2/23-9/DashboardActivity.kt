package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.Toast
import java.lang.StringBuilder

class DashboardActivity : AppCompatActivity()
{
    lateinit var chk1:CheckBox
    lateinit var chk2:CheckBox
    lateinit var chk3:CheckBox
    lateinit var btn1:Button

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        chk1=findViewById(R.id.chk1)
        chk2=findViewById(R.id.chk2)
        chk3=findViewById(R.id.chk3)
        btn1=findViewById(R.id.btnorder)


        btn1.setOnClickListener {

            var amount =0
            var builder =StringBuilder("\n Selected Items \n")
            builder.append("")

            if(chk1.isChecked)
            {
                builder.append("\n Pizza @ rs.100")
                amount+=100

            }
            if(chk2.isChecked)
            {
                builder.append("\n Burger @ rs.50")
                amount+=50
            }
            if(chk3.isChecked)
            {
                builder.append("\n Coffee @ rs.120")
                amount+=120
            }

            builder.append("\n Total :"+amount)

            //Toast.makeText(applicationContext,""+builder.toString(),Toast.LENGTH_LONG).show()
            var i =Intent(this,BillActivity::class.java)
            i.putExtra("Bill",builder.toString())
            startActivity(i)
        }

    }

    override fun onBackPressed() {
        finishAffinity()
    }
}