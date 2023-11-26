package com.example.finalproject

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.ToggleButton
import androidx.recyclerview.widget.RecyclerView

class HomeAdapterClass(private val dataList: ArrayList<HomeDataClass>) :
    RecyclerView.Adapter<HomeAdapterClass.ViewHolder>() {

    // ViewHolder class holds references to views in each item
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val iconImageView: ImageView = itemView.findViewById(R.id.homeposticon)
        val usernameTextView: TextView = itemView.findViewById(R.id.homepostuname)
        val locationTextView: TextView = itemView.findViewById(R.id.homepostlocation)
        val categoryTextView: TextView = itemView.findViewById(R.id.homepostcategory)
        val imageView: ImageView = itemView.findViewById(R.id.homepostimage)
        val likeToggleButton: ToggleButton = itemView.findViewById(R.id.like)
        val faveToggleButton: ToggleButton = itemView.findViewById(R.id.fave)
        val captionTextView: TextView = itemView.findViewById(R.id.homepostcaption)
    }

    // onCreateViewHolder: Inflates the item layout and creates a new ViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.home_post_view, parent, false)
        return ViewHolder(itemView)
    }

    // onBindViewHolder: Binds data to the views in each item
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = dataList[position]

        // Bind data to views
        holder.iconImageView.setImageResource(currentItem.Icon)
        holder.usernameTextView.text = currentItem.Username
        holder.locationTextView.text = currentItem.Location
        holder.categoryTextView.text = currentItem.Category
        holder.imageView.setImageResource(currentItem.Image)
        holder.likeToggleButton.isChecked = currentItem.Like
        holder.faveToggleButton.isChecked = currentItem.Fave
        holder.captionTextView.text = currentItem.Caption

        // Set click listeners for ToggleButtons
        holder.likeToggleButton.setOnClickListener {
            // Handle Like button click
            // Example: Update data or perform some action
            currentItem.Like = holder.likeToggleButton.isChecked
        }

        holder.faveToggleButton.setOnClickListener {
            // Handle Favorite button click
            // Example: Update data or perform some action
            currentItem.Fave = holder.faveToggleButton.isChecked
        }
    }

    // getItemCount: Returns the total number of items in the data set
    override fun getItemCount(): Int {
        return dataList.size
    }
}
