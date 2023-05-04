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

        login()
        initUI()
    }

    private fun initUI() {
        binding.forgotPassword.setOnClickListener {
            val intent = Intent(this@MainActivity, ProductListActivity::class.java)
            startActivity(intent)
        }
        binding.signUp.setOnClickListener{
            val intent = Intent(this@MainActivity, ProductListActivity::class.java)
            startActivity(intent)
        }
    }

    private fun login() {
        binding.apply {
            signIn.setOnClickListener{
                emailValidation().forEach { email ->
                    if (!loginText.text.contains(email)) {
                        loginText.error = "Invalid email"
                        if (passwordText.text.isNullOrBlank()) {
                            passwordText.error = "Invalid password."
                        }
                    } else {
                        startActivity(Intent(this@MainActivity, ProductListActivity::class.java))
                    }
                }
            }
        }
    }
    private fun emailValidation(): MutableList<String> {
        val emailList = mutableListOf<String>()
        emailList.add("gabriel@gmail.com")
        return emailList
    }
}
