package com.tops.jsonview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import org.w3c.dom.Text

class MyAdapter(var context: Context,var list: MutableList<Model>) :BaseAdapter()
{
    override fun getCount(): Int
    {
        return  list.size
    }

    override fun getItem(p0: Int): Any
    {
        return  list.get(p0)
    }

    override fun getItemId(p0: Int): Long
    {
        return  p0.toLong()
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View
    {
        var layout:LayoutInflater = LayoutInflater.from(context)
        var view = layout.inflate(R.layout.design,p2,false)
        var txt1 :TextView = view.findViewById(R.id.txt1)
        var txt2:TextView = view.findViewById(R.id.txt2)
        var image:ImageView = view.findViewById(R.id.img)

        txt1.setText(list.get(p0).p_name)
        txt2.setText(list.get(p0).p_price)
        Picasso.get().load(list.get(p0).p_image).placeholder(R.mipmap.ic_launcher).into(image)
        return view
    }

}