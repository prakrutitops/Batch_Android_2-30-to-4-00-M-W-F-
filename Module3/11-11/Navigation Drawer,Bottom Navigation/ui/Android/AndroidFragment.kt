package com.example.gmailapp.ui.Android

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import com.example.gmailapp.R


class AndroidFragment : Fragment() {

        lateinit var listView: ListView
        lateinit var list: MutableList<String>

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?, ): View? {
        // Inflate the layout for this fragment
        var view= inflater.inflate(R.layout.fragment_android, container, false)

            listView = view.findViewById(R.id.list)
            list =ArrayList()

            list.add("Intent")
            list.add("Fragment")
            list.add("Ui Controls")
            list.add("JSON")

            var adapter =ArrayAdapter(requireActivity(),android.R.layout.simple_list_item_1,list)
            listView.adapter=adapter



        return view
    }


}