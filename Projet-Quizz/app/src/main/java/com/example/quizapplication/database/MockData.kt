package com.example.quizapplication.database

import com.example.quizapplication.Answer
import com.example.quizapplication.Category
import com.example.quizapplication.Question
import com.example.quizapplication.QuizRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MockData(private val quizRepository: QuizRepository) {

    fun populateDatabase() {
        CoroutineScope(Dispatchers.IO).launch {
            val categories = listOf(
                Category(name = "videoGames"),
                Category(name = "cinema"),
                Category(name = "sport"),
                Category(name = "maths"),
                Category(name = "music"),
                Category(name = "history")
            )
            quizRepository.insertCategories(categories)

            val videoGamesQuestions = listOf(
                Question(
                    categoryId = 1,
                    text = "Quelle année est sorti le premier jeu de la série 'The Legend of Zelda'?",
                    correctAnswer = "1986"
                ),
                Question(
                    categoryId = 1,
                    text = "Qui est le créateur de la série de jeux 'Super Mario'?",
                    correctAnswer = "Shigeru Miyamoto"
                ),
                Question(
                    categoryId = 1,
                    text = "Dans quel jeu vidéo trouve-t-on le personnage de Lara Croft?",
                    correctAnswer = "Tomb Raider"
                ),
                Question(
                    categoryId = 1,
                    text = "Quel est le jeu vidéo le plus vendu de tous les temps?",
                    correctAnswer = "Minecraft"
                ),
                Question(
                    categoryId = 1,
                    text = "En quelle année est sorti le premier jeu 'Call of Duty'?",
                    correctAnswer = "2003"
                ),
                Question(
                    categoryId = 1,
                    text = "Quel est le studio de développement derrière 'The Witcher 3'?",
                    correctAnswer = "CD Projekt Red"
                ),
                Question(
                    categoryId = 1,
                    text = "Quel est le nom du protagoniste dans 'Halo'?",
                    correctAnswer = "Master Chief"
                ),
                Question(
                    categoryId = 1,
                    text = "Quelle console a été la première à utiliser des CD-ROM?",
                    correctAnswer = "PlayStation"
                ),
                Question(
                    categoryId = 1,
                    text = "Qui est l'éditeur du jeu 'Fortnite'?",
                    correctAnswer = "Epic Games"
                ),
                Question(
                    categoryId = 1,
                    text = "Quel jeu vidéo a popularisé le genre Battle Royale?",
                    correctAnswer = "PUBG"
                ),
                Question(
                    categoryId = 1,
                    text = "Quel personnage de jeu vidéo est célèbre pour ses aventures dans 'Hyrule'?",
                    correctAnswer = "Link"
                ),
                Question(
                    categoryId = 1,
                    text = "Quel est le principal antagoniste dans 'Final Fantasy VII'?",
                    correctAnswer = "Sephiroth"
                ),
                Question(
                    categoryId = 1,
                    text = "Quel jeu vidéo se déroule dans la ville fictive de 'Vice City'?",
                    correctAnswer = "GTA Vice City"
                ),
                Question(
                    categoryId = 1,
                    text = "Quel est le nom du compagnon de Sonic?",
                    correctAnswer = "Tails"
                ),
                Question(
                    categoryId = 1,
                    text = "Quel jeu de combat met en scène des personnages comme Ryu et Ken?",
                    correctAnswer = "Street Fighter"
                ),
                Question(
                    categoryId = 1,
                    text = "Quelle est la première console de jeux vidéo de Nintendo?",
                    correctAnswer = "Nintendo NES"
                ),
                Question(
                    categoryId = 1,
                    text = "Quel jeu met en scène un plombier essayant de sauver une princesse?",
                    correctAnswer = "Super Mario Bros"
                ),
                Question(
                    categoryId = 1,
                    text = "Quel est le personnage principal de 'Metal Gear Solid'?",
                    correctAnswer = "Solid Snake"
                ),
                Question(
                    categoryId = 1,
                    text = "Quel est le jeu vidéo le plus vendu sur la Nintendo Switch?",
                    correctAnswer = "Mario Kart 8 Deluxe"
                )
            )
            quizRepository.insertQuestions(videoGamesQuestions)

            val videoGamesAnswers = listOf(
                Answer(questionId = 1, text = "1986"),
                Answer(questionId = 1, text = "1985"),
                Answer(questionId = 1, text = "1987"),
                Answer(questionId = 1, text = "1988"),
                Answer(questionId = 2, text = "Shigeru Miyamoto"),
                Answer(questionId = 2, text = "Hideo Kojima"),
                Answer(questionId = 2, text = "Yu Suzuki"),
                Answer(questionId = 2, text = "Satoru Iwata"),
                Answer(questionId = 3, text = "Tomb Raider"),
                Answer(questionId = 3, text = "Uncharted"),
                Answer(questionId = 3, text = "The Last of Us"),
                Answer(questionId = 3, text = "Resident Evil"),
                Answer(questionId = 4, text = "Minecraft"),
                Answer(questionId = 4, text = "Tetris"),
                Answer(questionId = 4, text = "GTA V"),
                Answer(questionId = 4, text = "Fortnite"),
                Answer(questionId = 5, text = "2003"),
                Answer(questionId = 5, text = "2001"),
                Answer(questionId = 5, text = "2005"),
                Answer(questionId = 5, text = "2007"),
                Answer(questionId = 6, text = "CD Projekt Red"),
                Answer(questionId = 6, text = "Ubisoft"),
                Answer(questionId = 6, text = "EA"),
                Answer(questionId = 6, text = "Rockstar Games"),
                Answer(questionId = 7, text = "Master Chief"),
                Answer(questionId = 7, text = "Marcus Fenix"),
                Answer(questionId = 7, text = "Kratos"),
                Answer(questionId = 7, text = "Nathan Drake"),
                Answer(questionId = 8, text = "PlayStation"),
                Answer(questionId = 8, text = "Sega Saturn"),
                Answer(questionId = 8, text = "Nintendo 64"),
                Answer(questionId = 8, text = "Dreamcast"),
                Answer(questionId = 9, text = "Epic Games"),
                Answer(questionId = 9, text = "Activision"),
                Answer(questionId = 9, text = "EA"),
                Answer(questionId = 9, text = "Ubisoft"),
                Answer(questionId = 10, text = "PUBG"),
                Answer(questionId = 10, text = "Fortnite"),
                Answer(questionId = 10, text = "Apex Legends"),
                Answer(questionId = 10, text = "Call of Duty: Warzone"),
                Answer(questionId = 11, text = "Link"),
                Answer(questionId = 11, text = "Mario"),
                Answer(questionId = 11, text = "Sonic"),
                Answer(questionId = 11, text = "Samus"),
                Answer(questionId = 12, text = "Sephiroth"),
                Answer(questionId = 12, text = "Kefka"),
                Answer(questionId = 12, text = "Ultimecia"),
                Answer(questionId = 12, text = "Sin"),
                Answer(questionId = 13, text = "GTA Vice City"),
                Answer(questionId = 13, text = "GTA San Andreas"),
                Answer(questionId = 13, text = "GTA III"),
                Answer(questionId = 13, text = "GTA IV"),
                Answer(questionId = 14, text = "Tails"),
                Answer(questionId = 14, text = "Knuckles"),
                Answer(questionId = 14, text = "Shadow"),
                Answer(questionId = 14, text = "Amy"),
                Answer(questionId = 15, text = "Street Fighter"),
                Answer(questionId = 15, text = "Mortal Kombat"),
                Answer(questionId = 15, text = "Tekken"),
                Answer(questionId = 15, text = "Soul Calibur"),
                Answer(questionId = 16, text = "Nintendo NES"),
                Answer(questionId = 16, text = "Super Nintendo"),
                Answer(questionId = 16, text = "Nintendo 64"),
                Answer(questionId = 16, text = "GameCube"),
                Answer(questionId = 17, text = "Super Mario Bros"),
                Answer(questionId = 17, text = "Donkey Kong"),
                Answer(questionId = 17, text = "The Legend of Zelda"),
                Answer(questionId = 17, text = "Metroid"),
                Answer(questionId = 18, text = "Solid Snake"),
                Answer(questionId = 18, text = "Big Boss"),
                Answer(questionId = 18, text = "Liquid Snake"),
                Answer(questionId = 18, text = "Raiden"),
                Answer(questionId = 19, text = "Mario Kart 8 Deluxe"),
                Answer(questionId = 19, text = "The Legend of Zelda: Breath of the Wild"),
                Answer(questionId = 19, text = "Super Mario Odyssey"),
                Answer(questionId = 19, text = "Animal Crossing: New Horizons")
            )
            quizRepository.insertAnswers(videoGamesAnswers)

            val cinemaQuestions = listOf(
                Question(
                    categoryId = 2,
                    text = "Qui a réalisé le film 'Inception'?",
                    correctAnswer = "Christopher Nolan"
                ),
                Question(
                    categoryId = 2,
                    text = "Quel acteur joue le personnage de Jack Dawson dans 'Titanic'?",
                    correctAnswer = "Leonardo DiCaprio"
                ),
                Question(
                    categoryId = 2,
                    text = "En quelle année est sorti le premier film de la saga 'Harry Potter'?",
                    correctAnswer = "2001"
                ),
                Question(
                    categoryId = 2,
                    text = "Qui a joué le rôle de 'Joker' dans 'The Dark Knight'?",
                    correctAnswer = "Heath Ledger"
                ),
                Question(
                    categoryId = 2,
                    text = "Quel film a remporté l'Oscar du meilleur film en 2020?",
                    correctAnswer = "Parasite"
                ),
                Question(
                    categoryId = 2,
                    text = "Qui a réalisé le film 'Pulp Fiction'?",
                    correctAnswer = "Quentin Tarantino"
                ),
                Question(
                    categoryId = 2,
                    text = "Quel film met en scène un groupe de super-héros appelés 'The Avengers'?",
                    correctAnswer = "The Avengers"
                ),
                Question(
                    categoryId = 2,
                    text = "Quel acteur a joué le rôle principal dans 'Forrest Gump'?",
                    correctAnswer = "Tom Hanks"
                ),
                Question(
                    categoryId = 2,
                    text = "Quel film est célèbre pour la réplique 'May the Force be with you'?",
                    correctAnswer = "Star Wars"
                ),
                Question(
                    categoryId = 2,
                    text = "Qui a réalisé le film 'Jaws'?",
                    correctAnswer = "Steven Spielberg"
                ),
                Question(
                    categoryId = 2,
                    text = "Quel est le nom du premier film de la série 'Indiana Jones'?",
                    correctAnswer = "Raiders of the Lost Ark"
                ),
                Question(
                    categoryId = 2,
                    text = "Quel film a pour personnage principal un robot nommé WALL-E?",
                    correctAnswer = "WALL-E"
                ),
                Question(
                    categoryId = 2,
                    text = "Quel film d'animation met en scène une famille de super-héros?",
                    correctAnswer = "The Incredibles"
                ),
                Question(
                    categoryId = 2,
                    text = "Qui a joué le rôle principal dans le film 'Gladiator'?",
                    correctAnswer = "Russell Crowe"
                ),
                Question(
                    categoryId = 2,
                    text = "Quel film est basé sur les romans de J.R.R. Tolkien?",
                    correctAnswer = "The Lord of the Rings"
                ),
                Question(
                    categoryId = 2,
                    text = "Quel film de science-fiction met en scène des machines appelées 'Terminators'?",
                    correctAnswer = "The Terminator"
                ),
                Question(
                    categoryId = 2,
                    text = "Quel film a pour personnage principal un homme nommé Neo?",
                    correctAnswer = "The Matrix"
                ),
                Question(
                    categoryId = 2,
                    text = "Quel film d'animation raconte l'histoire d'une fourmi nommée Flik?",
                    correctAnswer = "A Bug's Life"
                ),
                Question(
                    categoryId = 2,
                    text = "Quel film de Quentin Tarantino met en scène un mariage interrompu par une fusillade?",
                    correctAnswer = "Kill Bill"
                )
            )
            quizRepository.insertQuestions(cinemaQuestions)

            val cinemaAnswers = listOf(
                Answer(questionId = 20, text = "Christopher Nolan"),
                Answer(questionId = 20, text = "Steven Spielberg"),
                Answer(questionId = 20, text = "James Cameron"),
                Answer(questionId = 20, text = "Quentin Tarantino"),
                Answer(questionId = 21, text = "Leonardo DiCaprio"),
                Answer(questionId = 21, text = "Brad Pitt"),
                Answer(questionId = 21, text = "Johnny Depp"),
                Answer(questionId = 21, text = "Tom Hanks"),
                Answer(questionId = 22, text = "2001"),
                Answer(questionId = 22, text = "2000"),
                Answer(questionId = 22, text = "2002"),
                Answer(questionId = 22, text = "1999"),
                Answer(questionId = 23, text = "Heath Ledger"),
                Answer(questionId = 23, text = "Joaquin Phoenix"),
                Answer(questionId = 23, text = "Jack Nicholson"),
                Answer(questionId = 23, text = "Jared Leto"),
                Answer(questionId = 24, text = "Parasite"),
                Answer(questionId = 24, text = "1917"),
                Answer(questionId = 24, text = "Joker"),
                Answer(questionId = 24, text = "Once Upon a Time in Hollywood"),
                Answer(questionId = 25, text = "Quentin Tarantino"),
                Answer(questionId = 25, text = "Martin Scorsese"),
                Answer(questionId = 25, text = "Francis Ford Coppola"),
                Answer(questionId = 25, text = "Ridley Scott"),
                Answer(questionId = 26, text = "The Avengers"),
                Answer(questionId = 26, text = "Justice League"),
                Answer(questionId = 26, text = "X-Men"),
                Answer(questionId = 26, text = "Fantastic Four"),
                Answer(questionId = 27, text = "Tom Hanks"),
                Answer(questionId = 27, text = "Robert Redford"),
                Answer(questionId = 27, text = "Robin Williams"),
                Answer(questionId = 27, text = "Kevin Costner"),
                Answer(questionId = 28, text = "Star Wars"),
                Answer(questionId = 28, text = "Star Trek"),
                Answer(questionId = 28, text = "Blade Runner"),
                Answer(questionId = 28, text = "The Matrix"),
                Answer(questionId = 29, text = "Steven Spielberg"),
                Answer(questionId = 29, text = "George Lucas"),
                Answer(questionId = 29, text = "James Cameron"),
                Answer(questionId = 29, text = "Alfred Hitchcock"),
                Answer(questionId = 30, text = "Raiders of the Lost Ark"),
                Answer(questionId = 30, text = "Temple of Doom"),
                Answer(questionId = 30, text = "Last Crusade"),
                Answer(questionId = 30, text = "Kingdom of the Crystal Skull"),
                Answer(questionId = 31, text = "WALL-E"),
                Answer(questionId = 31, text = "Ratatouille"),
                Answer(questionId = 31, text = "Finding Nemo"),
                Answer(questionId = 31, text = "Up"),
                Answer(questionId = 32, text = "The Incredibles"),
                Answer(questionId = 32, text = "Toy Story"),
                Answer(questionId = 32, text = "Monsters, Inc."),
                Answer(questionId = 32, text = "Finding Nemo"),
                Answer(questionId = 33, text = "Russell Crowe"),
                Answer(questionId = 33, text = "Brad Pitt"),
                Answer(questionId = 33, text = "Tom Cruise"),
                Answer(questionId = 33, text = "Joaquin Phoenix"),
                Answer(questionId = 34, text = "The Lord of the Rings"),
                Answer(questionId = 34, text = "Harry Potter"),
                Answer(questionId = 34, text = "The Chronicles of Narnia"),
                Answer(questionId = 34, text = "Percy Jackson"),
                Answer(questionId = 35, text = "The Terminator"),
                Answer(questionId = 35, text = "The Matrix"),
                Answer(questionId = 35, text = "Blade Runner"),
                Answer(questionId = 35, text = "RoboCop"),
                Answer(questionId = 36, text = "The Matrix"),
                Answer(questionId = 36, text = "John Wick"),
                Answer(questionId = 36, text = "Constantine"),
                Answer(questionId = 36, text = "Point Break"),
                Answer(questionId = 37, text = "A Bug's Life"),
                Answer(questionId = 37, text = "Antz"),
                Answer(questionId = 37, text = "Finding Nemo"),
                Answer(questionId = 37, text = "Ratatouille"),
                Answer(questionId = 38, text = "Kill Bill"),
                Answer(questionId = 38, text = "Pulp Fiction"),
                Answer(questionId = 38, text = "Reservoir Dogs"),
                Answer(questionId = 38, text = "Django Unchained")
            )
            quizRepository.insertAnswers(cinemaAnswers)

            val sportQuestions = listOf(
                Question(
                    categoryId = 3,
                    text = "Quel pays a remporté la Coupe du Monde de football en 2018?",
                    correctAnswer = "France"
                ),
                Question(
                    categoryId = 3,
                    text = "Combien de points faut-il pour gagner un set au tennis?",
                    correctAnswer = "6"
                ),
                Question(
                    categoryId = 3,
                    text = "Qui est le recordman du monde du 100 mètres en athlétisme?",
                    correctAnswer = "Usain Bolt"
                ),
                Question(
                    categoryId = 3,
                    text = "Quel joueur de basketball est surnommé 'King James'?",
                    correctAnswer = "LeBron James"
                ),
                Question(
                    categoryId = 3,
                    text = "Quel pays a remporté le plus de médailles aux Jeux Olympiques d'été?",
                    correctAnswer = "USA"
                ),
                Question(
                    categoryId = 3,
                    text = "Quel joueur de tennis a remporté le plus de titres du Grand Chelem?",
                    correctAnswer = "Roger Federer"
                ),
                Question(
                    categoryId = 3,
                    text = "Quelle équipe de football américain a remporté le plus de Super Bowls?",
                    correctAnswer = "New England Patriots"
                ),
                Question(
                    categoryId = 3,
                    text = "Quel joueur de football a remporté le plus de Ballon d'Or?",
                    correctAnswer = "Lionel Messi"
                ),
                Question(
                    categoryId = 3,
                    text = "Quel boxeur est surnommé 'The Greatest'?",
                    correctAnswer = "Muhammad Ali"
                ),
                Question(
                    categoryId = 3,
                    text = "Quel pays a accueilli les Jeux Olympiques d'été en 2016?",
                    correctAnswer = "Brésil"
                ),
                Question(
                    categoryId = 3,
                    text = "Quel est le sport national du Japon?",
                    correctAnswer = "Sumo"
                ),
                Question(
                    categoryId = 3,
                    text = "Quel joueur de cricket détient le record du plus grand nombre de runs en Test cricket?",
                    correctAnswer = "Sachin Tendulkar"
                ),
                Question(
                    categoryId = 3,
                    text = "Quel athlète a remporté le plus de médailles d'or olympiques?",
                    correctAnswer = "Michael Phelps"
                ),
                Question(
                    categoryId = 3,
                    text = "Quel pays a remporté la Coupe du Monde de rugby en 2019?",
                    correctAnswer = "Afrique du Sud"
                ),
                Question(
                    categoryId = 3,
                    text = "Quel joueur de baseball est surnommé 'The Sultan of Swat'?",
                    correctAnswer = "Babe Ruth"
                ),
                Question(
                    categoryId = 3,
                    text = "Quel pays a remporté le plus de Coupes Davis en tennis?",
                    correctAnswer = "USA"
                ),
                Question(
                    categoryId = 3,
                    text = "Quel joueur de golf a remporté le plus de tournois majeurs?",
                    correctAnswer = "Jack Nicklaus"
                ),
                Question(
                    categoryId = 3,
                    text = "Quel pays est célèbre pour le hockey sur glace?",
                    correctAnswer = "Canada"
                ),
                Question(
                    categoryId = 3,
                    text = "Quel pilote de Formule 1 détient le record du plus grand nombre de victoires?",
                    correctAnswer = "Lewis Hamilton"
                )
            )

            quizRepository.insertQuestions(sportQuestions)

            val sportAnswers = listOf(
                Answer(questionId = 39, text = "France"),
                Answer(questionId = 39, text = "Brésil"),
                Answer(questionId = 39, text = "Allemagne"),
                Answer(questionId = 39, text = "Argentine"),
                Answer(questionId = 40, text = "6"),
                Answer(questionId = 40, text = "5"),
                Answer(questionId = 40, text = "7"),
                Answer(questionId = 40, text = "8"),
                Answer(questionId = 41, text = "Usain Bolt"),
                Answer(questionId = 41, text = "Tyson Gay"),
                Answer(questionId = 41, text = "Yohan Blake"),
                Answer(questionId = 41, text = "Justin Gatlin"),
                Answer(questionId = 42, text = "LeBron James"),
                Answer(questionId = 42, text = "Michael Jordan"),
                Answer(questionId = 42, text = "Kobe Bryant"),
                Answer(questionId = 42, text = "Kevin Durant"),
                Answer(questionId = 43, text = "USA"),
                Answer(questionId = 43, text = "Chine"),
                Answer(questionId = 43, text = "Russie"),
                Answer(questionId = 43, text = "Grande-Bretagne"),
                Answer(questionId = 44, text = "Roger Federer"),
                Answer(questionId = 44, text = "Rafael Nadal"),
                Answer(questionId = 44, text = "Novak Djokovic"),
                Answer(questionId = 44, text = "Pete Sampras"),
                Answer(questionId = 45, text = "New England Patriots"),
                Answer(questionId = 45, text = "Pittsburgh Steelers"),
                Answer(questionId = 45, text = "Dallas Cowboys"),
                Answer(questionId = 45, text = "San Francisco 49ers"),
                Answer(questionId = 46, text = "Lionel Messi"),
                Answer(questionId = 46, text = "Cristiano Ronaldo"),
                Answer(questionId = 46, text = "Michel Platini"),
                Answer(questionId = 46, text = "Johan Cruyff"),
                Answer(questionId = 47, text = "Muhammad Ali"),
                Answer(questionId = 47, text = "Mike Tyson"),
                Answer(questionId = 47, text = "Floyd Mayweather"),
                Answer(questionId = 47, text = "Joe Frazier"),
                Answer(questionId = 48, text = "Brésil"),
                Answer(questionId = 48, text = "Chine"),
                Answer(questionId = 48, text = "Grande-Bretagne"),
                Answer(questionId = 48, text = "Grèce"),
                Answer(questionId = 49, text = "Sumo"),
                Answer(questionId = 49, text = "Judo"),
                Answer(questionId = 49, text = "Kendo"),
                Answer(questionId = 49, text = "Karate"),
                Answer(questionId = 50, text = "Sachin Tendulkar"),
                Answer(questionId = 50, text = "Brian Lara"),
                Answer(questionId = 50, text = "Ricky Ponting"),
                Answer(questionId = 50, text = "Jacques Kallis"),
                Answer(questionId = 51, text = "Michael Phelps"),
                Answer(questionId = 51, text = "Usain Bolt"),
                Answer(questionId = 51, text = "Carl Lewis"),
                Answer(questionId = 51, text = "Mark Spitz"),
                Answer(questionId = 52, text = "Afrique du Sud"),
                Answer(questionId = 52, text = "Nouvelle-Zélande"),
                Answer(questionId = 52, text = "Angleterre"),
                Answer(questionId = 52, text = "Australie"),
                Answer(questionId = 53, text = "Babe Ruth"),
                Answer(questionId = 53, text = "Hank Aaron"),
                Answer(questionId = 53, text = "Willie Mays"),
                Answer(questionId = 53, text = "Barry Bonds"),
                Answer(questionId = 54, text = "USA"),
                Answer(questionId = 54, text = "Australie"),
                Answer(questionId = 54, text = "France"),
                Answer(questionId = 54, text = "Espagne"),
                Answer(questionId = 55, text = "Jack Nicklaus"),
                Answer(questionId = 55, text = "Tiger Woods"),
                Answer(questionId = 55, text = "Arnold Palmer"),
                Answer(questionId = 55, text = "Gary Player"),
                Answer(questionId = 56, text = "Canada"),
                Answer(questionId = 56, text = "Russie"),
                Answer(questionId = 56, text = "Suède"),
                Answer(questionId = 56, text = "USA"),
                Answer(questionId = 57, text = "Lewis Hamilton"),
                Answer(questionId = 57, text = "Michael Schumacher"),
                Answer(questionId = 57, text = "Sebastian Vettel"),
                Answer(questionId = 57, text = "Ayrton Senna")
            )
            quizRepository.insertAnswers(sportAnswers)

            val mathsQuestions = listOf(
                Question(
                    categoryId = 4,
                    text = "Quel est le nombre premier suivant après 7?",
                    correctAnswer = "11"
                ),
                Question(
                    categoryId = 4,
                    text = "Quelle est la valeur de Pi approximée à deux décimales?",
                    correctAnswer = "3.14"
                ),
                Question(
                    categoryId = 4,
                    text = "Combien de côtés a un hexagone?",
                    correctAnswer = "6"
                ),
                Question(
                    categoryId = 4,
                    text = "Combien de faces a un dodécaèdre?",
                    correctAnswer = "12"
                ),
                Question(
                    categoryId = 4,
                    text = "Quelle est la solution de l'équation 2x + 3 = 7?",
                    correctAnswer = "2"
                ),
                Question(
                    categoryId = 4,
                    text = "Quelle est la dérivée de x^2?",
                    correctAnswer = "2x"
                ),
                Question(
                    categoryId = 4,
                    text = "Quel est le nom du plus grand triangle dans un triangle rectangle?",
                    correctAnswer = "Hypoténuse"
                ),
                Question(
                    categoryId = 4,
                    text = "Combien de zéros y a-t-il dans le nombre un million?",
                    correctAnswer = "6"
                ),
                Question(
                    categoryId = 4,
                    text = "Quelle est la formule de l'aire d'un cercle?",
                    correctAnswer = "Pi * r^2"
                ),
                Question(
                    categoryId = 4,
                    text = "Quel est le résultat de 3! (factorielle de 3)?",
                    correctAnswer = "6"
                ),
                Question(
                    categoryId = 4,
                    text = "Quelle est la valeur de l'angle droit en degrés?",
                    correctAnswer = "90"
                ),
                Question(
                    categoryId = 4,
                    text = "Quelle est la somme des angles d'un triangle?",
                    correctAnswer = "180"
                ),
                Question(
                    categoryId = 4,
                    text = "Quel est le nom du point où les axes de coordonnées se rencontrent?",
                    correctAnswer = "Origine"
                ),
                Question(
                    categoryId = 4,
                    text = "Quelle est la formule de la distance entre deux points (x1, y1) et (x2, y2)?",
                    correctAnswer = "√((x2-x1)^2 + (y2-y1)^2)"
                ),
                Question(
                    categoryId = 4,
                    text = "Quel est le nombre d'or?",
                    correctAnswer = "1.618"
                ),
                Question(categoryId = 4, text = "Quel est le carré de 15?", correctAnswer = "225"),
                Question(
                    categoryId = 4,
                    text = "Quel est le logarithme de 1?",
                    correctAnswer = "0"
                ),
                Question(
                    categoryId = 4,
                    text = "Quelle est la somme des chiffres de 123?",
                    correctAnswer = "6"
                ),
                Question(
                    categoryId = 4,
                    text = "Combien de solutions l'équation quadratique x^2 + 1 = 0 a-t-elle?",
                    correctAnswer = "Aucune"
                )
            )

            quizRepository.insertQuestions(mathsQuestions)

            val mathsAnswers = listOf(
                Answer(questionId = 58, text = "11"),
                Answer(questionId = 58, text = "9"),
                Answer(questionId = 58, text = "10"),
                Answer(questionId = 58, text = "12"),
                Answer(questionId = 59, text = "3.14"),
                Answer(questionId = 59, text = "3.15"),
                Answer(questionId = 59, text = "3.13"),
                Answer(questionId = 59, text = "3.16"),
                Answer(questionId = 60, text = "6"),
                Answer(questionId = 60, text = "5"),
                Answer(questionId = 60, text = "7"),
                Answer(questionId = 60, text = "8"),
                Answer(questionId = 61, text = "12"),
                Answer(questionId = 61, text = "10"),
                Answer(questionId = 61, text = "14"),
                Answer(questionId = 61, text = "20"),
                Answer(questionId = 62, text = "2"),
                Answer(questionId = 62, text = "3"),
                Answer(questionId = 62, text = "1"),
                Answer(questionId = 62, text = "4"),
                Answer(questionId = 63, text = "2x"),
                Answer(questionId = 63, text = "x"),
                Answer(questionId = 63, text = "x^2"),
                Answer(questionId = 63, text = "2x^2"),
                Answer(questionId = 64, text = "Hypoténuse"),
                Answer(questionId = 64, text = "Côté adjacent"),
                Answer(questionId = 64, text = "Côté opposé"),
                Answer(questionId = 64, text = "Médiatrice"),
                Answer(questionId = 65, text = "6"),
                Answer(questionId = 65, text = "5"),
                Answer(questionId = 65, text = "7"),
                Answer(questionId = 65, text = "8"),
                Answer(questionId = 66, text = "Pi * r^2"),
                Answer(questionId = 66, text = "2 * Pi * r"),
                Answer(questionId = 66, text = "Pi * r"),
                Answer(questionId = 66, text = "Pi * d"),
                Answer(questionId = 67, text = "6"),
                Answer(questionId = 67, text = "3"),
                Answer(questionId = 67, text = "9"),
                Answer(questionId = 67, text = "12"),
                Answer(questionId = 68, text = "90"),
                Answer(questionId = 68, text = "45"),
                Answer(questionId = 68, text = "60"),
                Answer(questionId = 68, text = "120"),
                Answer(questionId = 69, text = "180"),
                Answer(questionId = 69, text = "90"),
                Answer(questionId = 69, text = "360"),
                Answer(questionId = 69, text = "270"),
                Answer(questionId = 70, text = "Origine"),
                Answer(questionId = 70, text = "Médiane"),
                Answer(questionId = 70, text = "Centre"),
                Answer(questionId = 70, text = "Apogée"),
                Answer(questionId = 71, text = "√((x2-x1)^2 + (y2-y1)^2)"),
                Answer(questionId = 71, text = "x2 - x1 + y2 - y1"),
                Answer(questionId = 71, text = "(x2-x1) + (y2-y1)"),
                Answer(questionId = 71, text = "√((x2-x1) + (y2-y1))"),
                Answer(questionId = 72, text = "1.618"),
                Answer(questionId = 72, text = "3.14"),
                Answer(questionId = 72, text = "2.718"),
                Answer(questionId = 72, text = "1.414"),
                Answer(questionId = 73, text = "225"),
                Answer(questionId = 73, text = "250"),
                Answer(questionId = 73, text = "200"),
                Answer(questionId = 73, text = "230"),
                Answer(questionId = 74, text = "0"),
                Answer(questionId = 74, text = "1"),
                Answer(questionId = 74, text = "-1"),
                Answer(questionId = 74, text = "∞"),
                Answer(questionId = 75, text = "6"),
                Answer(questionId = 75, text = "5"),
                Answer(questionId = 75, text = "7"),
                Answer(questionId = 75, text = "8"),
                Answer(questionId = 76, text = "Aucune"),
                Answer(questionId = 76, text = "Une"),
                Answer(questionId = 76, text = "Deux"),
                Answer(questionId = 76, text = "Trois")
            )
            quizRepository.insertAnswers(mathsAnswers)

            val musicQuestions = listOf(
                Question(
                    categoryId = 5,
                    text = "Quel groupe a chanté 'Bohemian Rhapsody'?",
                    correctAnswer = "Queen"
                ),
                Question(
                    categoryId = 5,
                    text = "Qui est surnommé le 'Roi de la Pop'?",
                    correctAnswer = "Michael Jackson"
                ),
                Question(
                    categoryId = 5,
                    text = "Quel est le nom de l'album le plus vendu de tous les temps?",
                    correctAnswer = "Thriller"
                ),
                Question(
                    categoryId = 5,
                    text = "Quel chanteur est connu pour sa chanson 'Purple Rain'?",
                    correctAnswer = "Prince"
                ),
                Question(
                    categoryId = 5,
                    text = "Quel groupe a composé 'Hotel California'?",
                    correctAnswer = "Eagles"
                ),
                Question(
                    categoryId = 5,
                    text = "Quel artiste est surnommé 'The Boss'?",
                    correctAnswer = "Bruce Springsteen"
                ),
                Question(
                    categoryId = 5,
                    text = "Quel groupe a chanté 'Stairway to Heaven'?",
                    correctAnswer = "Led Zeppelin"
                ),
                Question(
                    categoryId = 5,
                    text = "Quel chanteur est connu pour ses mouvements de danse 'Moonwalk'?",
                    correctAnswer = "Michael Jackson"
                ),
                Question(
                    categoryId = 5,
                    text = "Quel groupe a composé 'Smells Like Teen Spirit'?",
                    correctAnswer = "Nirvana"
                ),
                Question(
                    categoryId = 5,
                    text = "Quel artiste est connu pour son album 'Born to Run'?",
                    correctAnswer = "Bruce Springsteen"
                ),
                Question(
                    categoryId = 5,
                    text = "Quel groupe a chanté 'Hey Jude'?",
                    correctAnswer = "The Beatles"
                ),
                Question(
                    categoryId = 5,
                    text = "Quel chanteur a popularisé la chanson 'My Way'?",
                    correctAnswer = "Frank Sinatra"
                ),
                Question(
                    categoryId = 5,
                    text = "Quel artiste est connu pour sa chanson 'Imagine'?",
                    correctAnswer = "John Lennon"
                ),
                Question(
                    categoryId = 5,
                    text = "Quel groupe a chanté 'Wonderwall'?",
                    correctAnswer = "Oasis"
                ),
                Question(
                    categoryId = 5,
                    text = "Quel chanteur a popularisé la chanson 'Like a Rolling Stone'?",
                    correctAnswer = "Bob Dylan"
                ),
                Question(
                    categoryId = 5,
                    text = "Quel groupe est connu pour la chanson 'Sweet Child O' Mine'?",
                    correctAnswer = "Guns N' Roses"
                ),
                Question(
                    categoryId = 5,
                    text = "Quel artiste est connu pour l'album 'The Wall'?",
                    correctAnswer = "Pink Floyd"
                ),
                Question(
                    categoryId = 5,
                    text = "Quel chanteur a popularisé la chanson 'Suspicious Minds'?",
                    correctAnswer = "Elvis Presley"
                )
            )

            quizRepository.insertQuestions(musicQuestions)

            val musicAnswers = listOf(
                Answer(questionId = 77, text = "Queen"),
                Answer(questionId = 77, text = "The Beatles"),
                Answer(questionId = 77, text = "Led Zeppelin"),
                Answer(questionId = 77, text = "Pink Floyd"),
                Answer(questionId = 78, text = "Michael Jackson"),
                Answer(questionId = 78, text = "Elvis Presley"),
                Answer(questionId = 78, text = "Prince"),
                Answer(questionId = 78, text = "Madonna"),
                Answer(questionId = 79, text = "Thriller"),
                Answer(questionId = 79, text = "Back in Black"),
                Answer(questionId = 79, text = "The Dark Side of the Moon"),
                Answer(questionId = 79, text = "The Wall"),
                Answer(questionId = 80, text = "Prince"),
                Answer(questionId = 80, text = "Michael Jackson"),
                Answer(questionId = 80, text = "David Bowie"),
                Answer(questionId = 80, text = "Freddie Mercury"),
                Answer(questionId = 81, text = "Eagles"),
                Answer(questionId = 81, text = "Fleetwood Mac"),
                Answer(questionId = 81, text = "The Doors"),
                Answer(questionId = 81, text = "The Rolling Stones"),
                Answer(questionId = 82, text = "Bruce Springsteen"),
                Answer(questionId = 82, text = "Billy Joel"),
                Answer(questionId = 82, text = "Bob Dylan"),
                Answer(questionId = 82, text = "Elton John"),
                Answer(questionId = 83, text = "Led Zeppelin"),
                Answer(questionId = 83, text = "Queen"),
                Answer(questionId = 83, text = "The Who"),
                Answer(questionId = 83, text = "Pink Floyd"),
                Answer(questionId = 84, text = "Michael Jackson"),
                Answer(questionId = 84, text = "James Brown"),
                Answer(questionId = 84, text = "Fred Astaire"),
                Answer(questionId = 84, text = "Gene Kelly"),
                Answer(questionId = 85, text = "Nirvana"),
                Answer(questionId = 85, text = "Pearl Jam"),
                Answer(questionId = 85, text = "Soundgarden"),
                Answer(questionId = 85, text = "Alice in Chains"),
                Answer(questionId = 86, text = "Bruce Springsteen"),
                Answer(questionId = 86, text = "Tom Petty"),
                Answer(questionId = 86, text = "John Mellencamp"),
                Answer(questionId = 86, text = "Bob Seger"),
                Answer(questionId = 87, text = "The Beatles"),
                Answer(questionId = 87, text = "The Rolling Stones"),
                Answer(questionId = 87, text = "The Kinks"),
                Answer(questionId = 87, text = "The Animals"),
                Answer(questionId = 88, text = "Frank Sinatra"),
                Answer(questionId = 88, text = "Elvis Presley"),
                Answer(questionId = 88, text = "Tony Bennett"),
                Answer(questionId = 88, text = "Dean Martin"),
                Answer(questionId = 89, text = "John Lennon"),
                Answer(questionId = 89, text = "Paul McCartney"),
                Answer(questionId = 89, text = "George Harrison"),
                Answer(questionId = 89, text = "Ringo Starr"),
                Answer(questionId = 90, text = "Oasis"),
                Answer(questionId = 90, text = "Blur"),
                Answer(questionId = 90, text = "Pulp"),
                Answer(questionId = 90, text = "Radiohead"),
                Answer(questionId = 91, text = "Bob Dylan"),
                Answer(questionId = 91, text = "Bruce Springsteen"),
                Answer(questionId = 91, text = "Neil Young"),
                Answer(questionId = 91, text = "Eric Clapton"),
                Answer(questionId = 92, text = "Guns N' Roses"),
                Answer(questionId = 92, text = "Metallica"),
                Answer(questionId = 92, text = "Bon Jovi"),
                Answer(questionId = 92, text = "Def Leppard"),
                Answer(questionId = 93, text = "Pink Floyd"),
                Answer(questionId = 93, text = "Led Zeppelin"),
                Answer(questionId = 93, text = "The Who"),
                Answer(questionId = 93, text = "The Rolling Stones"),
                Answer(questionId = 94, text = "Elvis Presley"),
                Answer(questionId = 94, text = "Johnny Cash"),
                Answer(questionId = 94, text = "Roy Orbison"),
                Answer(questionId = 94, text = "Buddy Holly")
            )

            quizRepository.insertAnswers(musicAnswers)

            val historyQuestions = listOf(
                Question(
                    categoryId = 6,
                    text = "Quel événement marquant a eu lieu le 14 juillet 1789 en France?",
                    correctAnswer = "La prise de la Bastille"
                ),
                Question(
                    categoryId = 6,
                    text = "Qui était le premier président des États-Unis?",
                    correctAnswer = "George Washington"
                ),
                Question(
                    categoryId = 6,
                    text = "Quel empire est connu pour avoir conquis la majeure partie de l'Europe sous la direction de Napoléon?",
                    correctAnswer = "L'Empire français"
                ),
                Question(
                    categoryId = 6,
                    text = "Quelle guerre a opposé le Nord et le Sud des États-Unis de 1861 à 1865?",
                    correctAnswer = "La guerre de Sécession"
                ),
                Question(
                    categoryId = 6,
                    text = "Quel célèbre mur de Berlin est tombé en 1989?",
                    correctAnswer = "Le mur de Berlin"
                ),
                Question(
                    categoryId = 6,
                    text = "Qui était le chef du Troisième Reich pendant la Seconde Guerre mondiale?",
                    correctAnswer = "Adolf Hitler"
                ),
                Question(
                    categoryId = 6,
                    text = "Quel pharaon égyptien est connu pour son tombeau intact découvert en 1922?",
                    correctAnswer = "Toutânkhamon"
                ),
                Question(
                    categoryId = 6,
                    text = "Quel traité de paix a mis fin à la Première Guerre mondiale?",
                    correctAnswer = "Le traité de Versailles"
                ),
                Question(
                    categoryId = 6,
                    text = "Quelle révolution a eu lieu en Russie en 1917?",
                    correctAnswer = "La révolution d'Octobre"
                ),
                Question(
                    categoryId = 6,
                    text = "Qui était le célèbre empereur de l'Empire romain qui a été assassiné en 44 av. J.-C.?",
                    correctAnswer = "Jules César"
                ),
                Question(
                    categoryId = 6,
                    text = "Quelle civilisation ancienne est connue pour ses pyramides et son écriture hiéroglyphique?",
                    correctAnswer = "L'Égypte ancienne"
                ),
                Question(
                    categoryId = 6,
                    text = "Quel explorateur a découvert l'Amérique en 1492?",
                    correctAnswer = "Christophe Colomb"
                ),
                Question(
                    categoryId = 6,
                    text = "Quel mouvement de renouveau culturel et artistique a eu lieu en Europe au XIVe siècle?",
                    correctAnswer = "La Renaissance"
                ),
                Question(
                    categoryId = 6,
                    text = "Quelle guerre a opposé la France et l'Angleterre de 1337 à 1453?",
                    correctAnswer = "La guerre de Cent Ans"
                ),
                Question(
                    categoryId = 6,
                    text = "Quel traité a marqué la fin de l'Empire ottoman après la Première Guerre mondiale?",
                    correctAnswer = "Le traité de Sèvres"
                ),
                Question(
                    categoryId = 6,
                    text = "Qui était le célèbre révolutionnaire et homme politique argentin qui a joué un rôle clé dans la révolution cubaine?",
                    correctAnswer = "Che Guevara"
                ),
                Question(
                    categoryId = 6,
                    text = "Quel roi anglais a eu six épouses et a fondé l'Église anglicane?",
                    correctAnswer = "Henri VIII"
                ),
                Question(
                    categoryId = 6,
                    text = "Quelle bataille décisive de la Seconde Guerre mondiale a eu lieu en Normandie en 1944?",
                    correctAnswer = "Le débarquement de Normandie"
                ),
                Question(
                    categoryId = 6,
                    text = "Quel célèbre scientifique est connu pour sa théorie de la relativité?",
                    correctAnswer = "Albert Einstein"
                ),
                Question(
                    categoryId = 6,
                    text = "Quel empire ancien était centré autour de la ville de Rome?",
                    correctAnswer = "L'Empire romain"
                )
            )

            quizRepository.insertQuestions(historyQuestions)

            val historyAnswers = listOf(
                Answer(questionId = 95, text = "La prise de la Bastille"),
                Answer(questionId = 95, text = "La Révolution française"),
                Answer(questionId = 95, text = "Le couronnement de Napoléon"),
                Answer(questionId = 95, text = "La Déclaration des droits de l'homme"),
                Answer(questionId = 96, text = "George Washington"),
                Answer(questionId = 96, text = "Thomas Jefferson"),
                Answer(questionId = 96, text = "Abraham Lincoln"),
                Answer(questionId = 96, text = "John Adams"),
                Answer(questionId = 97, text = "L'Empire français"),
                Answer(questionId = 97, text = "L'Empire britannique"),
                Answer(questionId = 97, text = "L'Empire romain"),
                Answer(questionId = 97, text = "L'Empire espagnol"),
                Answer(questionId = 98, text = "La guerre de Sécession"),
                Answer(questionId = 98, text = "La guerre d'Indépendance"),
                Answer(questionId = 98, text = "La guerre de 1812"),
                Answer(questionId = 98, text = "La guerre du Mexique"),
                Answer(questionId = 99, text = "Le mur de Berlin"),
                Answer(questionId = 99, text = "Le mur de la Chine"),
                Answer(questionId = 99, text = "Le mur de Hadrien"),
                Answer(questionId = 99, text = "Le mur de Trump"),
                Answer(questionId = 100, text = "Adolf Hitler"),
                Answer(questionId = 100, text = "Joseph Staline"),
                Answer(questionId = 100, text = "Winston Churchill"),
                Answer(questionId = 100, text = "Franklin D. Roosevelt"),
                Answer(questionId = 101, text = "Toutânkhamon"),
                Answer(questionId = 101, text = "Ramsès II"),
                Answer(questionId = 101, text = "Cléopâtre"),
                Answer(questionId = 101, text = "Akhenaton"),
                Answer(questionId = 102, text = "Le traité de Versailles"),
                Answer(questionId = 102, text = "Le traité de Paris"),
                Answer(questionId = 102, text = "Le traité de Brest-Litovsk"),
                Answer(questionId = 102, text = "Le traité de Trianon"),
                Answer(questionId = 103, text = "La révolution d'Octobre"),
                Answer(questionId = 103, text = "La révolution de Février"),
                Answer(questionId = 103, text = "La révolution russe"),
                Answer(questionId = 103, text = "La révolution bolchévique"),
                Answer(questionId = 104, text = "Jules César"),
                Answer(questionId = 104, text = "Néron"),
                Answer(questionId = 104, text = "Auguste"),
                Answer(questionId = 104, text = "Caligula"),
                Answer(questionId = 105, text = "L'Égypte ancienne"),
                Answer(questionId = 105, text = "La Grèce antique"),
                Answer(questionId = 105, text = "La Mésopotamie"),
                Answer(questionId = 105, text = "Les Mayas"),
                Answer(questionId = 106, text = "Christophe Colomb"),
                Answer(questionId = 106, text = "Amerigo Vespucci"),
                Answer(questionId = 106, text = "Vasco de Gama"),
                Answer(questionId = 106, text = "Fernand de Magellan"),
                Answer(questionId = 107, text = "La Renaissance"),
                Answer(questionId = 107, text = "Le Moyen Âge"),
                Answer(questionId = 107, text = "L'Âge des Lumières"),
                Answer(questionId = 107, text = "La Révolution industrielle"),
                Answer(questionId = 108, text = "La guerre de Cent Ans"),
                Answer(questionId = 108, text = "La guerre de Trente Ans"),
                Answer(questionId = 108, text = "La guerre de Succession d'Espagne"),
                Answer(questionId = 108, text = "La guerre des Roses"),
                Answer(questionId = 109, text = "Le traité de Sèvres"),
                Answer(questionId = 109, text = "Le traité de Lausanne"),
                Answer(questionId = 109, text = "Le traité de Saint-Germain"),
                Answer(questionId = 109, text = "Le traité de Neuilly"),
                Answer(questionId = 110, text = "Che Guevara"),
                Answer(questionId = 110, text = "Fidel Castro"),
                Answer(questionId = 110, text = "Simón Bolívar"),
                Answer(questionId = 110, text = "José de San Martín"),
                Answer(questionId = 111, text = "Henri VIII"),
                Answer(questionId = 111, text = "Richard III"),
                Answer(questionId = 111, text = "Édouard VI"),
                Answer(questionId = 111, text = "Jacques II"),
                Answer(questionId = 112, text = "Le débarquement de Normandie"),
                Answer(questionId = 112, text = "La bataille de Stalingrad"),
                Answer(questionId = 112, text = "La bataille de Midway"),
                Answer(questionId = 112, text = "La bataille des Ardennes"),
                Answer(questionId = 113, text = "Albert Einstein"),
                Answer(questionId = 113, text = "Isaac Newton"),
                Answer(questionId = 113, text = "Galilée"),
                Answer(questionId = 113, text = "Nicolas Copernic"),
                Answer(questionId = 114, text = "L'Empire romain"),
                Answer(questionId = 114, text = "L'Empire byzantin"),
                Answer(questionId = 114, text = "L'Empire carolingien"),
                Answer(questionId = 114, text = "L'Empire ottoman")
            )

            quizRepository.insertAnswers(historyAnswers)
        }
    }
}
