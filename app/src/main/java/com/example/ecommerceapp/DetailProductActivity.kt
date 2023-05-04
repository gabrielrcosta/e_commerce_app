package com.example.ecommerceapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ecommerceapp.databinding.ActivityDetailProductBinding
import com.squareup.picasso.Picasso
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailProductActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailProductBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailProductBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val idProduct = intent.getIntExtra("idProduct", 0)

        getProductDetails(idProduct)
        binding.backButton.setOnClickListener {
            finish()
        }
    }

    private fun getProductDetails(idProduct: Int) {
        Retrofit.getData().getProduct(idProduct).enqueue(object : Callback<CategoryDetails>{
            override fun onResponse(
                call: Call<CategoryDetails>,
                response: Response<CategoryDetails>
            ) {
                val data = response.body()
                binding.apply {
                    data?.let {
                        Picasso.get().load(it.image).into(imageProduct)
                        titleProduct.text = it.title
                        descriptionProduct.text = it.description
                    }
                }
            }
            override fun onFailure(call: Call<CategoryDetails>, t: Throwable) {}
        })
    }
}