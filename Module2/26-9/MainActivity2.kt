package com.example.layoutsex

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainActivity2 : AppCompatActivity(), View.OnClickListener,
    RatingBar.OnRatingBarChangeListener, SeekBar.OnSeekBarChangeListener {
    lateinit var pb:ProgressBar
    lateinit var btn1:Button
    lateinit var btn2:Button
    lateinit var rating:RatingBar
    lateinit var seek1:SeekBar
    lateinit var seek2:SeekBar
    lateinit var seek3:SeekBar
    lateinit var img:ImageView

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        pb =  findViewById(R.id.pb)
        btn1 = findViewById(R.id.btn1)
        btn2 = findViewById(R.id.btn2)
        rating=findViewById(R.id.rate)
        seek1=findViewById(R.id.seek1)
        seek2=findViewById(R.id.seek2)
        seek3=findViewById(R.id.seek3)
        img=findViewById(R.id.img)
        btn1.setOnClickListener(this)
        btn2.setOnClickListener(this)
        rating.setOnRatingBarChangeListener(this)
        seek1.setOnSeekBarChangeListener(this)
        seek2.setOnSeekBarChangeListener(this)
        seek3.setOnSeekBarChangeListener(this)

    }

    override fun onClick(p0: View?)
    {

        if(p0==btn1)
        {
            pb.incrementProgressBy(1)
            setProgress(100*pb.progress)
        }
        if(p0==btn2)
        {
            pb.incrementProgressBy(-1)
            setProgress(100*pb.progress)
        }
    }

    override fun onRatingChanged(p0: RatingBar?, p1: Float, p2: Boolean)
    {
        Toast.makeText(applicationContext,""+rating.rating,Toast.LENGTH_LONG).show()
    }

    override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {

        var r =seek1.progress
        var g =seek2.progress
        var b =seek3.progress

        img.setBackgroundColor(Color.rgb(r,g,b))

    }

    override fun onStartTrackingTouch(p0: SeekBar?) {

    }

    override fun onStopTrackingTouch(p0: SeekBar?) {

    }
}