package com.example.buttonclickaway.model.remote.data

import com.example.buttonclickaway.model.remote.data.Category

data class ProductsList(
    val categories: ArrayList<Category>,
    val message: String,
    val status: Int
)