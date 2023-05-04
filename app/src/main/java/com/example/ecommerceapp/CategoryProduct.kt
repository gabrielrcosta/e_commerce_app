package com.example.ecommerceapp

import com.example.ecommerceapp.Constants.ELECTRONIC_IMAGE
import com.example.ecommerceapp.Constants.JEWELLERY_IMAGE
import com.example.ecommerceapp.Constants.MENS_WEAR_IMAGE
import com.example.ecommerceapp.Constants.WOMENS_WEAR_IMAGE

data class CategoryProduct(
    val name: String,
    val image: String
)

fun getImages(): MutableList<String> {
    val newCategoryList = mutableListOf<String>()
    newCategoryList.add(ELECTRONIC_IMAGE)
    newCategoryList.add(JEWELLERY_IMAGE)
    newCategoryList.add(MENS_WEAR_IMAGE)
    newCategoryList.add(WOMENS_WEAR_IMAGE)
    return newCategoryList
}