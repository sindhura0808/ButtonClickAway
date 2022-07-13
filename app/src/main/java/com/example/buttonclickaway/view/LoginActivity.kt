package com.example.buttonclickaway.view

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKeys
import com.example.buttonclickaway.databinding.ActivityLoginBinding
import com.example.buttonclickaway.model.remote.data.UserLogin
import com.learning.mvpregistrationapp.model.remote.VolleyHandlerLogin
import com.example.buttonclickaway.presenter.login.LoginMVP
import com.example.buttonclickaway.presenter.login.LoginPresenter

class LoginActivity : AppCompatActivity(), LoginMVP.LoginView {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var presenter: LoginPresenter
    private lateinit var encryptedSharedPreferences: SharedPreferences
    private lateinit var editor: SharedPreferences.Editor
    private lateinit var email:String
    private lateinit var password:String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnLogin.setOnClickListener {
            setUpLoginEvents()
        }
    }

    private fun setUpLoginEvents() {
        presenter = LoginPresenter(VolleyHandlerLogin(this), this)
        binding.apply {
             email = edtEmail.text.toString()
             password = edtPassword.text.toString()
            val user = UserLogin(email, password)
            createSecuredPref()
            presenter.loginUser(user)
        }
    }
    override fun onLoad(isLoading: Boolean) {
        if (isLoading) {
            binding.circularProgressBar.visibility = View.VISIBLE
        } else {
            binding.circularProgressBar.visibility = View.GONE
        }
    }
    override fun setResult(message: String, status: Int) {
        if (status == 0) {
            Toast.makeText(this, "login Successfull001 status= ${status}", Toast.LENGTH_SHORT).show()
            var intent=Intent(this, MainPageActivity::class.java)
            intent.putExtra("email", email)
            intent.putExtra("password",password)
            startActivity(intent)
        } else {
            startActivity(Intent(this, LoginActivity::class.java))
        }

    }
    private fun createSecuredPref() {
        val keyGenParameterSpec = MasterKeys.AES256_GCM_SPEC
        val mainKeyAlias = MasterKeys.getOrCreate(keyGenParameterSpec)

        encryptedSharedPreferences = EncryptedSharedPreferences.create(

            PREF_FILE_NAME,
            mainKeyAlias,
            this,
            EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
            EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
        )
        editor = encryptedSharedPreferences.edit()
    }

    companion object {
        const val PREF_FILE_NAME = "login_details"

    }

}