package com.example.ecommerceapp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ecommerceapp.Constants.BASE_URL
import com.example.ecommerceapp.databinding.ActivityProductListBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ProductListActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProductListBinding
    val categories = mutableListOf<CategoryProduct>()
    private val adapterCategory by lazy {
        CategoryAdapter(categoryList = categories, this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getCategory()

        binding.recyclerView.adapter = adapterCategory
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
    }

    private fun getData(): ApiInterface {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiInterface::class.java)
    }

    private fun getCategory() {
        getData().getCategory().enqueue(object : Callback<List<String>> {
            @SuppressLint("NotifyDataSetChanged")
            override fun onResponse(
                call: Call<List<String>>,
                response: Response<List<String>>
            ) {
                val data = response.body()
                data?.let {
                    val category = it.mapIndexed { index, name ->
                        CategoryProduct(
                            name = name,
                            image = getImages()[index]
                        )
                    }
                    categories.addAll(category)
                    adapterCategory.notifyDataSetChanged()
                }
                Log.d("responseBody", data.toString())
            }

            override fun onFailure(call: Call<List<String>>, t: Throwable) {
                Toast.makeText(this@ProductListActivity, "Error", Toast.LENGTH_SHORT).show()
            }
        })
    }
}