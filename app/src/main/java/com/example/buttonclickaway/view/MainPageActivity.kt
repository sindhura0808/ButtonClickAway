package com.example.buttonclickaway.view

import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import com.example.buttonclickaway.R
import com.example.buttonclickaway.databinding.ActivityMainBinding
import com.example.buttonclickaway.databinding.ActivityMainPageBinding

class MainPageActivity: AppCompatActivity() {
    private lateinit var binding: ActivityMainPageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainPageBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViews()
        setHeaderLayoutOfNavDrawer()
    }

    private fun setHeaderLayoutOfNavDrawer() {
    val navigationViewHeader=binding.navView.inflateHeaderView(R.layout.nav_header)
        val textView=navigationViewHeader.findViewById<TextView>(R.id.txtName)
     textView.text="Custom header"
    }


    private fun initViews() {
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_baseline_menu_24)
        binding.navView.setNavigationItemSelectedListener { menuItems->
            menuItems.isChecked=true
            binding.drawerLayout.closeDrawers()
            when (menuItems.itemId){
                R.id.nav_profile-> {
                    showToast("profile")
                }
                R.id.nav_wallet-> {
                    showToast("wallet")
                }
                R.id.nav_offer-> {
                    showToast("offer")
                }
                R.id.nav_settings-> {
                    showToast("setting")
                }
                R.id.nav_logout-> {
                    showToast("logout")
                }

            }
            true
        }
    }

    private fun showToast(s:String)
    {
        Toast.makeText(this,s, Toast.LENGTH_SHORT).show()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId==android.R.id.home)
        {
            if(binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
                binding.drawerLayout.closeDrawer(GravityCompat.START)
            }
            else
            { binding.drawerLayout .openDrawer(GravityCompat.START)
            }
        }
        return super.onOptionsItemSelected(item)

    }
}