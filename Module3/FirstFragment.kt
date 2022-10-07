package com.example.fragmentexample

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast

class FirstFragment : Fragment() {

    lateinit var txt1:TextView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?, ): View?
    {
        // Inflate the layout for this fragment

        var view = inflater.inflate(R.layout.fragment_first, container, false)

        txt1 = view.findViewById(R.id.txt1)

        txt1.setOnClickListener {

            Toast.makeText(activity,"Success",Toast.LENGTH_LONG).show()
        }

        return view
    }


    }
