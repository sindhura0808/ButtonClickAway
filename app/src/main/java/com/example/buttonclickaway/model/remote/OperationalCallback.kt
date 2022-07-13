package com.learning.mvpregistrationapp.model.remote

interface OperationalCallback {
    fun onSuccess(message: String,status:Int)
    fun onFailure(message: String, status:Int)
}