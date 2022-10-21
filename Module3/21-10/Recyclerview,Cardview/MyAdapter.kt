package com.example.recyclerviewcardview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(var context: Context,var list: MutableList<Model>) : RecyclerView.Adapter<MyView>()
{


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyView
    {
        var data =LayoutInflater.from(context)
        var view = data.inflate(R.layout.design,parent,false)
        return MyView(view)
    }

    override fun onBindViewHolder(holder: MyView, position: Int)
    {
        holder.image.setImageResource(list.get(position).image)
        holder.text.setText(list.get(position).name)
    }

    override fun getItemCount(): Int
    {
        return list.size
    }


}
class MyView(itemview:View) :RecyclerView.ViewHolder(itemview)
{
        var image:ImageView =itemview.findViewById(R.id.img)
        var text:TextView =itemview.findViewById(R.id.text)
}