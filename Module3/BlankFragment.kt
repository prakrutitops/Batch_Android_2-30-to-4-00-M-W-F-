package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView


class BlankFragment : Fragment() {

    lateinit var txt1:TextView

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?, ): View?
    {
        // Inflate the layout for this fragment

        var view = inflater.inflate(R.layout.fragment_blank, container, false)

            txt1 = view.findViewById(R.id.txt2)

        txt1.setOnClickListener {

              /*  var i =Intent(activity,MainActivity2::class.java)
                startActivity(i)*/

                var fragment2 = BlankFragment2()
                var fm = fragmentManager
                var ft = fm!!.beginTransaction()
                ft.replace(R.id.frmid,fragment2).commit()

        }

        return view
    }


}