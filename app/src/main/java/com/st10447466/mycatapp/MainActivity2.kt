package com.st10447466.mycatapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

class MainActivity2 : AppCompatActivity() {

    private var stomach = 100
    private var bake = 0
    private var energy = 100

    private var feedCount = 10
    private var cookCount = 0
    private var playCount = 20

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val kitty: ImageView = findViewById(R.id.kitty)
        val feedButton: Button = findViewById(R.id.feedBtn)
        val cookButton: Button = findViewById(R.id.cookBtn)
        val playButton: Button = findViewById(R.id.playBtn)
        val statusText: TextView = findViewById(R.id.healthbar)

        val backButton: Button = findViewById(R.id.homeBtn)
        backButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        feedButton.setOnClickListener {
            feed()
            feedCount++
            updateStatusText(statusText, "Feed: +$feedCount")
            Glide.with(this)
                .load(R.drawable.cateating)
                .into(kitty)
        }

        cookButton.setOnClickListener {
            cook()
            cookCount++
            updateStatusText(statusText, "Cook: +$cookCount")
            Glide.with(this)
                .load(R.drawable.catcooking)
                .into(kitty)
        }

        playButton.setOnClickListener {
            play()
            playCount++
            updateStatusText(statusText, "Play: +$playCount")
            Glide.with(this)
                .load(R.drawable.catplaying)
                .into(kitty)
        }
    }

    private fun updateStatusText(statusTextView: TextView, s: String) {

    }

    private fun feed() {
        if (bake >= 20 && stomach < 100) {
            bake -= 20
            stomach += 100
            if (stomach > 100) {
                stomach = 100
            }
        }
        updateStatusText()
    }

    private fun cook() {
        if (energy < 100 && stomach < 100) {
            energy += 20
            stomach += 5
            if (stomach > 100) stomach = 100
        }
        updateStatusText()
    }

    private fun play() {
        if ( bake < 100 && energy >= 10) {
            if (stomach > 10) {
                stomach -= 10
                bake += 20
                energy -= 10
            }
            if (bake > 100) bake = 100
            if ( energy < 0) energy = 0
        }
        updateStatusText()
    }

    private fun updateStatusText() {
        val statusText: TextView = findViewById(R.id.healthbar)
        statusText.text = "Stomach: $stomach Bake: $bake Energy: $energy"
    }
}
