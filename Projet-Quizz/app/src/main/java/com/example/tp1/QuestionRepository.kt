package com.example.tp1

interface QuestionRepository {
    fun getQuestionsForCategory(category: String): List<Question>
}