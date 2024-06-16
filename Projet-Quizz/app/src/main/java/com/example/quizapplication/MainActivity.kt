package com.example.quizapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.quizapplication.database.MockData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var quizRepository: QuizRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        quizRepository = QuizRepository(QuizDatabase.getDatabase(this))

        val usernameInput = findViewById<EditText>(R.id.usernameInput)
        val loginButton = findViewById<Button>(R.id.loginButton)

        loginButton.setOnClickListener {
            val username = usernameInput.text.toString()
            if (username.isNotBlank()) {
                saveUsername(username)
                val intent = Intent(this, CategoryActivity::class.java)
                startActivity(intent)
                finish()
            }
        }

        CoroutineScope(Dispatchers.IO).launch {
            if (quizRepository.getAllCategories().isEmpty()) {
                MockData(quizRepository).populateDatabase()
            }
        }
    }

    private fun saveUsername(username: String) {
        val prefs = getSharedPreferences("quiz_app", MODE_PRIVATE)
        val editor = prefs.edit()
        editor.putString("USERNAME", username)
        editor.apply()
    }
}
