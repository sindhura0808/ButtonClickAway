package com.example.buttonclickaway.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.buttonclickaway.databinding.ActivityRegistrationBinding
import com.example.buttonclickaway.model.remote.data.User
import com.learning.mvpregistrationapp.model.remote.VolleyHandler
import com.example.buttonclickaway.presenter.register.RegistrationMVP
import com.example.buttonclickaway.presenter.register.RegistrationPresenter

class RegistrationActivity : AppCompatActivity() , RegistrationMVP.RegistrationView{

    private lateinit var binding: ActivityRegistrationBinding
    private lateinit var presenter: RegistrationPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistrationBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnRegister.setOnClickListener {
            setUpRegistrationEvent()
        }
    }

    private fun setUpRegistrationEvent() {
        presenter = RegistrationPresenter(VolleyHandler(this) ,this)
                    binding . apply {
                    val name = edtName.text.toString()
                    val mobile = edtMobile.text.toString()
                    val email = edtEmail.text.toString()
                    val password = edtPassword.text.toString()
                    val user = User(name, mobile, email, password)
                    presenter.registerUser(user)
            }
    }
    override fun onLoad(isLoading: Boolean) {
        if (isLoading) {
            binding.circularProgressBar.visibility = View.VISIBLE
        } else {
            binding.circularProgressBar.visibility = View.GONE
        }
    }
    override fun setResult(message: String,status:Int)
    {
        if (status==0) {
            startActivity(Intent(this,LoginActivity::class.java))
        }
        else{
            startActivity(Intent(this,LoginActivity::class.java))
        }

    }

}