package com.example.ecommerceapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ecommerceapp.databinding.ActivityProductListBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ProductListActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProductListBinding
    var BASE_URL = "https://fakestoreapi.com"
    lateinit var categories: List<CategoryProduct>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerView.adapter = CategoryAdapter(categoryList = categories, this)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        getData()
    }

    private fun getData() {
        var retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiInterface::class.java)

        var retroData = retrofit.getCategory()
        retroData.enqueue(object : Callback<List<CategoryProduct>> {
            override fun onResponse(
                call: Call<List<CategoryProduct>>,
                response: Response<List<CategoryProduct>>
            ) {
                var data = response.body()
                Log.d("data", data.toString())
            }

            override fun onFailure(call: Call<List<CategoryProduct>>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }
}
