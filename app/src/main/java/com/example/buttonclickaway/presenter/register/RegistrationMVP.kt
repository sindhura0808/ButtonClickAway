package com.example.buttonclickaway.presenter.register

import com.example.buttonclickaway.model.remote.data.User

interface RegistrationMVP {

    interface RegistrationPresenter {
        fun registerUser(user: User): String
    }

    interface RegistrationView {
        fun setResult(message: String, status:Int)
        fun onLoad(isLoading: Boolean)
    }
}