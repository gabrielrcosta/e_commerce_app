package com.example.ecommerceapp

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ecommerceapp.databinding.CategoryListBinding
import com.squareup.picasso.Picasso

class CategoryAdapter(
    private val categoryList: List<CategoryProduct>,
    private val context: Context,
    private val listener: Click
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(context)
        val recyclerItemCategoryBinding: CategoryListBinding =
            CategoryListBinding.inflate(layoutInflater, parent, false)
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
                listener.onClick(category.name)
            }
        }
    }
    inner class TypeItem(private val recyclerItem: CategoryListBinding):
        RecyclerView.ViewHolder(recyclerItem.root) {
        fun binding(category: CategoryProduct) {
            recyclerItem.categoryText.text = category.name
            Picasso.get().load(category.image).into(recyclerItem.categoryImage)
        }
    }
}
interface Click {
    fun onClick(name:String)
}