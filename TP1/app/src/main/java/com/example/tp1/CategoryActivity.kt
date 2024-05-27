package com.example.tp1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class CategoryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category)

        val username = intent.getStringExtra("USERNAME")

        val videoGamesButton = findViewById<Button>(R.id.videoGamesButton)
        val cinemaButton = findViewById<Button>(R.id.cinemaButton)
        val sportButton = findViewById<Button>(R.id.sportButton)
        val mathButton = findViewById<Button>(R.id.mathsButton)
        val musicButton = findViewById<Button>(R.id.musicButton)

        videoGamesButton.setOnClickListener {
            startQuizActivity("videoGames")
        }

        cinemaButton.setOnClickListener {
            startQuizActivity("cinema")
        }

        sportButton.setOnClickListener {
            startQuizActivity("sport")
        }

        mathButton.setOnClickListener {
            startQuizActivity("maths")
        }

        musicButton.setOnClickListener {
            startQuizActivity("music")
        }
    }

    private fun startQuizActivity(category: String) {
        val intent = Intent(this, QuizzActivity::class.java)
        intent.putExtra("CATEGORY", category)
        startActivity(intent)
    }
}
