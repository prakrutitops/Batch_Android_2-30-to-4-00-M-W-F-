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
import com.example.e_greetingsapp123.Model.DashboardModel
import com.example.e_greetingsapp123.R
import com.squareup.picasso.Picasso

class DashboardAdapter(var context:Context,var list: MutableList<DashboardModel>) :RecyclerView.Adapter<MyView>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyView
    {
        var layout = LayoutInflater.from(context)
       var view =  layout.inflate(R.layout.design_dashboard,parent,false)

        return MyView(view)
    }

    override fun getItemCount(): Int
    {
        return list.size
    }

    override fun onBindViewHolder(holder: MyView, position: Int)
    {
       Picasso.get().load(list.get(position).c_image).into(holder.image)
       holder.txt.setText(list.get(position).c_name)

      holder.itemView.setOnClickListener {

            var i = Intent(context,CategoryActivity::class.java)
            i.putExtra("pos",position)
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            context.startActivity(i)


      }
    }

}
class MyView(itemview: View) :RecyclerView.ViewHolder(itemview)
{


        var image:ImageView = itemview.findViewById(R.id.img_dashboard)
        var txt:TextView = itemview.findViewById(R.id.txt_dashbaord)




}