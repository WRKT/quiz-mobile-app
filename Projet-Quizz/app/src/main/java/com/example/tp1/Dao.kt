package com.example.tp1

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
@Dao
interface QuestionDao {
    @Query("SELECT * FROM Question WHERE categoryId = :categoryId")
    suspend fun getQuestionsByCategory(categoryId: Int): List<Question>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(questions: List<Question>)
}

@Dao
interface AnswerDao {
    @Query("SELECT * FROM Answer WHERE questionId = :questionId")
    suspend fun getAnswersByQuestion(questionId: Int): List<Answer>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(answers: List<Answer>)
}

@Dao
interface CategoryDao {
    @Query("SELECT * FROM Category")
    suspend fun getAllCategories(): List<Category>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(categories: List<Category>)
}