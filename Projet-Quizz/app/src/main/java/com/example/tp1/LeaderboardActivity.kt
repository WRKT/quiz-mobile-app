package com.example.tp1

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class LeaderboardActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_leaderboard)

        val category = intent.getStringExtra("CATEGORY") ?: "Unknown"
        val leaderboardLayout = findViewById<LinearLayout>(R.id.leaderboardLayout)

        val prefs = getSharedPreferences("quiz_app", Context.MODE_PRIVATE)
        val scores = prefs.all.filterKeys { it.endsWith("_${category}_highScore") }
            .map { it.key.removeSuffix("_${category}_highScore") to it.value as Int }
            .sortedByDescending { it.second }

        Log.d("LeaderboardActivity", "Scores: $scores")

        if (scores.isEmpty()) {
            Log.d("LeaderboardActivity", "No scores found for category: $category")
        }

        scores.forEach { (username, score) ->
            val textView = TextView(this)
            textView.text = "$username: $score"
            textView.textSize = 18f
            textView.setPadding(10, 10, 10, 10)
            leaderboardLayout.addView(textView)
        }

        findViewById<Button>(R.id.backButton).setOnClickListener {
            onBackButtonClicked()
        }
    }

    private fun onBackButtonClicked() {
        val intent = Intent(this, CategoryActivity::class.java)
        startActivity(intent)
        finish()
    }
}
