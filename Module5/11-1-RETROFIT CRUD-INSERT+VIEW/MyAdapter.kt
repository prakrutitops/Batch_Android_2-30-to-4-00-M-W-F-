package com.example.myapplication

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(var context: Context,var list:MutableList<Model>) :RecyclerView.Adapter<MyView>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyView {

        var layoutInflater:LayoutInflater = LayoutInflater.from(context)
        var view = layoutInflater.inflate(R.layout.design,parent,false)
        return MyView(view)

    }

    override fun onBindViewHolder(holder: MyView, position: Int) {

        holder.txt1.setText(list.get(position).p_name)
        holder.txt2.setText(list.get(position).p_price)
        holder.txt3.setText(list.get(position).p_des)

    }

    override fun getItemCount(): Int {

        return  list.size

    }

}
class MyView(itemview: View) :RecyclerView.ViewHolder(itemview)
{
    lateinit var txt1:TextView
    lateinit var txt2:TextView
    lateinit  var txt3:TextView

    init {

        txt1 = itemview.findViewById(R.id.txt1)
        txt2 = itemview.findViewById(R.id.txt2)
        txt3 = itemview.findViewById(R.id.txt3)

    }


}