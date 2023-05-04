package com.example.ecommerceapp

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ecommerceapp.databinding.DetailsCategoryListBinding
import com.squareup.picasso.Picasso

class DetailsCategoryAdapter(
    private val categoryList: List<CategoryDetails>,
    private val context: Context,
    private val listener: OnClick
    ) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    @SuppressLint("SuspiciousIndentation")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(context)
        val recyclerItemCategoryBinding: DetailsCategoryListBinding =
            DetailsCategoryListBinding.inflate(layoutInflater, parent, false)
            return TypeItem(recyclerItemCategoryBinding)
    }

    override fun getItemCount(): Int {
        return categoryList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val category = categoryList[position]
        if (holder is TypeItem) {
            holder.binding(category)
            holder.itemView.setOnClickListener {
                listener.detailsProduct(category.id)
            }
        }
    }
    inner class TypeItem(private val recyclerItem: DetailsCategoryListBinding) :
        RecyclerView.ViewHolder(recyclerItem.root) {
        fun binding(category: CategoryDetails) {
            recyclerItem.categoryText.text = category.title
            Picasso.get().load(category.image).into(recyclerItem.categoryImage)
            }
        }
    }

interface OnClick {
    fun detailsProduct(idProduct:Int)
}