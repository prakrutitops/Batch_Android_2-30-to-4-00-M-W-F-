package com.example.sensorex

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.widget.Toast

class MyService : Service() {

    override fun onStart(intent: Intent?, startId: Int) {
       Toast.makeText(applicationContext,"Started",Toast.LENGTH_LONG).show()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Toast.makeText(applicationContext,"Started Command",Toast.LENGTH_LONG).show()
        return super.onStartCommand(intent, flags, startId)
    }


  /*   override fun onBind(intent: Intent): IBinder?
     {


     }
   */

    override fun onDestroy() {
        Toast.makeText(applicationContext,"Destroy",Toast.LENGTH_LONG).show()
    }

    override fun onBind(intent: Intent?): IBinder? {

        TODO()
    }
}