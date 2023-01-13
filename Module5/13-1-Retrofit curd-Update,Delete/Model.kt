package com.example.myapplication

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Model
{
    @Expose
    @SerializedName("id")
    var id=0

    @Expose
    @SerializedName("p_name")
    var p_name=""

    @Expose
    @SerializedName("p_price")
    var p_price=""

    @Expose
    @SerializedName("p_des")
    var p_des=""

}