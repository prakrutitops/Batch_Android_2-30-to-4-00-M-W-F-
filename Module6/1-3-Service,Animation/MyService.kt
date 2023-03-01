package com.example.serviceex

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import android.widget.Toast

class MyService : Service()
{

    override fun onCreate()
    {
        Toast.makeText(applicationContext,"Created",Toast.LENGTH_LONG).show()
        super.onCreate()
    }

    override fun onStart(intent: Intent?, startId: Int)
    {
        for(i in 1..10)
        {
            Thread.sleep(1000)
            Log.d("MYDATATOPS", i.toString())
        }
        Toast.makeText(applicationContext,"Start",Toast.LENGTH_LONG).show()
        super.onStart(intent, startId)
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int
    {
        Toast.makeText(applicationContext,"Start Command",Toast.LENGTH_LONG).show()
        return super.onStartCommand(intent, flags, startId)
    }
    override fun onBind(intent: Intent): IBinder
    {
        TODO()
    }

    override fun onDestroy()
    {
        Toast.makeText(applicationContext,"Destroy",Toast.LENGTH_LONG).show()
        super.onDestroy()
    }

}