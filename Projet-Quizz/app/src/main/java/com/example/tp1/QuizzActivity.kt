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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quizz)

        val category = intent.getStringExtra("CATEGORY")
        questions = getQuestionsForCategory(category)

        showNextQuestion()

        val nextButton = findViewById<Button>(R.id.nextButton)
        nextButton.setOnClickListener {
            showNextQuestion()
        }
    }

    private fun getQuestionsForCategory(category: String?): List<Question> {
        return when (category) {
            "videoGames" -> videoGamesQuestions()
            "cinema" -> cinemaQuestions()
            "sport" -> sportQuestions()
            "maths" -> mathQuestions()
            "music" -> musicQuestions()
            else -> listOf()
        }.shuffled().take(10)
    }

    private fun videoGamesQuestions() = listOf(
        Question("Quelle année est sorti le premier jeu de la série 'The Legend of Zelda'?", "1986", listOf("1986", "1985", "1987", "1988")),
        Question("Qui est le créateur de la série de jeux 'Super Mario'?", "Shigeru Miyamoto", listOf("Shigeru Miyamoto", "Hideo Kojima", "Yu Suzuki", "Satoru Iwata")),
        Question("Dans quel jeu vidéo trouve-t-on le personnage de Lara Croft?", "Tomb Raider", listOf("Tomb Raider", "Uncharted", "The Last of Us", "Resident Evil")),
        // Add 17 more questions
    )

    private fun cinemaQuestions() = listOf(
        Question("Qui a réalisé le film 'Inception'?", "Christopher Nolan", listOf("Christopher Nolan", "Steven Spielberg", "James Cameron", "Quentin Tarantino")),
        Question("Quel acteur joue le personnage de Jack Dawson dans 'Titanic'?", "Leonardo DiCaprio", listOf("Leonardo DiCaprio", "Brad Pitt", "Johnny Depp", "Tom Hanks")),
        Question("En quelle année est sorti le premier film de la saga 'Harry Potter'?", "2001", listOf("2001", "2000", "2002", "1999")),
        // Add 17 more questions
    )

    private fun sportQuestions() = listOf(
        Question("Quel pays a remporté la Coupe du Monde de football en 2018?", "France", listOf("France", "Brésil", "Allemagne", "Argentine")),
        Question("Combien de points faut-il pour gagner un set au tennis?", "6", listOf("6", "5", "7", "8")),
        Question("Qui est le recordman du monde du 100 mètres en athlétisme?", "Usain Bolt", listOf("Usain Bolt", "Tyson Gay", "Yohan Blake", "Justin Gatlin")),
        // Add 17 more questions
    )

    private fun mathQuestions() = listOf(
        Question("Quel est le nombre premier suivant après 7?", "11", listOf("11", "9", "10", "12")),
        Question("Quelle est la valeur de Pi approximée à deux décimales?", "3.14", listOf("3.14", "3.15", "3.13", "3.16")),
        Question("Combien de côtés a un hexagone?", "6", listOf("6", "5", "7", "8")),
        // Add 17 more questions
    )

    private fun musicQuestions() = listOf(
        Question("Quel groupe a chanté 'Bohemian Rhapsody'?", "Queen", listOf("Queen", "The Beatles", "Led Zeppelin", "Pink Floyd")),
        Question("Qui est surnommé le 'Roi de la Pop'?", "Michael Jackson", listOf("Michael Jackson", "Elvis Presley", "Prince", "Madonna")),
        Question("Quel est le nom de l'album le plus vendu de tous les temps?", "Thriller", listOf("Thriller", "Back in Black", "The Dark Side of the Moon", "The Wall")),
        // Add 17 more questions
    )

    private fun showNextQuestion() {
        if (currentQuestionIndex >= questions.size) {
//            showScore()
            return
        }

        val question = questions[currentQuestionIndex]
        val questionTextView = findViewById<TextView>(R.id.questionTextView)
        questionTextView.text = question.text

        // Set up answer buttons with question.answers
        // Handle timer and user answers

        currentQuestionIndex++
    }

//    private fun showScore() {
//        val intent = Intent(this, ScoreActivity::class.java)
//        intent.putExtra("CORRECT_ANSWERS", correctAnswers)
//        intent.putExtra("WRONG_ANSWERS", wrongAnswers)
//        startActivity(intent)
//        finish()
//    }
}

data class Question(val text: String, val correctAnswer: String, val answers: List<String>)
