package com.example.buttonclickaway.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioButton
import android.widget.RadioGroup
import com.example.buttonclickaway.R
import com.example.buttonclickaway.databinding.ActivityMainBinding

class MainActivity  : AppCompatActivity(){

     private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnregister.setOnClickListener{
          startActivity(Intent(this,RegistrationActivity::class.java))
        }

        binding.btnlogin.setOnClickListener{
           // startActivity(Intent(this,LoginActivity::class.java))
            Intent(this, Project_Page::class.java)

        }

    }


}

