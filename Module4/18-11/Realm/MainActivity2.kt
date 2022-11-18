package com.example.realmex

import android.annotation.SuppressLint
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.AdapterView
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import com.example.realmex.databinding.ActivityMain2Binding
import io.realm.Realm

class MainActivity2 : AppCompatActivity(), AdapterView.OnItemLongClickListener {
    lateinit var binding: ActivityMain2Binding
    lateinit var list: MutableList<Model>
    lateinit var realm: Realm

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        list = ArrayList()
        realm = Realm.getInstance(Realm.getDefaultConfiguration())

        realm.beginTransaction()

        var realmResults  = realm.where(Model::class.java).findAll()

        for(i in realmResults.indices)
        {
            list.add(realmResults[i]!!)
        }
        var adapter = MyAdapter(applicationContext,list)
        binding.list2.adapter =adapter

        realm.commitTransaction()

        binding.list2.setOnItemLongClickListener(this)


    }

    @SuppressLint("MissingInflatedId")
    override fun onItemLongClick(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long): Boolean {

        var alertDialog = AlertDialog.Builder(this)
        alertDialog.setTitle("Select Operations?")
        alertDialog.setPositiveButton("Update", { dialogInterface: DialogInterface, i: Int ->

            var alertDialog2 = AlertDialog.Builder(this)
            var layout =LayoutInflater.from(this)
            var view =layout.inflate(R.layout.edit,null)


            var edt1:EditText = view.findViewById(R.id.edt1)
            var edt2:EditText = view.findViewById(R.id.edt2)
            var btn1:Button = view.findViewById(R.id.btn1)
            alertDialog2.setView(view)
            edt1.setText(list.get(p2).name)
            edt2.setText(list.get(p2).pass)

            btn1.setOnClickListener {



                    var name = edt1.text.toString()
                    var pass = edt2.text.toString()

                    realm.beginTransaction()

                        list.get(p2).name =name
                        list.get(p2).pass =pass




                realm.commitTransaction()
                startActivity(Intent(this,MainActivity2::class.java))



            }
            alertDialog2.show()

        })
        alertDialog.setNegativeButton("Delete", { dialogInterface: DialogInterface, i: Int ->

            realm.beginTransaction()
            var realmResults  = realm.where(Model::class.java).findAll()
            realmResults.deleteFromRealm(p2)
            realm.commitTransaction()
            startActivity(Intent(this,MainActivity2::class.java))


        })

        alertDialog.show()

        return  false
    }
}