package com.example.ecommerceapp

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Retrofit {
    fun getData(): ApiInterface {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(
                OkHttpClient.Builder().addInterceptor(HttpLoggingInterceptor().setLevel(
                    HttpLoggingInterceptor.Level.BODY))
                    .build()
            )
            .build()
            .create(ApiInterface::class.java)
    }
}