package com.example.roomdbex.Activity

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.room.Room
import com.example.roomdbex.Database.DatabaseClass
import com.example.roomdbex.Entity.User
import com.example.roomdbex.R

class AdduserActivity : AppCompatActivity()
{
    lateinit var edt1:EditText
    lateinit var edt2:EditText
    lateinit var btn1:Button
    lateinit var db:DatabaseClass

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_adduser)

        edt1 = findViewById(R.id.edt1)
        edt2 = findViewById(R.id.edt2)
        btn1 = findViewById(R.id.btn1)

        db = Room.databaseBuilder(applicationContext,
            DatabaseClass::class.java, "myDatabase").allowMainThreadQueries().build()


        btn1.setOnClickListener {

            var name = edt1.text.toString()
            var pass = edt2.text.toString()

                var u =User()
                u.name=name
                u.pass=pass

                db.daoClass().addUser(u)

            Toast.makeText(applicationContext, "Successful", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this,MainActivity::class.java))

        }

    }
}