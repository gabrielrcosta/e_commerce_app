package com.example.ecommerceapp

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiInterface {
    @GET("/products/categories")
    fun getCategory(): Call<List<String>>

    @GET("products/category/{category}")
    fun getDetails(@Path("category") category:String): Call<List<CategoryDetails>>

    @GET("/products/{numberProduct}")
    fun getProduct(@Path("numberProduct") numberProduct:Int): Call<CategoryDetails>
}