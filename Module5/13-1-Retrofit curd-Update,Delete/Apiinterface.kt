package com.example.myapplication

import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface Apiinterface
{

    @FormUrlEncoded
    @POST("mobileproductinsert.php")
    fun insertdata
                (
                    @Field("p_name") product_name:String,
                    @Field("p_price")  product_price:String,
                    @Field("p_des")  product_description:String,
                ): Call<Void>


    @GET("mobileview.php")
    fun getdata():Call<List<Model>>

    @FormUrlEncoded
    @POST("mobiledelete.php")
    fun deletedata(@Field("id") id: Int): Call<Void?>?

    @FormUrlEncoded
    @POST("mobileupdate.php")
    fun updatedata
                (
        @Field("id") id:Int,
        @Field("p_name") product_name:String,
        @Field("p_price")  product_price:String,
        @Field("p_des")  product_description:String,
    ): Call<Void>


}