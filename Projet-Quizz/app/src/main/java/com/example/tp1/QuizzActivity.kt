package com.example.tp1

import android.content.Intent
import android.os.Bundle
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quizz)

        correctAnswersTextView = findViewById(R.id.correctAnswersTextView)
        wrongAnswersTextView = findViewById(R.id.wrongAnswersTextView)

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
        Question("Quel est le jeu vidéo le plus vendu de tous les temps?", "Minecraft", listOf("Minecraft", "Tetris", "GTA V", "Fortnite")),
        Question("En quelle année est sorti le premier jeu 'Call of Duty'?", "2003", listOf("2003", "2001", "2005", "2007")),
        Question("Quel est le studio de développement derrière 'The Witcher 3'?", "CD Projekt Red", listOf("CD Projekt Red", "Ubisoft", "EA", "Rockstar Games")),
        Question("Quel est le nom du protagoniste dans 'Halo'?", "Master Chief", listOf("Master Chief", "Marcus Fenix", "Kratos", "Nathan Drake")),
        Question("Quelle console a été la première à utiliser des CD-ROM?", "PlayStation", listOf("PlayStation", "Sega Saturn", "Nintendo 64", "Dreamcast")),
        Question("Qui est l'éditeur du jeu 'Fortnite'?", "Epic Games", listOf("Epic Games", "Activision", "EA", "Ubisoft")),
        Question("Quel jeu vidéo a popularisé le genre Battle Royale?", "PUBG", listOf("PUBG", "Fortnite", "Apex Legends", "Call of Duty: Warzone")),
        Question("Quel personnage de jeu vidéo est célèbre pour ses aventures dans 'Hyrule'?", "Link", listOf("Link", "Mario", "Sonic", "Samus")),
        Question("Quel est le principal antagoniste dans 'Final Fantasy VII'?", "Sephiroth", listOf("Sephiroth", "Kefka", "Ultimecia", "Sin")),
        Question("Quel jeu vidéo se déroule dans la ville fictive de 'Vice City'?", "GTA Vice City", listOf("GTA Vice City", "GTA San Andreas", "GTA III", "GTA IV")),
        Question("Quel est le nom du compagnon de Sonic?", "Tails", listOf("Tails", "Knuckles", "Shadow", "Amy")),
        Question("Quel jeu de combat met en scène des personnages comme Ryu et Ken?", "Street Fighter", listOf("Street Fighter", "Mortal Kombat", "Tekken", "Soul Calibur")),
        Question("Quelle est la première console de jeux vidéo de Nintendo?", "Nintendo Entertainment System", listOf("Nintendo Entertainment System", "Super Nintendo", "Nintendo 64", "GameCube")),
        Question("Quel jeu met en scène un plombier essayant de sauver une princesse?", "Super Mario Bros", listOf("Super Mario Bros", "Donkey Kong", "The Legend of Zelda", "Metroid")),
        Question("Quel est le personnage principal de 'Metal Gear Solid'?", "Solid Snake", listOf("Solid Snake", "Big Boss", "Liquid Snake", "Raiden")),
        Question("Quel est le jeu vidéo le plus vendu sur la Nintendo Switch?", "Mario Kart 8 Deluxe", listOf("Mario Kart 8 Deluxe", "The Legend of Zelda: Breath of the Wild", "Super Mario Odyssey", "Animal Crossing: New Horizons"))
    )

    private fun cinemaQuestions() = listOf(
        Question("Qui a réalisé le film 'Inception'?", "Christopher Nolan", listOf("Christopher Nolan", "Steven Spielberg", "James Cameron", "Quentin Tarantino")),
        Question("Quel acteur joue le personnage de Jack Dawson dans 'Titanic'?", "Leonardo DiCaprio", listOf("Leonardo DiCaprio", "Brad Pitt", "Johnny Depp", "Tom Hanks")),
        Question("En quelle année est sorti le premier film de la saga 'Harry Potter'?", "2001", listOf("2001", "2000", "2002", "1999")),
        Question("Qui a joué le rôle de 'Joker' dans 'The Dark Knight'?", "Heath Ledger", listOf("Heath Ledger", "Joaquin Phoenix", "Jack Nicholson", "Jared Leto")),
        Question("Quel film a remporté l'Oscar du meilleur film en 2020?", "Parasite", listOf("Parasite", "1917", "Joker", "Once Upon a Time in Hollywood")),
        Question("Qui a réalisé le film 'Pulp Fiction'?", "Quentin Tarantino", listOf("Quentin Tarantino", "Martin Scorsese", "Francis Ford Coppola", "Ridley Scott")),
        Question("Quel film met en scène un groupe de super-héros appelés 'The Avengers'?", "The Avengers", listOf("The Avengers", "Justice League", "X-Men", "Fantastic Four")),
        Question("Quel acteur a joué le rôle principal dans 'Forrest Gump'?", "Tom Hanks", listOf("Tom Hanks", "Robert Redford", "Robin Williams", "Kevin Costner")),
        Question("Quel film est célèbre pour la réplique 'May the Force be with you'?", "Star Wars", listOf("Star Wars", "Star Trek", "Blade Runner", "The Matrix")),
        Question("Qui a réalisé le film 'Jaws'?", "Steven Spielberg", listOf("Steven Spielberg", "George Lucas", "James Cameron", "Alfred Hitchcock")),
        Question("Quel est le nom du premier film de la série 'Indiana Jones'?", "Raiders of the Lost Ark", listOf("Raiders of the Lost Ark", "Temple of Doom", "Last Crusade", "Kingdom of the Crystal Skull")),
        Question("Quel film a pour personnage principal un robot nommé WALL-E?", "WALL-E", listOf("WALL-E", "Ratatouille", "Finding Nemo", "Up")),
        Question("Quel film d'animation met en scène une famille de super-héros?", "The Incredibles", listOf("The Incredibles", "Toy Story", "Monsters, Inc.", "Finding Nemo")),
        Question("Qui a joué le rôle principal dans le film 'Gladiator'?", "Russell Crowe", listOf("Russell Crowe", "Brad Pitt", "Tom Cruise", "Joaquin Phoenix")),
        Question("Quel film est basé sur les romans de J.R.R. Tolkien?", "The Lord of the Rings", listOf("The Lord of the Rings", "Harry Potter", "The Chronicles of Narnia", "Percy Jackson")),
        Question("Quel film de science-fiction met en scène des machines appelées 'Terminators'?", "The Terminator", listOf("The Terminator", "The Matrix", "Blade Runner", "RoboCop")),
        Question("Quel film a pour personnage principal un homme nommé Neo?", "The Matrix", listOf("The Matrix", "John Wick", "Constantine", "Point Break")),
        Question("Quel film d'animation raconte l'histoire d'une fourmi nommée Flik?", "A Bug's Life", listOf("A Bug's Life", "Antz", "Finding Nemo", "Ratatouille")),
        Question("Quel film de Quentin Tarantino met en scène un mariage interrompu par une fusillade?", "Kill Bill", listOf("Kill Bill", "Pulp Fiction", "Reservoir Dogs", "Django Unchained"))
    )

    private fun sportQuestions() = listOf(
        Question("Quel pays a remporté la Coupe du Monde de football en 2018?", "France", listOf("France", "Brésil", "Allemagne", "Argentine")),
        Question("Combien de points faut-il pour gagner un set au tennis?", "6", listOf("6", "5", "7", "8")),
        Question("Qui est le recordman du monde du 100 mètres en athlétisme?", "Usain Bolt", listOf("Usain Bolt", "Tyson Gay", "Yohan Blake", "Justin Gatlin")),
        Question("Quel joueur de basketball est surnommé 'King James'?", "LeBron James", listOf("LeBron James", "Michael Jordan", "Kobe Bryant", "Kevin Durant")),
        Question("Quel pays a remporté le plus de médailles aux Jeux Olympiques d'été?", "USA", listOf("USA", "Chine", "Russie", "Grande-Bretagne")),
        Question("Quel joueur de tennis a remporté le plus de titres du Grand Chelem?", "Roger Federer", listOf("Roger Federer", "Rafael Nadal", "Novak Djokovic", "Pete Sampras")),
        Question("Quelle équipe de football américain a remporté le plus de Super Bowls?", "New England Patriots", listOf("New England Patriots", "Pittsburgh Steelers", "Dallas Cowboys", "San Francisco 49ers")),
        Question("Quel joueur de football a remporté le plus de Ballon d'Or?", "Lionel Messi", listOf("Lionel Messi", "Cristiano Ronaldo", "Michel Platini", "Johan Cruyff")),
        Question("Quel boxeur est surnommé 'The Greatest'?", "Muhammad Ali", listOf("Muhammad Ali", "Mike Tyson", "Floyd Mayweather", "Joe Frazier")),
        Question("Quel pays a accueilli les Jeux Olympiques d'été en 2016?", "Brésil", listOf("Brésil", "Chine", "Grande-Bretagne", "Grèce")),
        Question("Quel est le sport national du Japon?", "Sumo", listOf("Sumo", "Judo", "Kendo", "Karate")),
        Question("Quel joueur de cricket détient le record du plus grand nombre de runs en Test cricket?", "Sachin Tendulkar", listOf("Sachin Tendulkar", "Brian Lara", "Ricky Ponting", "Jacques Kallis")),
        Question("Quel athlète a remporté le plus de médailles d'or olympiques?", "Michael Phelps", listOf("Michael Phelps", "Usain Bolt", "Carl Lewis", "Mark Spitz")),
        Question("Quel pays a remporté la Coupe du Monde de rugby en 2019?", "Afrique du Sud", listOf("Afrique du Sud", "Nouvelle-Zélande", "Angleterre", "Australie")),
        Question("Quel joueur de baseball est surnommé 'The Sultan of Swat'?", "Babe Ruth", listOf("Babe Ruth", "Hank Aaron", "Willie Mays", "Barry Bonds")),
        Question("Quel pays a remporté le plus de Coupes Davis en tennis?", "USA", listOf("USA", "Australie", "France", "Espagne")),
        Question("Quel joueur de golf a remporté le plus de tournois majeurs?", "Jack Nicklaus", listOf("Jack Nicklaus", "Tiger Woods", "Arnold Palmer", "Gary Player")),
        Question("Quel pays est célèbre pour le hockey sur glace?", "Canada", listOf("Canada", "Russie", "Suède", "USA")),
        Question("Quel pilote de Formule 1 détient le record du plus grand nombre de victoires?", "Lewis Hamilton", listOf("Lewis Hamilton", "Michael Schumacher", "Sebastian Vettel", "Ayrton Senna"))
    )

    private fun mathQuestions() = listOf(
        Question("Quel est le nombre premier suivant après 7?", "11", listOf("11", "9", "10", "12")),
        Question("Quelle est la valeur de Pi approximée à deux décimales?", "3.14", listOf("3.14", "3.15", "3.13", "3.16")),
        Question("Combien de côtés a un hexagone?", "6", listOf("6", "5", "7", "8")),
        Question("Combien de faces a un dodécaèdre?", "12", listOf("12", "10", "14", "20")),
        Question("Quelle est la solution de l'équation 2x + 3 = 7?", "2", listOf("2", "3", "1", "4")),
        Question("Quelle est la dérivée de x^2?", "2x", listOf("2x", "x", "x^2", "2x^2")),
        Question("Quel est le nom du plus grand triangle dans un triangle rectangle?", "Hypoténuse", listOf("Hypoténuse", "Côté adjacent", "Côté opposé", "Médiatrice")),
        Question("Combien de zéros y a-t-il dans le nombre un million?", "6", listOf("6", "5", "7", "8")),
        Question("Quelle est la formule de l'aire d'un cercle?", "Pi * r^2", listOf("Pi * r^2", "2 * Pi * r", "Pi * r", "Pi * d")),
        Question("Quel est le résultat de 3! (factorielle de 3)?", "6", listOf("6", "3", "9", "12")),
        Question("Quelle est la valeur de l'angle droit en degrés?", "90", listOf("90", "45", "60", "120")),
        Question("Quelle est la somme des angles d'un triangle?", "180", listOf("180", "90", "360", "270")),
        Question("Quel est le nom du point où les axes de coordonnées se rencontrent?", "Origine", listOf("Origine", "Médiane", "Centre", "Apogée")),
        Question("Quelle est la formule de la distance entre deux points (x1, y1) et (x2, y2)?", "√((x2-x1)^2 + (y2-y1)^2)", listOf("√((x2-x1)^2 + (y2-y1)^2)", "x2 - x1 + y2 - y1", "(x2-x1) + (y2-y1)", "√((x2-x1) + (y2-y1))")),
        Question("Quel est le nombre d'or?", "1.618", listOf("1.618", "3.14", "2.718", "1.414")),
        Question("Quel est le carré de 15?", "225", listOf("225", "250", "200", "230")),
        Question("Quel est le logarithme de 1?", "0", listOf("0", "1", "-1", "∞")),
        Question("Quelle est la somme des chiffres de 123?", "6", listOf("6", "5", "7", "8")),
        Question("Combien de solutions l'équation quadratique x^2 + 1 = 0 a-t-elle?", "Aucune", listOf("Aucune", "Une", "Deux", "Trois"))
    )

    private fun musicQuestions() = listOf(
        Question("Quel groupe a chanté 'Bohemian Rhapsody'?", "Queen", listOf("Queen", "The Beatles", "Led Zeppelin", "Pink Floyd")),
        Question("Qui est surnommé le 'Roi de la Pop'?", "Michael Jackson", listOf("Michael Jackson", "Elvis Presley", "Prince", "Madonna")),
        Question("Quel est le nom de l'album le plus vendu de tous les temps?", "Thriller", listOf("Thriller", "Back in Black", "The Dark Side of the Moon", "The Wall")),
        Question("Quel chanteur est connu pour sa chanson 'Purple Rain'?", "Prince", listOf("Prince", "Michael Jackson", "David Bowie", "Freddie Mercury")),
        Question("Quel groupe a composé 'Hotel California'?", "Eagles", listOf("Eagles", "Fleetwood Mac", "The Doors", "The Rolling Stones")),
        Question("Quel artiste est surnommé 'The Boss'?", "Bruce Springsteen", listOf("Bruce Springsteen", "Billy Joel", "Bob Dylan", "Elton John")),
        Question("Quel groupe a chanté 'Stairway to Heaven'?", "Led Zeppelin", listOf("Led Zeppelin", "Queen", "The Who", "Pink Floyd")),
        Question("Quel chanteur est connu pour ses mouvements de danse 'Moonwalk'?", "Michael Jackson", listOf("Michael Jackson", "James Brown", "Fred Astaire", "Gene Kelly")),
        Question("Quel groupe a composé 'Smells Like Teen Spirit'?", "Nirvana", listOf("Nirvana", "Pearl Jam", "Soundgarden", "Alice in Chains")),
        Question("Quel artiste est connu pour son album 'Born to Run'?", "Bruce Springsteen", listOf("Bruce Springsteen", "Tom Petty", "John Mellencamp", "Bob Seger")),
        Question("Quel groupe a chanté 'Hey Jude'?", "The Beatles", listOf("The Beatles", "The Rolling Stones", "The Kinks", "The Animals")),
        Question("Quel chanteur a popularisé la chanson 'My Way'?", "Frank Sinatra", listOf("Frank Sinatra", "Elvis Presley", "Tony Bennett", "Dean Martin")),
        Question("Quel groupe a composé 'Bohemian Rhapsody'?", "Queen", listOf("Queen", "The Beatles", "Led Zeppelin", "Pink Floyd")),
        Question("Quel artiste est connu pour sa chanson 'Imagine'?", "John Lennon", listOf("John Lennon", "Paul McCartney", "George Harrison", "Ringo Starr")),
        Question("Quel groupe a chanté 'Wonderwall'?", "Oasis", listOf("Oasis", "Blur", "Pulp", "Radiohead")),
        Question("Quel chanteur a popularisé la chanson 'Like a Rolling Stone'?", "Bob Dylan", listOf("Bob Dylan", "Bruce Springsteen", "Neil Young", "Eric Clapton")),
        Question("Quel groupe est connu pour la chanson 'Sweet Child O' Mine'?", "Guns N' Roses", listOf("Guns N' Roses", "Metallica", "Bon Jovi", "Def Leppard")),
        Question("Quel artiste est connu pour l'album 'The Wall'?", "Pink Floyd", listOf("Pink Floyd", "Led Zeppelin", "The Who", "The Rolling Stones")),
        Question("Quel chanteur a popularisé la chanson 'Suspicious Minds'?", "Elvis Presley", listOf("Elvis Presley", "Johnny Cash", "Roy Orbison", "Buddy Holly"))
    )

    private fun showNextQuestion() {
        if (currentQuestionIndex >= questions.size) {
//            showScore()
            return
        }

        val question = questions[currentQuestionIndex]
        val questionTextView = findViewById<TextView>(R.id.questionTextView)
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
                if (answer == question.correctAnswer) {
                    correctAnswers++
                } else {
                    wrongAnswers++
                }
                updateScore()
                showNextQuestion()
            }
        }

        currentQuestionIndex++
    }

    private fun updateScore() {
        correctAnswersTextView.text = "Correct: $correctAnswers"
        wrongAnswersTextView.text = "Wrong: $wrongAnswers"
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
