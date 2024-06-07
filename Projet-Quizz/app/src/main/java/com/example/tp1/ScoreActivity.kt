package com.example.tp1

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ScoreActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_score)

        val correctAnswers = intent.getIntExtra("CORRECT_ANSWERS", 0)
        val wrongAnswers = intent.getIntExtra("WRONG_ANSWERS", 0)
        val category = intent.getStringExtra("CATEGORY") ?: "Unknown"

        val prefs = getSharedPreferences("quiz_app", Context.MODE_PRIVATE)
        val username = prefs.getString("USERNAME", "Player") ?: "Player"

        val editor = prefs.edit()
        val key = "${username}_${category}_highScore"
        editor.putInt(key, correctAnswers)
        editor.apply()

        Log.d("ScoreActivity", "Saved score: $correctAnswers for user: $username in category: $category")

        val playerNameTextView = findViewById<TextView>(R.id.playerNameTextView)
        val scoreTextView = findViewById<TextView>(R.id.scoreTextView)
        val detailsTextView = findViewById<TextView>(R.id.detailsTextView)
        val backToCategoriesButton = findViewById<Button>(R.id.backToCategoryButton)
        val showLeaderboardButton = findViewById<Button>(R.id.showLeaderboardButton)

        playerNameTextView.text = "Pseudo: $username"
        scoreTextView.text = "Score: $correctAnswers/10"
        detailsTextView.text = "✔\uFE0F $correctAnswers            ❌ $wrongAnswers"

        backToCategoriesButton.setOnClickListener {
            val intent = Intent(this, CategoryActivity::class.java)
            startActivity(intent)
            finish()
        }

        showLeaderboardButton.setOnClickListener {
            val intent = Intent(this, LeaderboardActivity::class.java)
            intent.putExtra("CATEGORY", category)
            startActivity(intent)
        }
    }
}
