package com.example.tp1

import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class QuizzActivity : AppCompatActivity() {

    private var currentQuestionIndex = 0
    private var correctAnswers = 0
    private var wrongAnswers = 0

    private lateinit var questions: List<Question>
    private lateinit var correctAnswersTextView: TextView
    private lateinit var wrongAnswersTextView: TextView
    private lateinit var timerTextView: TextView
    private lateinit var countDownTimer: CountDownTimer
    private lateinit var username: String
    private lateinit var category: String

    private val questionRepository: QuestionRepository = QuizQuestionRepository()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)

        correctAnswersTextView = findViewById(R.id.correctAnswersTextView)
        wrongAnswersTextView = findViewById(R.id.wrongAnswersTextView)
        timerTextView = findViewById(R.id.timerTextView)

        username = intent.getStringExtra("USERNAME") ?: "Player"
        category = intent.getStringExtra("CATEGORY") ?: "Unknown"
        questions = questionRepository.getQuestionsForCategory(category)

        showNextQuestion()

        val nextButton = findViewById<Button>(R.id.nextButton)
        nextButton.setOnClickListener {
            countDownTimer.cancel()
            showNextQuestion()
        }
    }

    private fun showNextQuestion() {
        if (currentQuestionIndex >= questions.size) {
            showScore()
            return
        }

        val question = questions[currentQuestionIndex]
        val questionNumber = currentQuestionIndex + 1
        val questionNumberView = findViewById<TextView>(R.id.questionNumberView)
        val questionTextView = findViewById<TextView>(R.id.questionTextView)

        questionNumberView.text = "💡 Question $questionNumber"
        questionTextView.text = question.text

        val answerButtons = listOf<Button>(
            findViewById(R.id.answerButton1),
            findViewById(R.id.answerButton2),
            findViewById(R.id.answerButton3),
            findViewById(R.id.answerButton4)
        )

        question.answers.shuffled().forEachIndexed { index, answer ->
            answerButtons[index].text = answer
            answerButtons[index].setOnClickListener {
                countDownTimer.cancel()
                if (answer == question.correctAnswer) {
                    correctAnswers++
                } else {
                    wrongAnswers++
                }
                updateScore()
                showNextQuestion()
            }
        }

        startTimer()
        currentQuestionIndex++
    }

    private fun startTimer() {
        countDownTimer = object : CountDownTimer(15000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                timerTextView.text = "⏳ Time left: ${millisUntilFinished / 1000}"
            }

            override fun onFinish() {
                wrongAnswers++
                updateScore()
                showNextQuestion()
            }
        }.start()
    }

    private fun updateScore() {
        correctAnswersTextView.text = "✔️ $correctAnswers"
        wrongAnswersTextView.text = "❌ $wrongAnswers"
    }

    private fun showScore() {
        val intent = Intent(this, ScoreActivity::class.java)
        intent.putExtra("USERNAME", username)
        intent.putExtra("CATEGORY", category)
        intent.putExtra("CORRECT_ANSWERS", correctAnswers)
        intent.putExtra("WRONG_ANSWERS", wrongAnswers)
        startActivity(intent)
        finish()
    }
}

data class Question(val text: String, val correctAnswer: String, val answers: List<String>)
