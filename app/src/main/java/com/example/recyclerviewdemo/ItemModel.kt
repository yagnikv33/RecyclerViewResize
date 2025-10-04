package com.example.recyclerviewdemo

data class ItemModel(
    val imageResId: Int,
    val title: String,
    val isActive: Boolean = false
)