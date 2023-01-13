package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.databinding.ActivityUpdateBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UpdateActivity : AppCompatActivity()
{
    lateinit var binding: ActivityUpdateBinding
    lateinit var apiinterface:Apiinterface
     var id=0
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityUpdateBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        var i =intent
         id = i.getIntExtra("id",111)
        binding.edt1.setText(i.getStringExtra("name"))
        binding.edt2.setText(i.getStringExtra("price"))
        binding.edt3.setText(i.getStringExtra("des"))



        binding.btn1.setOnClickListener {

            var pname = binding.edt1.text.toString()
            var pprice = binding.edt2.text.toString()
            var pdes = binding.edt3.text.toString()

            //client and interface commnunication
            apiinterface = ApiClient.getapiclient().create(Apiinterface::class.java)

            var call: Call<Void> = apiinterface.updatedata(id,pname,pprice,pdes)
            call.enqueue(object: Callback<Void>
            {
                override fun onResponse(call: Call<Void>, response: Response<Void>)
                {
                    Toast.makeText(applicationContext,"Updated", Toast.LENGTH_LONG).show()
                    startActivity(Intent(applicationContext,MainActivity::class.java))
                }

                override fun onFailure(call: Call<Void>, t: Throwable)
                {
                    Toast.makeText(applicationContext,"Fail", Toast.LENGTH_LONG).show()
                }
            })


        }

    }
}