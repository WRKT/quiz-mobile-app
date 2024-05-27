package com.example.tp1

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ScoreActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_score)

        val correctAnswers = intent.getIntExtra("CORRECT_ANSWERS", 0)
        val wrongAnswers = intent.getIntExtra("WRONG_ANSWERS", 0)
        val scoreTextView = findViewById<TextView>(R.id.scoreTextView)
        val bestScoresTextView = findViewById<TextView>(R.id.bestScoresTextView)

        scoreTextView.text = "✔️ $correctAnswers, ❌ $wrongAnswers"

        val prefs = getSharedPreferences("quiz_scores", Context.MODE_PRIVATE)
        val username = intent.getStringExtra("USERNAME")
        val category = intent.getStringExtra("CATEGORY")

        val bestScores = prefs.all.filterKeys { it.startsWith(username ?: "") }
        val sortedBestScores = bestScores.entries.sortedByDescending { it.value as Int }

        val bestScoresText = sortedBestScores.joinToString("\n") { "${it.key}: ${it.value}" }
        bestScoresTextView.text = bestScoresText

        val backToLoginButton = findViewById<Button>(R.id.backToLoginButton)
        backToLoginButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
