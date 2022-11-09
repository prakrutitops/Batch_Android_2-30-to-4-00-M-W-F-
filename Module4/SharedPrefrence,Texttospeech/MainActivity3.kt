package com.example.sharedprefrenceex

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.speech.tts.TextToSpeech.QUEUE_ADD
import android.widget.EditText
import android.widget.ImageView
import java.util.*

class MainActivity3 : AppCompatActivity(), TextToSpeech.OnInitListener {
    lateinit var edt1:EditText
    lateinit var img1:ImageView
    lateinit var tts:TextToSpeech

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        edt1 = findViewById(R.id.edt1)
        img1 = findViewById(R.id.img)
        tts = TextToSpeech(applicationContext,this)
        img1.setOnClickListener {

                var data = edt1.text.toString()
                tts.speak(data,QUEUE_ADD,null)

        }

    }

    override fun onInit(p0: Int)
    {
        tts.setLanguage(Locale.US)
        tts.setSpeechRate(0.8F)
        tts.setPitch(0.8F)
    }
}