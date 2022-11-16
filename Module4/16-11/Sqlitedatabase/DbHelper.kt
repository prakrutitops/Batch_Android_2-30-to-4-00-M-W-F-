package com.example.sqliteex

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.view.Display.Mode

class DbHelper(context: Context?) : SQLiteOpenHelper(context, DB_NAME,null, DB_VERSION)
{


    companion object
    {
        var DB_NAME="user.db"
        var TABLE_NAME="info"
        var ID="id"
        var NAME="name"
        var PASS="pass"
        var DB_VERSION=1
    }

    override fun onCreate(p0: SQLiteDatabase?)
    {
        var query="CREATE TABLE " + TABLE_NAME + "("+ ID + " INTEGER PRIMARY KEY," + NAME + " TEXT,"+ PASS + " TEXT" + ")"
        p0!!.execSQL(query)
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int)
    {
        var upquery="drop table if exists "+ TABLE_NAME
        p0!!.execSQL(upquery)
        onCreate(p0)
    }

    fun insertdata(m:Model) :Long
    {
        var db:SQLiteDatabase = this.writableDatabase
        var values = ContentValues()
        values.put(NAME,m.name)
        values.put(PASS,m.pass)
        var id =db.insert(TABLE_NAME,ID,values)
        return id
    }

    fun viewdata():MutableList<Model>
    {
        var list :MutableList<Model> = ArrayList()
        var db:SQLiteDatabase = this.readableDatabase
        var data = arrayOf(ID,NAME, PASS)
        var cursor:Cursor=db.query(TABLE_NAME,data,null,null,null,null,null)
        while (cursor.moveToNext())
        {
            var id =cursor.getInt(0)
            var name=cursor.getString(1)
            var pass = cursor.getString(2)

            var m = Model()
            m.id=id
            m.name= name
            m.pass=pass

            list.add(m)
        }


        return list
    }
    fun deletedata(id:Int)
    {
        var db:SQLiteDatabase = this.writableDatabase
        var deletequery = ID+" = "+id
        db.delete(TABLE_NAME,deletequery,null)
    }

}