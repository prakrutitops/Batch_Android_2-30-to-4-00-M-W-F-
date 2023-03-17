package com.example.e_greetingsapp123


import com.example.e_greetingsapp123.Model.Category_Model
import com.example.e_greetingsapp123.Model.DashboardModel
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface Apiinterface
{
    @FormUrlEncoded
    @POST("signup.php")
    fun registerdetail
    (
        @Field("firstname") firstname: String?,
        @Field("lastname") lastname: String?,
        @Field("phone") mobile: String?,
        @Field("email") email: String?,
        @Field("password") password: String?,

        ): Call<Void>

    @FormUrlEncoded
    @POST("login.php")
    fun logindata(
        @Field("phone") mobile: String?,
        @Field("pass") password: String?
        ):Call<RegisterModel>

    @get:GET("dashboard.php")
    val dashboard_view: Call<List<DashboardModel?>?>?

    @get:GET("diwali.php")
    val diwali_view: Call<List<Category_Model?>?>?

    @get:GET("holi.php")
    val holi_view: Call<List<Category_Model?>?>?



}