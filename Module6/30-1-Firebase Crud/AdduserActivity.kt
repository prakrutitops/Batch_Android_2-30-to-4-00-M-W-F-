package com.example.firebasecrud

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.firebasecrud.databinding.ActivityAdduserBinding
import com.example.firebasecrud.databinding.ActivityMainBinding
import com.google.firebase.database.FirebaseDatabase

class AdduserActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAdduserBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAdduserBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.btninsert.setOnClickListener {


            var name = binding.edt1.text.toString()
            var email = binding.edt2.text.toString()
            var pass = binding.edt3.text.toString()

            var map = HashMap<String,String>()
            map["Username"]=name
            map["Email"]=email
            map["Password"]=pass

            var db = FirebaseDatabase.getInstance().getReference()
                .child("lenovo")
                .push()
                .setValue(map)
                .addOnSuccessListener {
                    Toast.makeText(applicationContext, "Inserted", Toast.LENGTH_SHORT).show()
                    startActivity(Intent(applicationContext, MainActivity::class.java))
                }
                .addOnFailureListener()
                {
                    Toast.makeText(applicationContext, "Fail", Toast.LENGTH_SHORT).show()
                }





        }
    }
}