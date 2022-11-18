package com.example.realmex

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Display.Mode
import android.widget.Toast
import com.example.realmex.databinding.ActivityMainBinding
import io.realm.Realm

class MainActivity : AppCompatActivity()
{
    lateinit var realm: Realm
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        realm = Realm.getInstance(Realm.getDefaultConfiguration())




        binding.btn11.setOnClickListener {


            var name = binding.edt1.text.toString()
            var pass = binding.edt2.text.toString()

            realm.beginTransaction()

            var m = realm.createObject(Model::class.java)
            m.name=name
            m.pass=pass

            Toast.makeText(applicationContext,"Inserted",Toast.LENGTH_LONG).show()
            realm.commitTransaction()



        }

        binding.btn22.setOnClickListener {

                startActivity(Intent(this,MainActivity2::class.java))

        }

    }
}