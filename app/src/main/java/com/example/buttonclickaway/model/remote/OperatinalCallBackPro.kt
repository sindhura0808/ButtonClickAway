package com.example.buttonclickaway.model.remote

import com.example.buttonclickaway.model.remote.data.ProductsList

interface OperatinalCallBackPro {

        fun onSuccess(productsList: ProductsList)
        fun onFailure(message: String)

}