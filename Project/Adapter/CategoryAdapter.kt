package com.example.e_greetingsapp123.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.e_greetingsapp123.Activity.CategoryActivity
import com.example.e_greetingsapp123.Activity.FullScreenActivity

import com.example.e_greetingsapp123.Model.Category_Model

import com.example.e_greetingsapp123.R
import com.squareup.picasso.Picasso

class CategoryAdapter(var context:Context,var list: MutableList<Category_Model>) :RecyclerView.Adapter<MyView2>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyView2
    {
        var layout = LayoutInflater.from(context)
       var view =  layout.inflate(R.layout.category_design,parent,false)

        return MyView2(view)
    }

    override fun getItemCount(): Int
    {
        return list.size
    }

    override fun onBindViewHolder(holder: MyView2, position: Int)
    {
       Picasso.get().load(list.get(position).image).into(holder.image)

        holder.itemView.setOnClickListener {

            var i = Intent(context, FullScreenActivity::class.java)
            i.putExtra("pos",list.get(position).image)
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            context.startActivity(i)

        }


    }

}
class MyView2(itemview: View) :RecyclerView.ViewHolder(itemview)
{


        var image:ImageView = itemview.findViewById(R.id.img_dashboard)





}