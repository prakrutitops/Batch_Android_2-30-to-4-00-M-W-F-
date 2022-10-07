package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.daimajia.slider.library.SliderLayout
import com.daimajia.slider.library.SliderTypes.TextSliderView

class MainActivity2 : AppCompatActivity() {

    lateinit var sliderLayout: SliderLayout
     var map = HashMap<String,Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        sliderLayout = findViewById(R.id.slider)

        map.put("A",R.drawable.m1)
        map.put("B",R.drawable.m2)
        map.put("C",R.drawable.m3)


        for(i in map.keys)
        {
            var txtslider =TextSliderView(this)
            txtslider.description(i)
            txtslider.image(map.get(i)!!)




            sliderLayout.setPresetTransformer(SliderLayout.Transformer.FlipPage)
            sliderLayout.addSlider(txtslider)
        }

    }
}