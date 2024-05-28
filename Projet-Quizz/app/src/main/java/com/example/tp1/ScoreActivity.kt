package com.example.tp1

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ScoreActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_score)

        val correctAnswers = intent.getIntExtra("CORRECT_ANSWERS", 0)
        val wrongAnswers = intent.getIntExtra("WRONG_ANSWERS", 0)
        val username = intent.getStringExtra("USERNAME") ?: "Player"

        val playerNameTextView = findViewById<TextView>(R.id.playerNameTextView)
        val scoreTextView = findViewById<TextView>(R.id.scoreTextView)

        playerNameTextView.text = "$username"
        scoreTextView.text = "✔️ $correctAnswers    ❌ $wrongAnswers"
    }
}
