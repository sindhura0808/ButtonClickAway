package com.example.buttonclickaway.presenter.register

import com.learning.mvpregistrationapp.model.remote.OperationalCallback
import com.example.buttonclickaway.model.remote.data.User
import com.learning.mvpregistrationapp.model.remote.VolleyHandler

class RegistrationPresenter(
    private val volleyHandler: VolleyHandler,
    private val registrationView: RegistrationMVP.RegistrationView
) : RegistrationMVP.RegistrationPresenter {

    override fun registerUser(user: User): String {
        registrationView.onLoad(true)
        val message = volleyHandler.registerUser(user,
            object : OperationalCallback {
                override fun onSuccess(message: String,status:Int) {
                    registrationView.onLoad(false)
                    registrationView.setResult(message,status)
                }

                override fun onFailure(message: String,status:Int) {
                    registrationView.onLoad(false)
                    registrationView.setResult(message,status)
                }
            })
        return message
    }
}