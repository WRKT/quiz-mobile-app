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

        val videoGamesButton = findViewById<Button>(R.id.videoGamesButton)
        val cinemaButton = findViewById<Button>(R.id.cinemaButton)
        val sportButton = findViewById<Button>(R.id.sportButton)
        val mathButton = findViewById<Button>(R.id.mathsButton)
        val musicButton = findViewById<Button>(R.id.musicButton)
        val historyButton = findViewById<Button>(R.id.historyButton)
        val logoutButton = findViewById<Button>(R.id.logoutButton)

        setupButton(videoGamesButton, "videoGames")
        setupButton(cinemaButton, "cinema")
        setupButton(sportButton, "sport")
        setupButton(mathButton, "maths")
        setupButton(musicButton, "music")
        setupButton(historyButton, "history")

        logoutButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    private fun setupButton(button: Button, categoryName: String) {
        CoroutineScope(Dispatchers.IO).launch {
            val category = quizRepository.getCategoryIdByName(categoryName)
            withContext(Dispatchers.Main) {
                if (category != null) {
                    button.text = mapCategoryNameToDisplayName(categoryName)
                    button.setOnClickListener {
                        startQuizActivity(categoryName)
                    }
                } else {
                    button.isEnabled = false
                }
            }
        }
    }

    private fun startQuizActivity(category: String) {
        val intent = Intent(this, QuizActivity::class.java)
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
            "history" -> "Histoire"
            else -> categoryName
        }
    }
}
