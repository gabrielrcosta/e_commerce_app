package com.example.ecommerceapp

import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    @GET("/products/category")
    fun getCategory(): Call<List<CategoryProduct>>
}