package com.example.tabexample

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.fragment.app.Fragment

class ChatFragment :Fragment()
{
    lateinit var listView: ListView
    lateinit var list: MutableList<String>

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?, ): View?
    {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_chat, container, false)

            listView = view.findViewById(R.id.list)
            list = ArrayList()

            list.add("A")
            list.add("A")
            list.add("A")
            list.add("A")

            var arrayAdapter = ArrayAdapter(requireActivity(),android.R.layout.simple_list_item_1,list)
            listView.adapter=arrayAdapter



        return view
    }


}