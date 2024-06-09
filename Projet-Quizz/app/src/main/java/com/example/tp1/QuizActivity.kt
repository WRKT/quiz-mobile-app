package com.example.tp1

import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class QuizActivity : AppCompatActivity() {

    private lateinit var quizRepository: QuizRepository
    private lateinit var questions: List<Question>
    private var currentQuestionIndex = 0
    private var correctAnswers = 0
    private var wrongAnswers = 0

    private lateinit var questionNumberView: TextView
    private lateinit var questionTextView: TextView
    private lateinit var answerButton1: Button
    private lateinit var answerButton2: Button
    private lateinit var answerButton3: Button
    private lateinit var answerButton4: Button
    private lateinit var nextButton: Button
    private lateinit var correctAnswersTextView: TextView
    private lateinit var wrongAnswersTextView: TextView
    private lateinit var timerTextView: TextView
    private lateinit var countDownTimer: CountDownTimer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)

        quizRepository = QuizRepository(QuizDatabase.getDatabase(this))

        questionNumberView = findViewById(R.id.questionNumberView)
        questionTextView = findViewById(R.id.questionTextView)
        answerButton1 = findViewById(R.id.answerButton1)
        answerButton2 = findViewById(R.id.answerButton2)
        answerButton3 = findViewById(R.id.answerButton3)
        answerButton4 = findViewById(R.id.answerButton4)
        nextButton = findViewById(R.id.nextButton)
        correctAnswersTextView = findViewById(R.id.correctAnswersTextView)
        wrongAnswersTextView = findViewById(R.id.wrongAnswersTextView)
        timerTextView = findViewById(R.id.timerTextView)

        val category = intent.getStringExtra("CATEGORY") ?: "Unknown"
        loadQuestions(category)

        nextButton.setOnClickListener {
            countDownTimer.cancel()
            showNextQuestion()
        }
    }

    private fun loadQuestions(category: String) {
        CoroutineScope(Dispatchers.IO).launch {
            val categoryId = quizRepository.getCategoryIdByName(category)
            questions = quizRepository.getQuestionsForCategory(categoryId).shuffled().take(10)
            withContext(Dispatchers.Main) {
                showNextQuestion()
            }
        }
    }

    private fun showNextQuestion() {
        if (currentQuestionIndex >= questions.size) {
            showScore()
            return
        }

        val question = questions[currentQuestionIndex]
        val questionNumber = currentQuestionIndex + 1
        questionNumberView.text = "💡 Question $questionNumber"
        questionTextView.text = question.text

        CoroutineScope(Dispatchers.IO).launch {
            val answers = quizRepository.getAnswersForQuestion(question.id).shuffled()
            withContext(Dispatchers.Main) {
                setAnswerButtons(answers, question)
                startTimer()
                currentQuestionIndex++
            }
        }
    }

    private fun setAnswerButtons(answers: List<Answer>, question: Question) {
        val buttons = listOf(answerButton1, answerButton2, answerButton3, answerButton4)
        buttons.forEachIndexed { index, button ->
            button.text = answers.getOrNull(index)?.text ?: ""
            button.setOnClickListener {
                countDownTimer.cancel()
                if (button.text == question.correctAnswer) {
                    correctAnswers++
                } else {
                    wrongAnswers++
                }
                updateScore()
                showNextQuestion()
            }
        }
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
        intent.putExtra("CATEGORY", intent.getStringExtra("CATEGORY"))
        intent.putExtra("CORRECT_ANSWERS", correctAnswers)
        intent.putExtra("WRONG_ANSWERS", wrongAnswers)
        startActivity(intent)
        finish()
    }
}
