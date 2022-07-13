package com.example.buttonclickaway.presenter.login

import com.example.buttonclickaway.model.remote.data.UserLogin

interface LoginMVP {

    interface LoginPresenter {
        fun loginUser(user: UserLogin): String
    }

    interface LoginView {
        fun setResult(message: String,status:Int)
        fun onLoad(isLoading: Boolean)
    }
}