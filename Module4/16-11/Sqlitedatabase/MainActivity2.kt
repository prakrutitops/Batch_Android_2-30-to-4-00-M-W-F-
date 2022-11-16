package com.example.sqliteex

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView.AdapterContextMenuInfo
import android.widget.SimpleAdapter
import androidx.appcompat.app.AlertDialog
import com.example.sqliteex.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity()
{
    lateinit var binding: ActivityMain2Binding
    lateinit var list: MutableList<Model>
     var arrayList: ArrayList<HashMap<String,String>> = ArrayList()
    lateinit var dbHelper: DbHelper
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        dbHelper = DbHelper(applicationContext)


        list = dbHelper.viewdata()
        registerForContextMenu(binding.list)
        for(i in list)
        {
            var hm=HashMap<String,String>()

            hm["n1"]=i.name
            hm["p1"]=i.pass
            arrayList.add(hm)
        }

        var from= arrayOf("n1","p1")
        var to = intArrayOf(R.id.txt1,R.id.txt2)

        var adapter = SimpleAdapter(applicationContext,arrayList,R.layout.design,from,to)
        binding.list.adapter=adapter

    }

    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?)
    {

        var m1 = menu!!.add(0,1,0,"Update")
        var m2 =menu.add(0,2,0,"Delete")

        super.onCreateContextMenu(menu, v, menuInfo)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean
    {
        var acm:AdapterContextMenuInfo = item.menuInfo as AdapterContextMenuInfo
        var pos =acm.position
        var m = list[pos]


        when(item.itemId)
        {
            1->
            {

            }
            2->
            {
                var alertDialog= AlertDialog.Builder(this)
                alertDialog.setTitle("Are you sure you want to delete?")
                alertDialog.setPositiveButton("YES",{ dialogInterface: DialogInterface, i: Int ->

                    dbHelper.deletedata(m.id)
                    startActivity(Intent(this,MainActivity2::class.java))

                })
                alertDialog.setNegativeButton("NO",{ dialogInterface: DialogInterface, i: Int ->

                    dialogInterface.cancel()
                })
                alertDialog.show()
            }
        }



        return super.onContextItemSelected(item)
    }
}