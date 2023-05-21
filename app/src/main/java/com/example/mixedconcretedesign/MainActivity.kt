package com.example.mixedconcretedesign

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatDelegate

class MainActivity : AppCompatActivity() {
    lateinit var ordinaryConcreteBtn : TextView
    lateinit var imageView : ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ordinaryConcreteBtn = findViewById(R.id.ordinaryConcreteBtn)
        imageView = findViewById(R.id.iv)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        ordinaryConcreteBtn.setOnClickListener {
            startOrdinaryConcretActivity()
        }
        imageView.setOnClickListener {
            startOrdinaryConcretActivity()
        }
    }
    fun startOrdinaryConcretActivity(){
        val i = Intent(this,OrdinaryConcreteActivity::class.java)
        startActivity(i)
    }
}