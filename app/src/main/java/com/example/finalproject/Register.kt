package com.example.finalproject

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class Register : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.register)
    }

    fun toLogin(view: View) {
        val i = Intent(this, Login::class.java)
        startActivity(i)
    }

    fun toRegConfirm(view: View) {
        val i = Intent(this, RegisterConfirm::class.java)
        startActivity(i)
    }
}