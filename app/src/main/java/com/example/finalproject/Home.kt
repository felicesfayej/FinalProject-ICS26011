package com.example.finalproject

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Home : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var dataList: ArrayList<HomeDataClass>
    private lateinit var imageList: Array<Int>
    private lateinit var iconList: Array<Int>
    private lateinit var usernameList: Array<String>
    private lateinit var locationList: Array<String>
    private lateinit var categoryList: Array<String>
    private lateinit var captionList: Array<String>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        // Initialize RecyclerView
        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        // For demonstration purposes, using sample data
        imageList = arrayOf(R.drawable.icon_background, R.drawable.icon_background, R.drawable.icon_background)
        iconList = arrayOf(R.drawable.icon_foreground, R.drawable.icon_foreground, R.drawable.icon_foreground)
        usernameList = arrayOf("User1", "User2", "User3")
        locationList = arrayOf("Location1", "Location2", "Location3")
        categoryList = arrayOf("Category1", "Category2", "Category3")
        captionList = arrayOf("Caption1", "Caption2", "Caption3")

        // Get data and set up the adapter
        getData()

        return view
    }

    private fun getData() {
        dataList = ArrayList()

        // Populate dataList with data
        for (i in imageList.indices) {
            val dataClass = HomeDataClass(
                Icon = iconList[i],
                Username = usernameList[i],
                Location = locationList[i],
                Image = imageList[i],
                Like = false,  // Initial like state
                Fave = false,  // Initial favorite state
                Category = categoryList[i],
                Caption = captionList[i]
            )
            dataList.add(dataClass)
        }

        // Create and set up the adapter
        recyclerView.adapter = HomeAdapterClass(dataList)

    }
}
