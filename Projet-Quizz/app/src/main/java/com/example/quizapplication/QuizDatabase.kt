// QuizDatabase.kt
package com.example.quizapplication

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.quizapplication.dao.AnswerDao
import com.example.quizapplication.dao.CategoryDao
import com.example.quizapplication.dao.QuestionDao

@Database(entities = [Question::class, Answer::class, Category::class], version = 2, exportSchema = false)
abstract class QuizDatabase : RoomDatabase() {

    abstract fun questionDao(): QuestionDao
    abstract fun answerDao(): AnswerDao
    abstract fun categoryDao(): CategoryDao

    companion object {
        @Volatile
        private var INSTANCE: QuizDatabase? = null

        fun getDatabase(context: Context): QuizDatabase {
            return INSTANCE ?: synchronized(this) {
                context.deleteDatabase("quiz_database")
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    QuizDatabase::class.java,
                    "quiz_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
