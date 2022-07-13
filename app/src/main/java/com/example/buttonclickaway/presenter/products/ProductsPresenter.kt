package com.example.buttonclickaway.presenter.products

import CategoryResponse
import com.example.buttonclickaway.model.remote.OperatinalCallBackPro
import com.example.buttonclickaway.model.remote.data.ProductsList
import com.example.buttonclickaway.model.remote.VolleyHandlerProducts
import com.example.buttonclickaway.model.remote.data.Category


class ProductsPresenter (private val volleyHandlerProducts: VolleyHandlerProducts,
                                  private val productsView: ProductsMVP.ProductsView) : ProductsMVP.ProductsPresenter {

    override fun getProducts(products: ProductsList){
        productsView.onLoad(true)
        val message = volleyHandlerProducts.getProducts(products,
            object :OperatinalCallBackPro{
                override fun onSuccess(products: ProductsList) {
                    productsView.onLoad(false)
                    productsView.setResult(products)
                }
                override fun onFailure(message: String) {
                    productsView.onLoad(false)
                    productsView.setResult(products)
                }
            })
    }
}