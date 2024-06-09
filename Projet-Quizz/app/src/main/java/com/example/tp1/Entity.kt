package com.example.tp1

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "questions",
    foreignKeys = [ForeignKey(
        entity = Category::class,
        parentColumns = ["id"],
        childColumns = ["categoryId"],
        onDelete = ForeignKey.CASCADE
    )]
)
data class Question(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "categoryId", index = true) val categoryId: Int,
    @ColumnInfo(name = "text") val text: String,
    @ColumnInfo(name = "correctAnswer") val correctAnswer: String
)

@Entity(
    tableName = "answers",
    foreignKeys = [ForeignKey(
        entity = Question::class,
        parentColumns = ["id"],
        childColumns = ["questionId"],
        onDelete = ForeignKey.CASCADE
    )]
)
data class Answer(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "questionId", index = true) val questionId: Int,
    @ColumnInfo(name = "text") val text: String
)

@Entity(tableName = "categories")
data class Category(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "name") val name: String
)
