package com.example.recyclerviewdemo

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ItemAdapter(private val items: List<ItemModel>) :
    RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

        val TAG = "ItemAdapter"

    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image: ImageView = itemView.findViewById(R.id.itemImage)
        val title: TextView = itemView.findViewById(R.id.itemTitle)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_layout, parent, false)
        return ItemViewHolder(view)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = items[position]
        holder.image.setImageResource(item.imageResId)
        holder.title.text = item.title

        holder.itemView.isEnabled = item.isActive
        holder.itemView.alpha = if (item.isActive) 1.0f else 0.4f

//        val scale = if (item.isActive) 1.0f else 0.95f
//        holder.itemView.scaleX = scale
//        holder.itemView.scaleY = scale

        val params = holder.itemView.layoutParams
        val scale = holder.itemView.context.resources.displayMetrics.density
        val reduction = (10 * scale).toInt() // 10dp to px

        if (item.isActive) {
            params.width = ViewGroup.LayoutParams.WRAP_CONTENT
            params.height = ViewGroup.LayoutParams.WRAP_CONTENT
        } else {
            // Reduce size by 10dp in both width and height
            params.width = 100
            params.height = 100
        }
        Log.d(TAG, "onBindViewHolder:1 ${holder.itemView.width} ${holder.itemView.height}")
        Log.d(TAG, "onBindViewHolder:2 ${params.width} ${params.height}")

        holder.itemView.layoutParams = params
    }
}