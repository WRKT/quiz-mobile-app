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
        val username = intent.getStringExtra("USERNAME") ?: "Player"

        val scoreTextView = findViewById<TextView>(R.id.scoreTextView)
        val playerNameTextView = findViewById<TextView>(R.id.playerNameTextView)

        playerNameTextView.text = "Votre score est :"
        scoreTextView.text = "✔️ $correctAnswers, ❌ $wrongAnswers"

        val backToCategoryButton = findViewById<Button>(R.id.backToCategoryButton)
        backToCategoryButton.setOnClickListener {
            val intent = Intent(this, CategoryActivity::class.java)
            intent.putExtra("USERNAME", username)
            startActivity(intent)
            finish()
        }
    }
}
