package com.example.formexample

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
    }
    override fun onBackPressed() {

        var alertDialog= AlertDialog.Builder(this)
        alertDialog.setTitle("Are you sure you want to exit?")
        alertDialog.setPositiveButton("YES",{
                dialogInterface: DialogInterface, i: Int ->

            finishAffinity()

        })
        alertDialog.setNegativeButton("NO",{ dialogInterface: DialogInterface, i: Int ->

            dialogInterface.cancel()
        })

        alertDialog.show()

    }
}