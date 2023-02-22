package com.example.sensorex

import android.Manifest
import android.annotation.SuppressLint
import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothAdapter.ACTION_REQUEST_ENABLE
import android.content.Intent
import android.content.pm.PackageManager
import android.net.wifi.WifiManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.core.app.ActivityCompat

class BluetoothWifiEx : AppCompatActivity()
{
    lateinit var btn1:Button
    lateinit var btn2:Button
    lateinit var adapter:BluetoothAdapter
    lateinit var wifi:WifiManager

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bluetooth_wifi_ex)

        btn1 = findViewById(R.id.btn1)
        btn2 = findViewById(R.id.btn2)
        adapter = BluetoothAdapter.getDefaultAdapter()
        wifi= getSystemService(WIFI_SERVICE) as WifiManager
        btn1.setOnClickListener {

            if(!adapter.isEnabled)
            {
                var i = Intent(ACTION_REQUEST_ENABLE)
                if (ActivityCompat.checkSelfPermission(this, Manifest.permission.BLUETOOTH_CONNECT) != PackageManager.PERMISSION_GRANTED)
                {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.

                }
                startActivityForResult(i,1)
            }


            //wifi.setWifiEnabled(true)
        }
        btn2.setOnClickListener {

            adapter.disable()

            //wifi.setWifiEnabled(false)
        }

    }
}