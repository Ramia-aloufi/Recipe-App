package com.example.recipeapp
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.itemtext.view.*


class MyAdapter( var item:ArrayList<String>):RecyclerView.Adapter<MyAdapter.ItemViewHolder>() {
    class ItemViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.itemtext,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        var items = item[position]
        holder.itemView.apply {
            tv.text = items
        }
    }

    override fun getItemCount() = item.size
}