package com.example.mixedconcretedesign

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    lateinit var ordinaryConcreteBtn : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ordinaryConcreteBtn = findViewById(R.id.ordinaryConcreteBtn)
        ordinaryConcreteBtn.setOnClickListener {
            startOrdinaryConcretActivity()
        }
    }
    fun startOrdinaryConcretActivity(){
        val i = Intent(this,OrdinaryConcreteActivity::class.java)
        startActivity(i)
    }
}