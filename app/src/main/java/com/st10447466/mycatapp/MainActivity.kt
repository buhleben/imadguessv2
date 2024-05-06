package com.st10447466.mycatapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    private lateinit var startButton:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startButton = findViewById(R.id.startBtn)

        val startButton = findViewById<Button>(R.id.startBtn)

        startButton.setOnClickListener {
            startActivity(Intent(this,MainActivity2::class.java))
            finish()
        }
    }
}