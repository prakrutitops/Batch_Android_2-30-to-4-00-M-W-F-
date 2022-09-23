package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CheckBox
import android.widget.RadioButton
import android.widget.Toast

class MainActivity : AppCompatActivity()
{
    lateinit var chk1:CheckBox
    lateinit var chk2:CheckBox
    lateinit var chk3:CheckBox
    lateinit var rb1:RadioButton
    lateinit var rb2:RadioButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        chk1 = findViewById(R.id.chk1)
        chk2 = findViewById(R.id.chk2)
        chk3 = findViewById(R.id.chk3)
        rb1 = findViewById(R.id.rb1)
        rb2 = findViewById(R.id.rb2)

        chk1.setOnCheckedChangeListener { compoundButton, b ->

            Toast.makeText(applicationContext,"Android checked",Toast.LENGTH_LONG).show()
        }
        chk2.setOnCheckedChangeListener { compoundButton, b ->

            Toast.makeText(applicationContext,"Java checked",Toast.LENGTH_LONG).show()


        }
        chk3.setOnCheckedChangeListener { compoundButton, b ->

            Toast.makeText(applicationContext,"Php checked",Toast.LENGTH_LONG).show()

        }
        rb1.setOnCheckedChangeListener { compoundButton, b ->

            if(rb1.isChecked)
            {
                Toast.makeText(applicationContext,"Male",Toast.LENGTH_LONG).show()
            }


        }
        rb2.setOnCheckedChangeListener { compoundButton, b ->

            if(rb2.isChecked)
            {
                Toast.makeText(applicationContext,"Female",Toast.LENGTH_LONG).show()
            }

        }
    }
}