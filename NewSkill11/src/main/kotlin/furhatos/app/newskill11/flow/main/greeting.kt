package furhatos.app.newskill11.flow.main


import furhatos.app.newskill11.flow.Parent

import furhatos.app.newskill11.flow.nlu.*
import furhatos.flow.kotlin.*
import furhatos.nlu.common.No
import furhatos.nlu.common.Yes
import java.security.SecureRandom
import furhatos.*
import kotlin.random.Random



// variables for number guessing game
var mIn = 1;
var mAx = 100;
var middle = (mIn + mAx) / 2
var nOfGuesses = 0

//variables for tictactoe
var tttList= mutableListOf(0,0,0,0,0,0,0,0,0)

var tq= listOf(
    //Topic 1 Questions
    "How many people graduated from Koch University until now?",
    "Who gave the first lecture of Koch University history on September 4 1993?",
    "When did the first Phd student graduate from Koch University?",
    "Which club of the university hosted the marketing theorist Jack Trout for the opening speech at The road to Differentiation in 2005?",
    "Which company had a research center at Koch University?",
    "Which of the following is NOT a department at Koç University?",
    "Which one is located at Koç University Rumelifeneri Campus?",
    "Who won Rahmi Koch Science medal in 2022?",
    "When did Kworks open?",
    "What is the total area of Koch University?",
    //Topic 2 Questions
    "During the period of April 2022-April 2023 which institute hasn’t collaborated with the KUIS AI Center?",
    "How many externally funded grants were awarded to KUIS AI Faculty members between April 2022 and April 2023?",
    "What was the total budget allocated for the externally funded grants received by KUIS AI Faculty during the period April 2022 and April 2023?",
    "How many GPUs does Koch University high-performance computation facility have?",
    "Which is not one of the research areas of the Koch University AI center?",
    "When was the Artificial Intelligence Center at Koç University established?",
    "Which institution partnered with Koç University to establish the Artificial Intelligence Center, aiming to combine scientific resources with financial support?",
    "which affiliated Lab is not one of the labs under the research area Systems and AI in AI Center",
    "How many projects are completed at Koch University after KUIS AI opened?",
    "How many alumni does KUIS AI center have?",
    //Topic 3 Questions
    "Who is known as one of the founders of artificial intelligence?",
    "Which of the following is not an example of AI?",
    "In which of the following areas has AI work typically not been done?",
    "What is the primary goal of Natural Language Processing (NLP) in the field of AI?",
    "What does the Turing Test measure?",
    "Who developed the Turing Test?",
    "Which AI technique is primarily used for clustering similar data points in unsupervised learning?",
    "Which of the following is a popular open-source machine learning library developed by Facebook?",
    " In the context of AI, what does neural, in neural network refer to?",
    "Which of the following is NOT a type of neural network architecture?"
)
var ta= listOf(
    //Topic 1 Answers
    listOf("18907","19197","19485",1),
    listOf("Umran İnan","Rahmi Koch","Vehbi Koch",2),
    listOf("2006","2007","2008",0),
    listOf("Business Club","IES","Marketing Club",2),
    listOf("Intel","Google","Microsoft",2),
    listOf(" Media and Visual Arts","Architecture","Medicine",1),
    listOf("Sevgi Gernoohl Cultural Center","Koch Hospital","Koch University Research Center for Anatolian Civilizations ",0),
    listOf("Metin Sit tee","Bilkee Yuhlduhz","Hatiga Altuu",1),
    listOf("2012","2013","2018",1),
    listOf("150000 meter square","230000 meter square","280000 meter square",1),
    //Topic 2 Answers
    listOf("Harvard University","Stanford University","University of Oxford",1),
    listOf("21","24","25",2),
    listOf("38 Million Turkish Liras","40 Million Turkish Liras","44 Million Turkish Liras",1),
    listOf("147","156","153",2),
    listOf("Natural Language Processing","Human-Computer Interaction","AI Ethics and Fairness",2),
    listOf("January 2020","February 2019","February 2020",2),
    listOf("Ziraat Bankasuh", "Yapı Kredi Bankasuh", "İsh Bankasuh", 2),
    listOf("ParCore Lab", "DISNET", "MVGL", 2),
    listOf("15","20","22",1),
    listOf("22","25","32",0),


    //Topic 3 Answers
    listOf("Elon Musk","Herbert Simon","John McCarthy",2),
    listOf("Siri","ChatGPT","MacBook ",2),
    listOf("Predicting stock market trends"," Natural language processing for chatbots","Determining the age of old wines by taste ",2),
    listOf("generating creative content", "Enabling computers to understand and work with human language", "enhancing computer vision for object recognition", 1),
    listOf("The speed of a computer", "The accuracy of a machine learning model", "A machine's ability to exhibit human-like intelligence", 2),
    listOf("Alan Turing", "Julius Turing", "John Turing", 0),
    listOf("Decision Trees", "K-Nearest Neighbors", "K-Means Clustering", 2),
    listOf("Keras", "Scikit-learn", "PyTorch", 2),
    listOf("Computer circuits", "Biological brain neurons", "Network cables", 1),
    listOf("Convolutional Neural Network ", "Recursive Neural Network", "Linear Regression Network", 2)





)



val Greeting: State = state(Parent) {

    onEntry {
        furhat.say(
            {
                random{
                    +"Hello!"
                    +"Hi!"
                    +"Good day"
                    +"Hi there"
                    +"Hello, I'm Furhat, the friendly social robot. I'm here to make talking to machines easier and more fun. I can chat with you using a human-like face and voice, so you don't have to feel like you're talking to a computer. I use smart technology to have conversations and help with things like answering questions or giving information. It's all about making technology feel more friendly and helpful in your everyday life."
                }
            }
        )

        furhat.say("Welcome to AI center. My name is Furhat. I can make jokes, play tictactoe with you, or give you a quiz about our university and ai.")
        furhat.ask("Which one do you prefer?")
    }

    onResponse<GameIntent> {
        furhat.say("Choose a number between 1 and 100 but don't tell it out loud. 1 and 100 are included.")
        delay(3000)
        goto(binaryGame)
    }

    onResponse<JokeIntent> {
        goto(Jokee)
    }
    onResponse<TTTIntent> {
        goto(TicTacToe)
    }

    onResponse<QuizIntent>{
        goto(Quiz)
    }

}

//quiz game
val Quiz: State= state(Parent) {

    var qn=1
    var cqn=0
    var qcount=0


    var num=0

    onEntry{

        if (qn==1){
            if (qcount==0){
                qcount++
                val secureRandom = SecureRandom()
                num = secureRandom.nextInt(9)

                furhat.say("question 1. ")
                delay(1500)
                furhat.say(""+tq[num])
                delay(500)
                furhat.say("a")
                delay(300)
                furhat.say(""+ta[num][0])
                delay(500)
                furhat.say("b")
                delay(300)
                furhat.say(""+ta[num][1])
                delay(500)
                furhat.say("c")
                delay(300)
                furhat.say(""+ta[num][2])
                delay(500)
                furhat.ask("Which of these options is correct. Tell your answer such as a, b, or c.")
            }
            else {
                furhat.ask("Tell your answer.")
            }
        }
        else if (qn==2){
            if (qcount==0){
                qcount++
                num=(4..6).random()
                furhat.say("question 2. ")
                delay(1500)
                furhat.say(""+tq[num])
                delay(500)
                furhat.say("a")
                delay(300)
                furhat.say(""+ta[num][0])
                delay(500)
                furhat.say("b")
                delay(300)
                furhat.say(""+ta[num][1])
                delay(500)
                furhat.say("c")
                delay(300)
                furhat.say(""+ta[num][2])
                delay(500)
                furhat.ask("Which of these options is correct.")

            }
            else {

                furhat.ask(" Tell your answer.")
            }
        }
        else if (qn==3){
            if (qcount==0){
                qcount++
                num=(7..9).random()
                furhat.say("question 3. ")
                delay(1500)
                furhat.say(""+tq[num])
                delay(500)
                furhat.say("a")
                delay(300)
                furhat.say(""+ta[num][0])
                delay(500)
                furhat.say("b")
                delay(300)
                furhat.say(""+ta[num][1])
                delay(500)
                furhat.say("c")
                delay(300)
                furhat.say(""+ta[num][2])
                delay(500)
                furhat.ask("Which of these options is correct.")
            }
            else {
                furhat.ask(" Tell your answer.")
            }
        }
        else{
            qn=0
            furhat.say("Out of 3 question you have found the correct answer for "+ numberToWordMap[cqn]+" times")
            delay(2000)
            goto(Greeting)
        }
    }
    onResponse<A> {
        qn++
        var co=ta[num][3]
        qcount=0
        if(co==0){
            furhat.say("correct")
            cqn++
        }
        else{
            furhat.say("the correct answer was")
            delay(1500)
            furhat.say(""+ta[num][co as Int])
        }
        reentry()
    }
    onResponse<B> {
        qn++
        var co=ta[num][3]
        qcount=0
        if(co==1){
            furhat.say("correct")
            cqn++
        }
        else{
            furhat.say("the correct answer was")
            delay(1500)
            furhat.say(""+ta[num][co as Int])
        }
        reentry()
    }
    onResponse<C> {
        qn++
        var co=ta[num][3]
        qcount=0
        if(co==2){
            furhat.say("correct")
            cqn++
        }
        else{
            furhat.say("the correct answer was")
            delay(1500)
            furhat.say(""+ta[num][co as Int])
        }
        reentry()
    }
    onNoResponse {
        qcount++
        furhat.say("please choose one of the options such as a, b, or c.")

    }


}

// tic tac toe game
val TicTacToe: State = state(Parent){
    onEntry {
        furhat.say("Each box is represented with a number. Since I am a very intelligent robot, I can memorize which moves" +
                " have been made. But to make it easy for you I have a pen and paper next to me. You can use them to write the moves")

        goto(TTTStart)
    }

}

val TTTStart: State = state(Parent){
    onEntry{
        //add winchecker
        println(tttList)
        if(tttList.contains(0)==false){
            furhat.say("tie")
            goto(endWithTie)
        }
        else if (winChecker(tttList) == 1) {
            furhat.say("You won")
            goto(endWithWinner)
        }
        else if (winChecker(tttList)==2){
            furhat.say("I won")
            goto(endWithWinner)
        }
        else {
            furhat.ask("where  are you choosing")
        }
    }
    onResponse<One>{
        if(tttList[0]==1 || tttList[0]==2){
            furhat.say("full, say other")
            reentry()
        }
        else{
            tttList[0]=1
            goto(robotPlaying)
        }
    }
    onResponse<Two>{
        if(tttList[1]==1 || tttList[1]==2){
            furhat.say("full, say other")
            reentry()
        }
        else{
            tttList[1]=1
            goto(robotPlaying)
        }
    }
    onResponse<Three>{
        if(tttList[2]==1 || tttList[2]==2){
            furhat.say("full, say other")
            reentry()
        }
        else{
            tttList[2]=1
            goto(robotPlaying)
        }
    }
    onResponse<Four>{
        if(tttList[3]==1 || tttList[3]==2){
            furhat.say("full, say other")
            reentry()
        }
        else{
            tttList[3]=1
            goto(robotPlaying)
        }
    }
    onResponse<Five>{
        if(tttList[4]==1 || tttList[4]==2){
            furhat.say("full, say other")
            reentry()
        }
        else{
            tttList[4]=1
            goto(robotPlaying)
        }
    }
    onResponse<Six>{
        if(tttList[5]==1 || tttList[5]==2){
            furhat.say("full, say other")
            reentry()
        }
        else{
            tttList[5]=1
            goto(robotPlaying)
        }
    }
    onResponse<Seven>{
        if(tttList[6]==1 || tttList[6]==2){
            furhat.say("full, say another")
            reentry()
        }
        else{
            tttList[6]=1
            goto(robotPlaying)
        }
    }
    onResponse<Eight>{
        if(tttList[7]==1 || tttList[7]==2){
            furhat.say("full, say other")
            reentry()
        }
        else{
            tttList[7]=1
            goto(robotPlaying)
        }
    }
    onResponse<Nine>{
        if(tttList[8]==1 || tttList[8]==2){
            furhat.say("full, say other")
            reentry()
        }
        else{
            tttList[8]=1
            goto(robotPlaying)
        }
    }
    onNoResponse {
        furhat.say("ONly numbers from 1 to 9")
        reentry()
    }


}

val robotPlaying: State = state(Parent){
    onEntry {
        println("rob "+ tttList)
        if(tttList.contains(0)==false){
            delay(1500)
            furhat.say("None of us has won")
            goto(endWithTie)
        }
        else if (winChecker(tttList) == 1) {
            furhat.say("You won")
            delay(1500)
            goto(endWithWinner)
        }
        else if (winChecker(tttList)==2){
            furhat.say("I won")
            delay(1500)
            goto(endWithWinner)
        }
        else{
            var embed=embedder(tttList)

            if (embed!=10){
                tttList[embed]=2
                furhat.say("I'm choosing " + numberToWordMap[embed+1])
                delay(1500)
                goto(TTTStart)
            }
            else{
                var winto=toWin(tttList)
                if(winto!=10){
                    tttList[winto]=2
                    furhat.say("I'm choosing " + numberToWordMap[winto+1])
                    delay(1500)
                    goto(TTTStart)
                }
                else{
                    var rNum= randomPlay(tttList)
                    tttList[rNum]=2
                    furhat.say("I'm choosing " + numberToWordMap[rNum+1])
                    delay(1500)
                    goto(TTTStart)
                }
            }
        }
    }
}

val endWithWinner:State = state(Parent){
    onEntry {
        furhat.say("the game ends")
        tttList=mutableListOf(0,0,0,0,0,0,0,0,0)
    }
}

val endWithTie:State = state(Parent){
    onEntry {
        furhat.say("the game ends")
        tttList=mutableListOf(0,0,0,0,0,0,0,0,0)
    }
}


//number guessing game
val binaryGame: State = state(Parent) {
    nOfGuesses+=1;

    onEntry {
        furhat.ask("Is your number " + numberToWordMap[middle])
    }
    onResponse<Yes> {
        goto(Found);
    }
    onResponse<No> {
        goto(Searcher)

    }
}


val Found: State =state(Parent){
    onEntry {
        furhat.say("I found your number in " + numberToWordMap[nOfGuesses] +
                " tries. I won! thank you for playing with me!")
        mIn = 1;
        mAx = 100;
        middle = (mIn + mAx) / 2
        nOfGuesses = 0

        goto(Greeting)
    }


}

val Searcher: State = state(Parent) {
    onEntry{
        furhat.ask("Is your  number greater than "+numberToWordMap[middle])
    }
    onResponse<Yes> {
        mIn=middle+1
        middle=(mIn+mAx)/2
        goto(binaryGame)
    }
    onResponse<No> {
        mAx=middle
        middle=(mAx+mIn)/2
        goto(binaryGame)
    }
}

//joke generator
val Jokee : State =state(Parent) {
    onEntry {
        furhat.say({
            random {
                +"Why don't scientists trust atoms? Because they make up everything."
                +"I used to play piano by ear, but now I use my hands."
                +"How do you catch a squirrel? Climb a tree and act like a nut!"
                +"Why did the scarecrow win an award? Because he was outstanding in his field."
                +"What do you call fake spaghetti? An impasta!"
                +"Why did the bicycle fall over? It was two-tired!"
                +"Why don't skeletons fight each other? They don't have the guts."
                +"What did one ocean say to the other ocean? Nothing, they just waved."
                +"Why was the math book sad? Because it had too many problems."
                +"What do you call a snowman with a six-pack? An abdominal snowman!"
                +"Why did the tomato turn red? Because it saw the salad dressing!"
                +"Why don't some couples go to the gym? Because some relationships don't work out."
                +"Why couldn't the bicycle stand up by itself? It was two-tired!"
                +"Did you hear about the guy who invented Lifesavers? They say he made a mint."
                +"How do you organize a space party? You planet!"
                +"Why was the math book sad? Because it had too many problems."
                +"What do you get when you cross a snowman and a vampire? Frostbite!"
                +"Why don't skeletons fight each other? They don't have the guts."
            }
        })
        goto(Greeting)
    }
}


//functions for tictactoe
fun winChecker(a: MutableList<Int>): Int{
    if((a[0]==a[1] && a[0]==a[2] && a[0]==1) ||
        (a[3]==a[4] && a[3]==a[5] && a[3]==1) ||
        (a[6]==a[7] && a[6]==a[8] && a[6]==1) ||
        (a[0]==a[3] && a[0]==a[6] && a[0]==1) ||
        (a[1]==a[4] && a[1]==a[7] && a[1]==1) ||
        (a[2]==a[5] && a[2]==a[8] && a[2]==1) ||
        (a[0]==a[4] && a[0]==a[8] && a[0]==1) ||
        (a[2]==a[4] && a[2]==a[6] && a[2]==1) )
    {
        return 1
    }
    else if((a[0]==a[1] && a[0]==a[2] && a[0]==2) ||
        (a[3]==a[4] && a[3]==a[5] && a[3]==2) ||
        (a[6]==a[7] && a[6]==a[8] && a[6]==2) ||
        (a[0]==a[3] && a[0]==a[6] && a[0]==2) ||
        (a[1]==a[4] && a[1]==a[7] && a[1]==2) ||
        (a[2]==a[5] && a[2]==a[8] && a[2]==2) ||
        (a[0]==a[4] && a[0]==a[8] && a[0]==2) ||
        (a[2]==a[4] && a[2]==a[6] && a[2]==2))
    {
        return 2
    }
    else
    {
        return 0
    }


}

fun toWin(b:MutableList<Int>): Int{
    if ((b[0] == b[2] && b[1] == 0 && b[0] == 2) || (b[4] == b[7] && b[1] == 0 && b[4] == 2)) {
        return 1
    } else if ((b[3] == b[4] && b[5] == 0 && b[3] == 2) || (b[2] == b[8] && b[5] == 0 && b[2] == 2)) {
        return 5
    } else if ((b[1] == b[2] && b[0] == 0 && b[1] == 2) || (b[3] == b[6] && b[0] == 0 && b[3] == 2) || (b[4] == b[8] && b[0] == 0 && b[4] == 2)) {
        return 0
    } else if ((b[1] == b[4] && b[7] == 0 && b[1] == 2) || (b[6] == b[8] && b[7] == 0 && b[6] == 2)) {
        return 7
    } else if ((b[5] == b[4] && b[3] == 0 && b[4] == 2) || (b[0] == b[6] && b[3] == 0 && b[0] == 2)) {
        return 3
    } else if ((b[2] == b[5] && b[8] == 0 && b[5] == 2) || (b[4] == b[0] && b[8] == 0 && b[4] == 2) || (b[6] == b[7] && b[8] == 0 && b[6] == 2)) {
        return 8
    } else if ((b[2] == b[4] && b[6] == 0 && b[2] == 2) || (b[8] == b[7] && b[6] == 0 && b[8] == 2) || (b[0] == b[3] && b[6] == 0 && b[0] == 2)) {
        return 6
    } else if ((b[0] == b[1] && b[2] == 0 && b[0] == 2) || (b[5] == b[8] && b[2] == 0 && b[5] == 2) || (b[4] == b[6] && b[2] == 0 && b[4] == 2)) {
        return 2
    } else if ((b[3] == b[5] && b[4] == 0 && b[5] == 2) || (b[1] == b[7] && b[4] == 0 && b[1] == 2) ||
        (b[0] == b[8] && b[4] == 0 && b[0] == 2) || (b[2] == b[6] && b[4] == 0 && b[2] == 2)
    ) {
        return 4
    }
    else if((b[3]==b[5] && b[4]==0 && b[5]==2) || (b[1]==b[7] && b[4]==0 && b[1]==2)||
        (b[0]==b[8] && b[4]==0 && b[0]==2) || (b[2]==b[6] && b[4]==0 && b[2]==2)
    ){
        return 4
    }
    else {
        return 10 // for no move for winning
    }

}

fun randomPlay(d:MutableList<Int>): Int{
    while(true){
        val randomPlace = (0..8).random()
        if (d[randomPlace]==0){
            return randomPlace

            break
        }
    }

}

fun embedder(b:MutableList<Int>): Int {
    if ((b[0] == b[2] && b[1] == 0 && b[0] == 1) || (b[4] == b[7] && b[1] == 0 && b[4] == 1)) {
        return 1
    } else if ((b[3] == b[4] && b[5] == 0 && b[3] == 1) || (b[2] == b[8] && b[5] == 0 && b[2] == 1)) {
        return 5
    } else if ((b[1] == b[2] && b[0] == 0 && b[1] == 1) || (b[3] == b[6] && b[0] == 0 && b[3] == 1) || (b[4] == b[8] && b[0] == 0 && b[4] == 1)) {
        return 0
    } else if ((b[1] == b[4] && b[7] == 0 && b[1] == 1) || (b[6] == b[8] && b[7] == 0 && b[6] == 1)) {
        return 7
    } else if ((b[5] == b[4] && b[3] == 0 && b[4] == 1) || (b[0] == b[6] && b[3] == 0 && b[0] == 1)) {
        return 3
    } else if ((b[2] == b[5] && b[8] == 0 && b[5] == 1) || (b[4] == b[0] && b[8] == 0 && b[4] == 1) || (b[6] == b[7] && b[8] == 0 && b[6] == 1)) {
        return 8
    } else if ((b[2] == b[4] && b[6] == 0 && b[2] == 1) || (b[8] == b[7] && b[6] == 0 && b[8] == 1) || (b[0] == b[3] && b[6] == 0 && b[0] == 1)) {
        return 6
    } else if ((b[0] == b[1] && b[2] == 0 && b[0] == 1) || (b[5] == b[8] && b[2] == 0 && b[5] == 1) || (b[4] == b[6] && b[2] == 0 && b[4] == 1)) {
        return 2
    } else if ((b[3] == b[5] && b[4] == 0 && b[5] == 1) || (b[1] == b[7] && b[4] == 0 && b[1] == 1) ||
        (b[0] == b[8] && b[4] == 0 && b[0] == 1) || (b[2] == b[6] && b[4] == 0 && b[2] == 1)
    ) {
        return 4
    } else {
        return 10 // for no need to embed
    }

}



