package com.example.finalproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun toLogin(view: View) {
        val i = Intent(this, Login::class.java)
        startActivity(i)
    }

    fun toMainLayout(view: View){
        val i = Intent(this, MainLayout::class.java)
        startActivity(i)
    }

}