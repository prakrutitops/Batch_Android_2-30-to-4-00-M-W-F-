package com.example.roomdbex.Adapter

import com.example.roomdbex.Database.DatabaseClass
import com.example.roomdbex.Entity.User
import com.example.roomdbex.R




import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room



class UserAdapter(userList: MutableList<User>) : RecyclerView.Adapter<UserHolder?>()
{
    var userList: MutableList<User>
    var db: DatabaseClass? = null
    private var mContext: Context? = null

    init
    {
        this.userList = userList
    }

    @NonNull
    override fun onCreateViewHolder(@NonNull parent: ViewGroup, i: Int): UserHolder {
        mContext = parent.getContext()
        db = Room.databaseBuilder(parent.getContext(),
            DatabaseClass::class.java, "myDatabase").allowMainThreadQueries().build()
        val v: View = LayoutInflater.from(parent.getContext())
            .inflate(R.layout.user_adapter, parent, false)
        return UserHolder(v)
    }

    override fun onBindViewHolder(@NonNull userHolder: UserHolder, position: Int) {
        userHolder.name.setText(userList[position].name.toString())
        userHolder.pass.setText(userList[position].pass.toString())


        



    }
    override fun getItemCount(): Int
    {
        return userList.size
    }

}
class UserHolder(@NonNull itemView: View) : RecyclerView.ViewHolder(itemView)
{
    val name: TextView
    val pass: TextView

    init
    {
        name = itemView.findViewById<TextView>(R.id.name)
        pass = itemView.findViewById<TextView>(R.id.pass)
    }
}