package com.example.tp1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val usernameInput = findViewById<EditText>(R.id.usernameInput)
        val loginButton = findViewById<Button>(R.id.loginButton)

        loginButton.setOnClickListener {
            val username = usernameInput.text.toString()
            if (username.isNotBlank()) {
                val intent = Intent(this, CategoryActivity::class.java)
                intent.putExtra("USERNAME", username)
                startActivity(intent)
                finish()
            }
        }
    }
}
