package com.example.buttonclickaway.presenter.login

import com.example.buttonclickaway.model.remote.data.UserLogin
import com.learning.mvpregistrationapp.model.remote.OperationalCallback

import com.learning.mvpregistrationapp.model.remote.VolleyHandlerLogin

class LoginPresenter (private val volleyHandlerlogin: VolleyHandlerLogin,
                      private val loginView: LoginMVP.LoginView
) : LoginMVP.LoginPresenter {

    override fun loginUser(user: UserLogin): String {
        loginView.onLoad(true)
        val message = volleyHandlerlogin.loginUser(user,
            object : OperationalCallback {
                override fun onSuccess(message: String,status:Int) {
                    loginView.onLoad(false)
                    loginView.setResult(message,status)
                }
                override fun onFailure(message: String,status:Int) {
                    loginView.onLoad(false)
                  loginView.setResult(message,status)
                }
            })
        return message
    }
}