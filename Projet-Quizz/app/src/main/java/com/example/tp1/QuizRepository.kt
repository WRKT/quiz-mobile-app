package com.example.tp1

class QuizRepository(private val database: QuizDatabase) {

    suspend fun getQuestionsForCategory(categoryId: Int): List<Question> {
        return database.questionDao().getQuestionsByCategory(categoryId)
    }

    suspend fun getAnswersForQuestion(questionId: Int): List<Answer> {
        return database.answerDao().getAnswersByQuestionId(questionId)
    }

    suspend fun getAllCategories(): List<Category> {
        return database.categoryDao().getAllCategories()
    }

    suspend fun getCategoryIdByName(categoryName: String): Int {
        return database.categoryDao().getCategoryIdByName(categoryName)
    }
    suspend fun insertQuestions(questions: List<Question>) {
        database.questionDao().insertAll(questions)
    }

    suspend fun insertAnswers(answers: List<Answer>) {
        database.answerDao().insertAll(answers)
    }

    suspend fun insertCategories(categories: List<Category>) {
        database.categoryDao().insertAll(categories)
    }
}
