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
            "Increase"


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
            "I prefer a joke"
        )

    }
}
class GameIntent : Intent() {
    override fun getExamples(lang: Language): List<String> {
        return listOf(
            "I prefer a game",
            "I prefer the game",
            "Game",
            "I want the game",
            "I want to play game"
        )
    }
}

class TTTIntent : Intent() {
    override fun getExamples(lang: Language): List<String> {
        return listOf(
            "I prefer tic tac toe",
            "tic tac toe",
            "I want tic tac toe",
            "I want to play tic tac toe"
        )
    }
}
class QuizIntent : Intent() {
    override fun getExamples(lang: Language): List<String> {
        return listOf(
            "I prefer quiz",
            "quiz",
            "I want a quiz",
            "I want a test",
            "I want to play quiz",
            "I want to take the quiz",
            "test",
            "I prefer taking a quiz.",
            "Quiz",
            "I want to take a quiz.",
            "I want to play a quiz.",
            "I want to participate in a quiz.",
            "I'd like to test my knowledge with a quiz.",
            "Test",
            "I'm interested in a quiz.",
            "Can I have a quiz, please?",
            "I'm up for a quiz.",
            "I'm ready for a test.",
            "Let's do a quiz.",
            "I'd love to take a quiz.",
            "Give me a quiz, please.",
            "A quiz sounds fun.",
            "I'd like to challenge myself with a quiz.",
            "Count me in for a quiz.",
            "I'm in the mood for a test.",
            "I'm looking for a quiz to solve.",
            "I want to take the queen"

        )
    }
}

class nIntent : Intent() {
    override fun getExamples(lang: Language): List<String> {
        return listOf(
            "No",
            "no it's not"
        )
    }
}

class pIntent : Intent() {
    override fun getExamples(lang: Language): List<String> {
        return listOf(
            "Yes",
            "Yes it is",
            "correct"
        )
    }
}

class One : Intent() {
    override fun getExamples(lang: Language): List<String> {
        return listOf(
            "One",
            "I'm choosing one",
            "first box",
            "first",
            "1"
        )
    }
}
class Two : Intent() {
    override fun getExamples(lang: Language): List<String> {
        return listOf(
            "Two",
            "I'm choosing two",
            "second box",
            "second",
            "2"
        )
    }
}
class Three : Intent() {
    override fun getExamples(lang: Language): List<String> {
        return listOf(
            "Three",
            "I'm choosing three",
            "third box",
            "third",
            "3",
            "tree"
        )
    }
}

class Four : Intent() {
    override fun getExamples(lang: Language): List<String> {
        return listOf(
            "Four",
            "I'm choosing four",
            "fourth box",
            "fourth",
            "4"
        )
    }
}

class Five : Intent() {
    override fun getExamples(lang: Language): List<String> {
        return listOf(
            "Five",
            "I'm choosing five",
            "fifth box",
            "fifth",
            "5"
        )
    }
}

class Six : Intent() {
    override fun getExamples(lang: Language): List<String> {
        return listOf(
            "Six",
            "I'm choosing six",
            "sixth box",
            "sixth",
            "6"
        )
    }
}

class Seven : Intent() {
    override fun getExamples(lang: Language): List<String> {
        return listOf(
            "Seven",
            "I'm choosing seven",
            "seventh box",
            "seventh",
            "7"
        )
    }
}

class Eight : Intent() {
    override fun getExamples(lang: Language): List<String> {
        return listOf(
            "Eight",
            "I'm choosing eight",
            "eighth box",
            "eighth",
            "8"
        )
    }
}

class Nine : Intent() {
    override fun getExamples(lang: Language): List<String> {
        return listOf(
            "Nine",
            "I'm choosing nine",
            "ninth box",
            "nineth",
            "9"
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
            "A is the right one for me."

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
            "B is the right answer for me."

        )
    }
}

class C: Intent() {
    override fun getExamples(lang: Language): List<String> {
        return listOf(
            "c",
            "I'm choosing c",
            "option c",
            "I'm going with option C.",
            "C is the one I want.",
            "I'll select C.",
            "For this, I choose C.",
            "Option C is my choice.",
            "C seems like the best choice to me.",
            "Let's go with C, shall we?",
            "My decision is C.",
            "C is what I'm thinking.",
            "C is the right answer for me.",
            "I'm inclined to pick C."

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
            "Easy",
            "easy mode",
            "i want easy",
            "I am choosing easy",
            "I am choosing easy mode"


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
            "Hard",
            "hard mode",
            "i want hard",
            "I am choosing hard",
            "I am choosing hard mode"
        )
    }
}





