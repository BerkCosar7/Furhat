package furhatos.app.newskill11.flow.nlu
import furhatos.nlu.Intent
import furhatos.util.Language




class UpIntent : Intent() {
    override fun getExamples(lang: Language): List<String> {
        return listOf(
            "Higher",
            "Go up",
            "Up",
            "Greater" ,
            "Increase",
            "bigger"


        )
    }
}

class DownIntent : Intent() {
    override fun getExamples(lang: Language): List<String> {
        return listOf(
            "Lower",
            "Go down",
            "Down",
            "Smaller" ,
            "Decrease"

            )
    }
}

class JokeIntent : Intent() {
    override fun getExamples(lang: Language): List<String> {
        return listOf(
            "Tell me a joke",
            "Give me a joke",
            "Joke",
            "Say something funny",
            "Tell something humorous",
            "I need a good laugh",
            "Make me laugh",
            "Can you tell a joke?",
            "I want to hear a joke",
            "Share a funny story",
            "Tell a humorous anecdote",
            "I prefer a joke",
            "I'd like to hear a joke",
            "Give me something funny",
            "How about a joke?",
            "Share some humor",
            "Tell a witty anecdote",
            "I could use a laugh",
            "I'm in the mood for a joke",
            "Let's hear a joke",
            "Entertain me with a joke",
            "I'm ready for some humor",
            "How about a funny story?",
            "Make my day with a joke",
            "I'm all ears for a joke",
            "Give me your best joke",
            "I'm up for a laugh",
            "Brighten my day with a joke",
            "Humor me with a joke",
            "Tell a joke, please",
            "I'm in for a good laugh",
            "I'm looking for a joke",
            "choke"


        )

    }
}
class GameIntent : Intent() {
    override fun getExamples(lang: Language): List<String> {
        return listOf(
            "I want to play a number guessing game",
            "Number guessing game",
            "Let's play a number guessing game",
            "I'd like to play a number guessing game",
            "Can we play a number guessing game?",
            "I'm in the mood for a number guessing game",
            "I choose the number guessing game",
            "Number guessing game, please",
            "I'm interested in a number guessing game",
            "Count me in for a number guessing game",
            "I'm going with a number guessing game",
            "Number guessing game - that's the one",
            "Number guessing game it shall be",
            "A number guessing game, please!",
            "I'm leaning towards a number guessing game",
            "Number guessing game, the game I want",
            "Number guessing game is what I'm after",
            "A number guessing game, I'm ready",
            "Number guessing game - let's play!",
            "I prefer a number guessing game",
            "Number guess",
            "I want to play a guessing game with numbers",
            "Guess the number game",
            "Number guessing",
            "I'm up for a number guessing challenge",
            "Number guessing - my choice",
            "Number guessing, please!",
            "I'm up for a number guessing game",
            "Let's play the guessing game with numbers",
            "I'm ready for a number guessing game",
            "Number guessing - that sounds fun",
            "Number guessing, let's do it",
            "A number guessing challenge, I choose you!",
            "Number guessing challenge, please",
            "Count me in for a number guessing challenge",
            "Number guessing challenge - that's the one",
            "Number guessing challenge it shall be",
            "I'm opting for a number guessing challenge",
            "Number guessing challenge, please!",
            "I'm leaning towards a number guessing challenge",
            "Number guessing challenge, the game I want",
            "Number guessing challenge is what I'm after",
            "A number guessing challenge, I'm ready",
            "Number guessing challenge - let's play!"
        )
    }
}

class TTTIntent : Intent() {
    override fun getExamples(lang: Language): List<String> {
        return listOf(
            "I prefer tic tac toe",
            "Tic Tac Toe",
            "Tic Tack Toe",
            "Tick Tack Toe",
            "Tick Tac Toe",
            "Tic Tak Toe",
            "I want tic tac toe",
            "I'd like to play Tic Tac Toe",
            "Can we play Tic Tac Toe?",
            "Let's go with Tic Tac Toe",
            "Tic Tac Toe game, please",
            "I'm in the mood for Tic Tac Toe",
            "I choose Tic Tac Toe",
            "Tic Tac Toe it is",
            "Tic-Tac-Toe sounds good",
            "I'm interested in Tic Tac Toe",
            "Tic Tac Toe, please",
            "I'm up for Tic Tac Toe",
            "Let's play Tic Tac Toe",
            "Tic Tac Toe, my pick",
            "I'm selecting Tic Tac Toe",
            "Tic Tac Toe is my game",
            "Tic Tac Toe, let's do it",
            "Count me in for Tic Tac Toe",
            "I'm going with Tic Tac Toe",
            "Tic Tac Toe - that's the one",
            "Tic Tac Toe it shall be",
            "Tic Tac Toe - my choice",
            "I'm opting for Tic Tac Toe",
            "Tic Tac Toe, please!",
            "I'm leaning towards Tic Tac Toe",
            "Tic Tac Toe, the game I want",
            "Tic Tac Toe is what I'm after",
            "Tic Tac Toe, I'm ready",
            "Tic Tac Toe - let's play!"
        )
    }
}
class QuizIntent : Intent() {
    override fun getExamples(lang: Language): List<String> {
        return listOf(
            "I prefer quiz",
            "I'd like to take a quiz",
            "Quiz",
            "Qwiz",
            "Kwiz",
            "Kwiss",
            "Qweeze",
            "Let's do a quiz",
            "I'm up for a quiz",
            "Quiz time",
            "I choose the quiz",
            "Quiz, please",
            "I'm interested in a quiz",
            "Count me in for a quiz",
            "I'm going with a quiz",
            "Quiz - that's the one",
            "Quiz it shall be",
            "A quiz, please!",
            "I'm leaning towards a quiz",
            "Quiz, the activity I want",
            "Quiz is what I'm after",
            "A quiz, I'm ready",
            "Quiz - let's go!",
            "I prefer a quiz",
            "I want to take a quiz",
            "Let's take a quiz",
            "Quiz challenge",
            "I'm ready for a quiz",
            "Quiz - my choice",
            "Quiz, please!",
            "I'm up for a quiz",
            "Let's participate in a quiz",
            "I'm excited for a quiz",
            "Quiz - that sounds fun",
            "Quiz, let's do it",
            "A quiz challenge, I choose you!",
            "Quiz challenge, please",
            "Count me in for a quiz challenge",
            "Quiz challenge - that's the one",
            "Quiz challenge it shall be",
            "I'm opting for a quiz challenge",
            "Quiz challenge, please!",
            "I'm leaning towards a quiz challenge",
            "Quiz challenge, the activity I want",
            "Quiz challenge is what I'm after",
            "A quiz challenge, I'm ready",
            "Quiz challenge - let's go!",
            "I prefer a quiz challenge",
            "I want to take a quiz challenge",
            "Let's take a quiz challenge",
            "Quiz competition",
            "I'm ready for a quiz challenge",
            "Quiz challenge - my choice",
            "I want to take the queen",
            "Chris"


        )
    }
}


class One : Intent() {
    override fun getExamples(lang: Language): List<String> {
        return listOf(
            "One",
            "I'm choosing one",
            "first box",
            "first pox",
            "first",
            "Box one",
            "pox one",
            "1",
            "I'll take the first one",
            "I want to pick the initial box",
            "Number one, please",
            "Let's start with the first",
            "Give me the box labeled one",
            "Won",
            "Wun",
            "Juan",
            "Wahn",
            "Waun",
            "On",
            "Once",
            "1st",
            "Furst",
            "The primary box",
            "The primary pox"

        )
    }
}
class Two : Intent() {
    override fun getExamples(lang: Language): List<String> {
        return listOf(
            "Two",
            "I'm choosing two",
            "Second box",
            "Second pox",
            "Second",
            "Box two",
            "pox two",
            "2",
            "I'll take the second one",
            "Number two, please",
            "Let's go with the second",
            "Give me the box labeled two",
            "To",
            "Tew",
            "Tu",
            "Toot",
            "Too",
            "Twice",
            "2nd",
            "Secund",
            "chicken pox"
        )
    }
}
class Three : Intent() {
    override fun getExamples(lang: Language): List<String> {
        return listOf(
            "Box 3",
            "Three",
            "I'm choosing three",
            "third box",
            "third",
            "3",
            "I'll take the third one",
            "I want to pick the last box",
            "Number three, please",
            "Let's go with the third",
            "Give me the box labeled three",
            "Thri",
            "Thuree",
            "Thrii",
            "Thray",
            "Trey",
            "Tri",
            "Tree",
            "Thrice",
            "3rd",
            "Last box",
            "The third one"
        )
    }
}

class Four : Intent() {
    override fun getExamples(lang: Language): List<String> {
        return listOf(
            "Box 4",
            "Four",
            "I'm choosing four",
            "Fourth box",
            "Fourth",
            "4",
            "I'll take the fourth one",
            "I want to pick the last box",
            "Number four, please",
            "Let's go with the fourth",
            "Give me the box labeled four",
            "For",
            "Fur",
            "Phor",
            "Fower",
            "Foar",
            "Fohr",
            "Foh-er",
            "4th",
            "Last box",
            "The fourth one"
        )
    }
}

class Five : Intent() {
    override fun getExamples(lang: Language): List<String> {
        return listOf(
            "Five",
            "I'm choosing five",
            "Fifth box",
            "Fifth",
            "5",
            "I'll take the fifth one",
            "I want to pick the last box",
            "Number five, please",
            "Let's go with the fifth",
            "Give me the box labeled five",
            "Fyve",
            "Fighv",
            "Phive",
            "Fiev",
            "Fahv",
            "Fiv",
            "Fibe",
            "5th",
            "Last box",
            "The fifth one",
            "Box five"
        )
    }
}

class Six : Intent() {
    override fun getExamples(lang: Language): List<String> {
        return listOf(
            "Box six",
            "Six",
            "I'm choosing six",
            "Sixth box",
            "Sixth",
            "6",
            "I'll take the sixth one",
            "I want to pick the last box",
            "Number six, please",
            "Let's go with the sixth",
            "Give me the box labeled six",
            "Sicks",
            "Sikhs",
            "Seeks",
            "6th",
            "Last box",
            "The sixth one"
        )
    }
}

class Seven : Intent() {
    override fun getExamples(lang: Language): List<String> {
        return listOf(
            "Seven",
            "I'm choosing seven",
            "Seventh box",
            "Seventh",
            "7",
            "I'll take the seventh one",
            "I want to pick the last box",
            "Number seven, please",
            "Let's go with the seventh",
            "Give me the box labeled seven",
            "Sevin",
            "Sevun",
            "Sev'n",
            "7th",
            "Last box",
            "The seventh one",
            "Box seven"
        )
    }
}

class Eight : Intent() {
    override fun getExamples(lang: Language): List<String> {
        return listOf(
            "Eight",
            "I'm choosing eight",
            "Eighth box",
            "Eighth",
            "8",
            "I'll take the eighth one",
            "I want to pick the last box",
            "Number eight, please",
            "Let's go with the eighth",
            "Give me the box labeled eight",
            "Aight",
            "Ate",
            "Et",
            "8th",
            "Last box",
            "The eighth one",
            "Box eight",
            "Hey"
        )
    }
}

class Nine : Intent() {
    override fun getExamples(lang: Language): List<String> {
        return listOf(
            "Box nine",
            "Nine",
            "I'm choosing nine",
            "Ninth box",
            "Ninth",
            "9",
            "I'll take the ninth one",
            "I want to pick the last box",
            "Number nine, please",
            "Let's go with the ninth",
            "Give me the box labeled nine",
            "Nahyn",
            "Nyn",
            "Nein",
            "Nine-eth",
            "Nine-th",
            "Niner",
            "Niney",
            "Neinen",
            "9th",
            "Last box",
            "The ninth one",
            "mine"
        )
    }
}
class A: Intent() {
    override fun getExamples(lang: Language): List<String> {
        return listOf(
            "a",
            "I'm choosing a",
            "option a",
            "I prefer option A.",
            "Option A is my choice.",
            "A seems like the best option to me.",
            "I'll select A.",
            "For this, I'm going with A.",
            "A is the one I want.",
            "Let's go with A, shall we?",
            "My decision is A.",
            "I'm inclined to pick A.",
            "The answer is A.",
            "A is the right one for me.",
            "A",
            "I'll go with A",
            "Selecting A",
            "Option A",
            "I choose A",
            "The answer is A",
            "A is my answer",
            "I'm picking A",
            "I'll opt for A",
            "I'd like to go with A",
            "A, please",
            "A is my choice",
            "A as my selection",
            "I'm going to answer A",
            "Let's select A",
            "I'm clicking A",
            "I'm going with option A",
            "I think it's A",
            "A - my response",
            "A - my selection",
            "For this one, it's A",
            "In this case, A",
            "Going for A this time",
            "The correct option is A",
            "I'm locking in A",
            "A for this question",
            "I believe it's A",
            "I'm marking A as my answer",
            "Option A, please",
            "I'll confirm A",
            "My choice is A",
            "I'm sticking with A",
            "A is the one",
            "This time, it's A",
            "A - my final answer"

        )
    }
}

class B: Intent() {
    override fun getExamples(lang: Language): List<String> {
        return listOf(
            "b",
            "I'm choosing b",
            "option b",
            "I think option B is better.",
            "B is my preferred choice.",
            "B looks like the way to go.",
            "I'll opt for B.",
            "I'm leaning towards B.",
            "I'm choosing B for this one.",
            "B is the answer I like.",
            "My decision is B.",
            "B stands out to me.",
            "Let's go with B, then.",
            "B is the right answer for me.",
            "B",
            "I'll go with B",
            "Selecting B",
            "Option B",
            "I choose B",
            "The answer is B",
            "B is my answer",
            "I'm picking B",
            "I'll opt for B",
            "I'd like to go with B",
            "B, please",
            "B is my choice",
            "B as my selection",
            "I'm going to answer B",
            "Let's select B",
            "I'm clicking B",
            "I'm going with option B",
            "I think it's B",
            "B - my response",
            "B - my selection",
            "For this one, it's B",
            "In this case, B",
            "Going for B this time",
            "The correct option is B",
            "I'm locking in B",
            "B for this question",
            "I believe it's B",
            "I'm marking B as my answer",
            "Option B, please",
            "I'll confirm B",
            "My choice is B",
            "I'm sticking with B",
            "B is the one",
            "This time, it's B",
            "B - my final answer"

        )
    }
}

class C: Intent() {
    override fun getExamples(lang: Language): List<String> {
        return listOf(
            "C",
            "I'll go with C",
            "Selecting C",
            "Option C",
            "I choose C",
            "The answer is C",
            "C is my answer",
            "I'm picking C",
            "I'll opt for C",
            "I'd like to go with C",
            "C, please",
            "C is my choice",
            "C as my selection",
            "I'm going to answer C",
            "Let's select C",
            "I'm clicking C",
            "I'm going with option C",
            "I think it's C",
            "C - my response",
            "C - my selection",
            "For this one, it's C",
            "In this case, C",
            "Going for C this time",
            "The correct option is C",
            "I'm locking in C",
            "C for this question",
            "I believe it's C",
            "I'm marking C as my answer",
            "Option C, please",
            "I'll confirm C",
            "My choice is C",
            "I'm sticking with C",
            "C is the one",
            "This time, it's C",
            "C - my final answer"

        )
    }
}

class EasyIntent: Intent() {
    override fun getExamples(lang: Language): List<String> {
        return listOf(
            "I choose the easy mode",
            "Select easy difficulty",
            "I'd like to play on easy",
            "Easy mode, please",
            "Opt for an easy level",
            "Set the game to easy",
            "I want to start with easy",
            "I want easy",
            "Easy",
            "easy mode",
            "i want easy",
            "I am choosing easy",
            "I am choosing easy mode",
            "Easy",
            "Easel",
            "Ease",
            "East",
            "Eats",
            "Izzy",
            "Isle",
            "Elsie",
            "Icy",
            "Eyes",
            "Isy",
            "Ezzy",
            "Eisley",
            "Esy",
            "Ezzy",
            "Ise",
            "Ezzy",
            "Ize",
            "Isi",
            "Easy-peasy"


        )
    }
}

class HardIntent: Intent() {
    override fun getExamples(lang: Language): List<String> {
        return listOf(
            "I choose the hard mode",
            "Select hard difficulty",
            "I'd like to play on hard",
            "Hard mode, please",
            "Opt for a hard level",
            "Set the game to hard",
            "I want to start with hard",
            "I want hard",
            "Hard",
            "hard mode",
            "i want hard",
            "I am choosing hard",
            "I am choosing hard mode",
            "I choose the hard mode",
            "Select hard difficulty",
            "I'd like to play on hard",
            "Hard mode, please",
            "Opt for a hot level",
            "Set the game to hot",
            "I want to start with hot",
            "Hot",
            "hot mode",
            "i want hot",
            "I am choosing hot",
            "I am choosing hot mode",
            "Hard",
            "Hot",
            "Hut",
            "Heart",
            "Hurd"
        )
    }
}





