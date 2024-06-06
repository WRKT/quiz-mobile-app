package com.example.tp1

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "questions")
data class Questions(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val category: String,
    val text: String,
    val correctAnswer: String,
    val answers: List<String>
)