package com.example.buttonclickaway.model.remote

import CategoryResponse
import android.content.Context
import android.util.Log
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.VolleyError
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.buttonclickaway.model.remote.data.Category
import com.example.buttonclickaway.model.remote.data.ProductsList
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.learning.mvpregistrationapp.model.remote.Constants
import org.json.JSONObject

class VolleyHandlerProducts(private val context: Context) {

    fun getProducts(products: ProductsList, callback:OperatinalCallBackPro) {
        val url = Constants.BASE_URL + Constants.PRODUCTS_END_POINT
        val requestQueue: RequestQueue = Volley.newRequestQueue(context)
        var products: ProductsList
        val request = object : StringRequest(
            Request.Method.GET,
            url,
            Response.Listener {
                val gson = Gson()
                products = gson.fromJson(it.toString(), ProductsList::class.java)
                callback.onSuccess(products)
            }, { error ->
                Toast.makeText(context, error.printStackTrace().toString(), Toast.LENGTH_SHORT)
                    .show()
            }
        ){}
        requestQueue.add(request)
    }
}