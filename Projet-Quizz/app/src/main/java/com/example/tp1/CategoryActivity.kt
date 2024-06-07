package com.example.tp1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CategoryActivity : AppCompatActivity() {

    private lateinit var quizRepository: QuizRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category)

        quizRepository = QuizRepository(QuizDatabase.getDatabase(this))

        val username = intent.getStringExtra("USERNAME") ?: "Player"

        val videoGamesButton = findViewById<Button>(R.id.videoGamesButton)
        val cinemaButton = findViewById<Button>(R.id.cinemaButton)
        val sportButton = findViewById<Button>(R.id.sportButton)
        val mathButton = findViewById<Button>(R.id.mathsButton)
        val musicButton = findViewById<Button>(R.id.musicButton)
        val logoutButton = findViewById<Button>(R.id.logoutButton)

        setupButton(videoGamesButton, username, "videoGames")
        setupButton(cinemaButton, username, "cinema")
        setupButton(sportButton, username, "sport")
        setupButton(mathButton, username, "maths")
        setupButton(musicButton, username, "music")

        logoutButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    private fun setupButton(button: Button, username: String, categoryName: String) {
        CoroutineScope(Dispatchers.IO).launch {
            val category = quizRepository.getCategoryIdByName(categoryName)
            withContext(Dispatchers.Main) {
                if (category != null) {
                    button.text = mapCategoryNameToDisplayName(categoryName)
                    button.setOnClickListener {
                        startQuizActivity(username, categoryName)
                    }
                } else {
                    button.isEnabled = false
                }
            }
        }
    }

    private fun startQuizActivity(username: String, category: String) {
        val intent = Intent(this, QuizActivity::class.java)
        intent.putExtra("USERNAME", username)
        intent.putExtra("CATEGORY", category)
        startActivity(intent)
    }

    private fun mapCategoryNameToDisplayName(categoryName: String): String {
        return when (categoryName) {
            "videoGames" -> "Jeux-vidéos"
            "cinema" -> "Cinéma"
            "sport" -> "Sport"
            "maths" -> "Mathématiques"
            "music" -> "Musique"
            else -> categoryName
        }
    }
}
