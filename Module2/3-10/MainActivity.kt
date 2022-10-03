package com.example.customtoastdialog

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.*
import android.webkit.WebView
import android.widget.AdapterView.AdapterContextMenuInfo
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.PopupMenu
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity(), PopupMenu.OnMenuItemClickListener {
        lateinit var btn1:Button
        lateinit var btn2:Button
        lateinit var listView: ListView
        lateinit var list: MutableList<String>
        lateinit var webView: WebView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn1 = findViewById(R.id.btn1)
        btn2 = findViewById(R.id.btn2)
        listView = findViewById(R.id.list)
        webView = findViewById(R.id.web)

        list = ArrayList()

        list.add("Android")
        list.add("Java")

        var adapter =ArrayAdapter(this,android.R.layout.simple_list_item_1,list)
        listView.adapter=adapter

        registerForContextMenu(listView)
        webView.getSettings().setJavaScriptEnabled(true)

        webView.loadUrl("file:///android_asset/index.html")

        btn1.setOnClickListener {

          /*  var t =Toast(applicationContext)
            var layout:LayoutInflater = LayoutInflater.from(applicationContext)
            var view = layout.inflate(R.layout.toast_design,null)
            t.view =view
            t.setGravity(Gravity.CENTER,0,0)
            t.duration=Toast.LENGTH_LONG
            t.show()*/

            var popup:PopupMenu =PopupMenu(applicationContext,btn1)
            menuInflater.inflate(R.menu.popup,popup.menu)
            popup.setOnMenuItemClickListener(this)

            popup.show()

        }
        btn2.setOnClickListener {

            var alert =AlertDialog.Builder(this)
            var layout:LayoutInflater = LayoutInflater.from(applicationContext)
            var view = layout.inflate(R.layout.toast_design,null)
            alert.setView(view)
            alert.show()

        }



    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean
    {
        menuInflater.inflate(R.menu.option,menu)

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean
    {
        when(item.itemId)
        {
            R.id.i1->
            {
               var num="9999999999"
               var i =Intent(Intent.ACTION_CALL)
               i.setData(Uri.parse("tel:"+num))
               startActivity(i)
            }
            R.id.i2->
            {

            }
        }

        return super.onOptionsItemSelected(item)
    }

    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?)
    {
        menuInflater.inflate(R.menu.context,menu)

        super.onCreateContextMenu(menu, v, menuInfo)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean
    {
        var acm:AdapterContextMenuInfo = item.menuInfo as AdapterContextMenuInfo
        var id =acm.position
        when(item.itemId)
        {
            R.id.pos->
            {
                Toast.makeText(applicationContext,"Position called  "+id,Toast.LENGTH_LONG).show()
            }
        }
        return super.onContextItemSelected(item)
    }

    override fun onMenuItemClick(p0: MenuItem?): Boolean
    {
        when(p0!!.itemId)
        {
            R.id.p1->
            {
                Toast.makeText(applicationContext,"aaa",Toast.LENGTH_LONG).show()
            }
        }
        return false
    }
}