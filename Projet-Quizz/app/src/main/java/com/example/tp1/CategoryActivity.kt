package com.example.tp1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class CategoryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category)

        val username = intent.getStringExtra("USERNAME") ?: "Player"

        val videoGamesButton = findViewById<Button>(R.id.videoGamesButton)
        val cinemaButton = findViewById<Button>(R.id.cinemaButton)
        val sportButton = findViewById<Button>(R.id.sportButton)
        val mathButton = findViewById<Button>(R.id.mathsButton)
        val musicButton = findViewById<Button>(R.id.musicButton)
        val logoutButton = findViewById<Button>(R.id.logoutButton)

        videoGamesButton.setOnClickListener {
            startQuizActivity(username, "videoGames")
        }

        cinemaButton.setOnClickListener {
            startQuizActivity(username, "cinema")
        }

        sportButton.setOnClickListener {
            startQuizActivity(username, "sport")
        }

        mathButton.setOnClickListener {
            startQuizActivity(username, "maths")
        }

        musicButton.setOnClickListener {
            startQuizActivity(username, "music")
        }

        logoutButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    private fun startQuizActivity(username: String, category: String) {
        val intent = Intent(this, QuizzActivity::class.java)
        intent.putExtra("USERNAME", username)
        intent.putExtra("CATEGORY", category)
        startActivity(intent)
    }
}
