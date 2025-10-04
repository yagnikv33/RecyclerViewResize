package com.example.recyclerviewdemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ItemAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.horizontalRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        val items = mutableListOf<ItemModel>()
        for (i in 1..20) {
            val isActive = (i == 1 || i == 3 || i == 7)
            items.add(ItemModel(R.drawable.ic_launcher_foreground, "Item $i", isActive))
        }

        adapter = ItemAdapter(items)
        recyclerView.adapter = adapter
    }
}