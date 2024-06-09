package com.example.tp1.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.tp1.Question

@Dao
interface QuestionDao {
    @Insert
    suspend fun insertAll(questions: List<Question>)

    @Query("SELECT * FROM questions WHERE categoryId = :categoryId")
    suspend fun getQuestionsByCategory(categoryId: Int): List<Question>
}
