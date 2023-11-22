package com.example.finalproject

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class RegisterConfirm : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.register_confirm)
    }

    fun toRegister(view: View) {
        val i = Intent(this, Register::class.java)
        startActivity(i)
    }

    fun toLogin(view: View) {
        val i = Intent(this, Login::class.java)
        startActivity(i)
    }
}