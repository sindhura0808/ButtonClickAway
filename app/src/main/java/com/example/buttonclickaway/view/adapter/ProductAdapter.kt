package com.example.buttonclickaway.view.adapter


import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.buttonclickaway.databinding.ProductsListBinding
import com.example.buttonclickaway.model.remote.data.Category

class ProductAdapter(private val context: Context, private val category: ArrayList<Category>) :
    RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    private lateinit var binding: ProductsListBinding

    /*
    This method need to override to define the size of recyclerview
    */
    override fun getItemCount() = category.size

    /*
    This method will call only once when you create the adapter for recyclerview.
    Responsibility of this method is to create new views.
    */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        binding = ProductsListBinding.inflate(layoutInflater, parent, false)
        return ProductViewHolder(binding.root)
    }

    /*
    This method will call any number of times when you scroll up/down into the recyclerview
    Responsibility of this method is to bind new data with position of list.
    */
    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.apply {
            val category = category[position]
            txtProductName.text=category.category_name
            imgProduct.setImageResource(category.category_image_url.toInt())
        }
    }

    inner class ProductViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
     val txtProductName= binding.txtPrducts
        val imgProduct=binding.productsImage
    }

    companion object {
        const val EMAIL_DATA = "email data"
    }
}