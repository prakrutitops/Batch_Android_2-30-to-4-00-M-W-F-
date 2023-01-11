package com.example.myapplication

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient
{
    var BASE_URL="https://vyasprakruti.000webhostapp.com/30Nov/"

    var retrofit:Retrofit?=null

    fun getapiclient():Retrofit
    {
        if(retrofit==null)
        {
            retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        }



        return retrofit!!

    }

}