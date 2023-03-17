package com.example.e_greetingsapp123.Activity

import android.app.DownloadManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.e_greetingsapp123.R
import com.example.e_greetingsapp123.databinding.ActivityFullScreenBinding
import com.example.e_greetingsapp123.databinding.ActivityLoginBinding
import com.squareup.picasso.Picasso

class FullScreenActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityFullScreenBinding

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityFullScreenBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        var i = intent
        var pos = i.getStringExtra("pos")

        Picasso.get().load(pos).into(binding.photo)

        binding.btn1.setOnClickListener {

            var manager: DownloadManager = getSystemService(DOWNLOAD_SERVICE) as DownloadManager
            var uri = Uri.parse(pos)
            var request: DownloadManager.Request = DownloadManager.Request(uri)
            request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED)
            manager.enqueue(request)
            Toast.makeText(applicationContext,"Downloading Start",Toast.LENGTH_LONG).show()
        }

    }
}