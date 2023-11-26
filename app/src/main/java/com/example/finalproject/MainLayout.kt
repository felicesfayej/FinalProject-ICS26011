package com.example.finalproject

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.replace


class MainLayout : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_layout)
    }

    fun home(view: View){
        supportFragmentManager.commit {
            replace<Home>(R.id.fragmentContainer)
            setReorderingAllowed(true)
            addToBackStack("name") // Name can be null
        }
    }

    fun addpost(view: View){
        supportFragmentManager.commit {
            replace<AddPost>(R.id.fragmentContainer)
            setReorderingAllowed(true)
            addToBackStack("name") // Name can be null
        }
    }

    fun search(view: View){
        val i = Intent(this, MainLayout::class.java)
        startActivity(i)
    }

    fun profile(view: View){

        supportFragmentManager.commit {
            replace<Profile>(R.id.fragmentContainer)
            setReorderingAllowed(true)
            addToBackStack("name") // Name can be null
        }

    }
    

}