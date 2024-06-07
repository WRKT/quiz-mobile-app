package com.example.tp1

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface AnswerDao {
    @Insert
    suspend fun insertAll(answers: List<Answer>)

    @Query("SELECT * FROM answers WHERE questionId = :questionId")
    suspend fun getAnswersByQuestionId(questionId: Int): List<Answer>
}
