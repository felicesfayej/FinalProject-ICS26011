package com.example.finalproject

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.fragment.app.commit
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.replace

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class Profile : Fragment() {
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    private var postsButton: TextView? = null
    private var favoritesButton: TextView? = null

    private var postsButtonSelected = true

    private var favoritesButtonSelected = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_profile, container, false)

        postsButton = view.findViewById(R.id.postsButton)
        favoritesButton = view.findViewById(R.id.favoritesButton)
        var editProfileButton = view.findViewById<Button>(R.id.editprofile)
        postsButton?.setBackgroundResource(R.drawable.button_selector_pressed)

        postsButton?.setOnClickListener {
            onPostsButtonClick(it)
        }

        favoritesButton?.setOnClickListener {
            onFavoritesButtonClick(it)
        }

        editProfileButton.setOnClickListener {
            toEditProfile()
        }

        return view
    }

    private fun onPostsButtonClick(view: View) {
        if (!postsButtonSelected) {
            postsButtonSelected = true
            favoritesButtonSelected = false

            // Update the background selector for the buttons
            postsButton?.setBackgroundResource(R.drawable.button_selector_pressed)
            favoritesButton?.setBackgroundResource(R.drawable.button_selector)

            showPostsFragment()
        }
    }

    private fun onFavoritesButtonClick(view: View) {
        if (!favoritesButtonSelected) {
            favoritesButtonSelected = true
            postsButtonSelected = false

            // Update the background selector for the buttons
            favoritesButton?.setBackgroundResource(R.drawable.button_selector_pressed)
            postsButton?.setBackgroundResource(R.drawable.button_selector)

            showFavoritesFragment()
        }
    }



    private fun showPostsFragment() {
        childFragmentManager.commit {
            replace<Posts>(R.id.profile_fragmentContainer)
            setReorderingAllowed(true)
            addToBackStack("name")
        }
    }

    private fun showFavoritesFragment() {
        childFragmentManager.commit {
            replace<Favorites>(R.id.profile_fragmentContainer)
            setReorderingAllowed(true)
            addToBackStack("name")
        }
    }

    private fun toEditProfile(){
        parentFragmentManager.commit {
            replace<EditProfile>(R.id.fragmentContainer)
            setReorderingAllowed(true)
            addToBackStack("name")
        }
    }
    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Profile().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}

