package com.example.buttonclickaway.presenter.products

import CategoryResponse
import com.example.buttonclickaway.model.remote.data.ProductsList

interface ProductsMVP {


        interface ProductsPresenter {
            fun getProducts(products: ProductsList)
        }

        interface ProductsView {
            fun setResult(products: ProductsList)
            fun onLoad(isLoading: Boolean)
        }
}

