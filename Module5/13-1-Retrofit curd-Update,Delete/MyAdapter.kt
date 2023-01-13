package com.example.myapplication

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MyAdapter(var context: Context,var list:MutableList<Model>) :RecyclerView.Adapter<MyView>()
{

    lateinit var apiinterface: Apiinterface

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyView {

        var layoutInflater:LayoutInflater = LayoutInflater.from(parent.context)
        var view = layoutInflater.inflate(R.layout.design,parent,false)
        return MyView(view)

    }

    override fun onBindViewHolder(holder: MyView, position: Int) {

        holder.txt1.setText(list.get(position).p_name)
        holder.txt2.setText(list.get(position).p_price)
        holder.txt3.setText(list.get(position).p_des)

        holder.itemView.setOnClickListener {

                var alert = AlertDialog.Builder(holder.itemView.context)
                alert.setTitle("Are you sure you want to delete?")
                alert.setPositiveButton("Update",{ dialogInterface: DialogInterface, i: Int ->


                        var i = Intent(context,UpdateActivity::class.java)
                        i.putExtra("id",list.get(position).id)
                        i.putExtra("name",list.get(position).p_name)
                        i.putExtra("price",list.get(position).p_price)
                        i.putExtra("des",list.get(position).p_des)
                        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                        context.startActivity(i)



                })
                alert.setNegativeButton("Delete",{ dialogInterface: DialogInterface, i: Int ->


                    apiinterface = ApiClient.getapiclient().create(Apiinterface::class.java)
                    var call: Call<Void?>? = apiinterface.deletedata(list.get(position).id)

                    call!!.enqueue(object:Callback<Void?>{
                        override fun onResponse(call: Call<Void?>, response: Response<Void?>) {

                                Toast.makeText(context,"Deleted",Toast.LENGTH_LONG).show()
                                var i = Intent(context,MainActivity::class.java)
                                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                                context.startActivity(i)

                        }

                        override fun onFailure(call: Call<Void?>, t: Throwable) {
                            Toast.makeText(context,"Error",Toast.LENGTH_LONG).show()
                        }

                    })








                })
                alert.show()
        }

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