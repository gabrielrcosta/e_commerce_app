package com.example.ecommerceapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ecommerceapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initUI()
    }

    private fun initUI() {
        binding.signIn.setOnClickListener{
            val intent = Intent(this@MainActivity, ProductListActivity::class.java)
            intent.putExtra("login", binding.loginText.toString())
            startActivity(intent)
        }

        binding.forgotPassword.setOnClickListener {
            val intent = Intent(this@MainActivity, ProductListActivity::class.java)
            startActivity(intent)
        }

        binding.signUp.setOnClickListener{
            val intent = Intent(this@MainActivity, ProductListActivity::class.java)
            startActivity(intent)
        }
    }
}
