package com.example.tp1

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Question")
data class Questions(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val categoryId: Int,
    val text: String
)

@Entity(tableName = "Answer")
data class Answer(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val questionId: Int,
    val text: String,
    val isCorrect: Boolean
)

@Entity(tableName = "Category")
data class Category(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String
)