package furhatos.app.newskill11.flow.main


import furhatos.app.newskill11.flow.Parent

import furhatos.app.newskill11.flow.nlu.*
import furhatos.flow.kotlin.*
import furhatos.nlu.common.No
import furhatos.nlu.common.Yes
import java.security.SecureRandom
import furhatos.gestures.Gestures.getResourceGesture
import furhatos.*
import furhatos.gestures.Gestures
import furhatos.nlu.common.Greeting
import kotlin.random.Random


val correctAnswer = utterance {
    random{
        +Gestures.getResourceGesture("/ca1.json")!!
        +Gestures.getResourceGesture("/ca2.json")!!
        +Gestures.getResourceGesture("/ca3.json")!!
    }
}
val wrongAnswer = utterance {
    random{
        +Gestures.getResourceGesture("/wa1.json")!!
        +Gestures.getResourceGesture("/wa2.json")!!
    }
}


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
    "When did K works open?",
    "What is the total area of Koch University?",
    //Topic 2 Questions
    "During the period of April 2022 and April 2023 which institute has not collaborated with the KUIS A I Center?",
    "How many externally funded grants were awarded to KUIS A I Faculty members between April 2022 and April 2023?",
    "What was the total budget allocated for the externally funded grants received by KUIS AI Faculty during the period April 2022 and April 2023?",
    "How many GPUs does Koch University high-performance computation facility have?",
    "Which is not one of the research areas of the Koch University A I center?",
    "When was the Artificial Intelligence Center at Koç University established?",
    "Which institution partnered with Koç University to establish the Artificial Intelligence Center, aiming to combine scientific resources with financial support?",
    "which affiliated Lab is not one of the labs under the research area Systems and A I in A I Center",
    "How many projects are completed at Koch University after KUIS A I opened?",
    "How many alumni does KUIS A I center have?",
    //Topic 3 Questions
    "Who is known as one of the founders of artificial intelligence?",
    "Which of the following is not an example of A I ?",
    "In which of the following areas has A I work typically not been done?",
    "What is the primary goal of Natural Language Processing (NLP) in the field of A I ?",
    "What does the Turing Test measure?",
    "Who developed the Turing Test?",
    "Which A I technique is primarily used for clustering similar data points in unsupervised learning?",
    "Which of the following is a popular open-source machine learning library developed by Facebook?",
    "In the context of A I , what does neural, in neural network refer to?",
    "Which of the following is NOT a type of neural network architecture?"
)
var ta= listOf(
    //Topic 1 Answers
    listOf("18907","19197","19485",1),
    listOf("Umran İnan","Rahmi Koch","Vehbi Koch",2),
    listOf("2006","2007","2008",0),
    listOf("Business Club","I ES","Marketing Club",2),
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
    listOf("Natural Language Processing","Human-Computer Interaction","A I Ethics and Fairness",2),
    listOf("January 2020","February 2019","February 2020",2),
    listOf("Ziraat Bankasuh", "Yapı Kredi Bankasuh", "İsh Bankasuh", 2),
    listOf("ParCore Lab", "DISNET", "M V G L ", 2),
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

val PreGreeting: State =state(Parent){
    onEntry{
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
        delay(50)
        furhat.say("Welcome to A I center. My name is Furhat.")
        goto(Greeting)
    }
}

val Greeting: State = state(Parent) {

    onEntry {


        furhat.say("I can make jokes, play tictactoe with you, play number guessing game with you, or give you a quiz about our university and a i .")
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
        goto(QuizInfoState)
    }

}

var PostPlaying : State= state(Parent) {

    onEntry {
        delay(1000)
        furhat.ask("Do you want to try other games ?")
    }
    onResponse<Yes> {
        furhat.say("I'm glad to hear that")
        goto(Greeting)
    }
    onResponse<No> {
        furhat.say("Okey. Thank you for playing with me ")
        delay(10000)
        goto(Greeting)
    }


}







// ****************** quiz game ******************

val QuizInfoState: State = state(Parent) {
    onEntry{
        furhat.say("In this quiz game I will ask you three questions. " +
                "the first question is about our university"
        )
        delay(200)
        furhat.say("the second question is about the A I center")
        delay(200)
        furhat.say("the last question is about artificial intelligence")
        delay(100)
        furhat.say("Please when you are giving answer,say a, b, or c. But you can also say, option a, option b, or option c")
        delay(100)
        furhat.say("good luck")
        delay(100)
        furhat.say(" the quiz is starting now")
        delay(200)
        goto(Quiz)
    }
}
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
                delay(500)
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
                furhat.ask("Tell your answer.")
            }
        }
        else if (qn==2){
            if (qcount==0){
                qcount++
                val secureRandom = SecureRandom()
                num = secureRandom.nextInt(9)+10
                furhat.say("question 2. ")
                delay(500)
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
                val secureRandom = SecureRandom()
                num = secureRandom.nextInt(9)+20
                furhat.say("question 3. ")
                delay(500)
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
            delay(200)
            furhat.say("Out of 3 questions, you have found the correct answer for, "+ numberToWordMap[cqn]+" times!")
            delay(200)
            if(cqn==0) {
                furhat.say("Don't worry. You can play another time again!")
            }
            else if(cqn==1) {
                furhat.say("You didn't do too bad")
            }
            else if(cqn==2) {
                furhat.say("You did quite a good job. Congratulations!")
            }
            else if(cqn==3) {
                furhat.say("3 correct questions? You were excellent. Congratulations!")
            }

            delay(2000)
            goto(PostPlaying)
        }
    }
    onResponse<A> {
        qn++
        var co=ta[num][3]
        qcount=0
        if(co==0){
            furhat.say(correctAnswer)
            delay(2000)
            furhat.say("Correct !")
            delay(2300)
            cqn++
        }
        else{

            furhat.say(wrongAnswer)
            delay(2000)
            furhat.say("False. ")
            delay(2200)
            furhat.say("the correct answer was")
            delay(50)
            furhat.say(""+ta[num][co as Int])
            delay(300)


        }
        reentry()
    }
    onResponse<B> {
        qn++
        var co=ta[num][3]
        qcount=0
        if(co==1){

            furhat.say(correctAnswer)
            delay(2000)
            furhat.say("Correct !")
            delay(2300)
            cqn++
        }
        else{
            furhat.say(wrongAnswer)
            delay(2000)
            furhat.say("False. ")
            delay(2200)
            furhat.say("the correct answer was")
            delay(50)
            furhat.say(""+ta[num][co as Int])
            delay(300)

        }
        reentry()
    }
    onResponse<C> {
        qn++
        var co=ta[num][3]
        qcount=0
        if(co==2){
            furhat.say(correctAnswer)
            delay(2000)
            furhat.say("Correct !")
            delay(2300)
            cqn++
        }
        else{
            furhat.say(wrongAnswer)
            delay(2000)
            furhat.say("False. ")
            delay(2200)
            furhat.say("the correct answer was")
            delay(50)
            furhat.say(""+ta[num][co as Int])
            delay(300)
        }
        reentry()
    }



}








// ****************** tic tac toe game ******************
val TicTacToe: State = state(Parent){
    onEntry {
        furhat.say("I think tic tac toe is a fun game. Since I am a very intelligent robot, I can memorize which moves" +
                " have been made. But to make it easy for you, I have a pen and paper next to me." +
                " The paper has tic tac toe template. Each number represent a box" +
                " You can use them to write the moves" +
                " and tell me the box number when choosing one place"
        )
        delay(150)
        furhat.say(" and lastly. the game has 2 modes which are easy and hard mode")
        furhat.say("Which mode do you want to play")
        delay(150)
        furhat.ask("Easy or hard?")


    }
    onResponse<EasyIntent>(){
        delay(200)
        furhat.say("okay. I'll go easy on you")
        goto(TTTStartEasy)
    }
    onResponse<HardIntent> {
        delay(200)
        furhat.say("Hmm. You are confident.")
        delay(100)
        furhat.say("Let's see")
        delay(200)
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
            furhat.say("You won the game")
            goto(endWithWinner)
        }
        else if (winChecker(tttList)==2){
            furhat.say("I won the game")
            goto(endWithWinner)
        }
        else {
            furhat.ask({
                random(
                    +"where are you choosing",
                    "choose a box",
                    "choose",
                    "Which box are you choosing"
                )
            })
        }
    }
    onResponse<One>{
        if(tttList[0]==1 || tttList[0]==2){
            furhat.say("that box is full, choose another box")
            reentry()
        }
        else{
            tttList[0]=1
            goto(robotPlaying)
        }
    }
    onResponse<Two>{
        if(tttList[1]==1 || tttList[1]==2){
            furhat.say("that box is full, choose another box")
            reentry()
        }
        else{
            tttList[1]=1
            goto(robotPlaying)
        }
    }
    onResponse<Three>{
        if(tttList[2]==1 || tttList[2]==2){
            furhat.say("that box is full, choose another box")
            reentry()
        }
        else{
            tttList[2]=1
            goto(robotPlaying)
        }
    }
    onResponse<Four>{
        if(tttList[3]==1 || tttList[3]==2){
            furhat.say("that box is full, choose another box")
            reentry()
        }
        else{
            tttList[3]=1
            goto(robotPlaying)
        }
    }
    onResponse<Five>{
        if(tttList[4]==1 || tttList[4]==2){
            furhat.say("that box is full, choose another box")
            reentry()
        }
        else{
            tttList[4]=1
            goto(robotPlaying)
        }
    }
    onResponse<Six>{
        if(tttList[5]==1 || tttList[5]==2){
            furhat.say("that box is full, choose another box")
            reentry()
        }
        else{
            tttList[5]=1
            goto(robotPlaying)
        }
    }
    onResponse<Seven>{
        if(tttList[6]==1 || tttList[6]==2){
            furhat.say("that box is full, choose another box")
            reentry()
        }
        else{
            tttList[6]=1
            goto(robotPlaying)
        }
    }
    onResponse<Eight>{
        if(tttList[7]==1 || tttList[7]==2){
            furhat.say("that box is full, choose another box")
            reentry()
        }
        else{
            tttList[7]=1
            goto(robotPlaying)
        }
    }
    onResponse<Nine>{
        if(tttList[8]==1 || tttList[8]==2){
            furhat.say("that box is full, choose another box")
            reentry()
        }
        else{
            tttList[8]=1
            goto(robotPlaying)
        }
    }
    onNoResponse {
        furhat.say("Only numbers from 1 to 9")
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

val TTTStartEasy: State = state(Parent){
    onEntry{
        //add winchecker
        println(tttList)
        if(tttList.contains(0)==false){
            furhat.say("tie")
            goto(endWithTie)
        }
        else if (winChecker(tttList) == 1) {
            furhat.say("You won the game")
            goto(endWithWinner)
        }
        else if (winChecker(tttList)==2){
            furhat.say("I won the game")
            goto(endWithWinner)
        }
        else {
            furhat.ask({
                random(
                    +"where are you choosing",
                    "choose a box",
                    "choose",
                    "Which box are you choosig"
                )
            })
        }
    }
    onResponse<One>{
        if(tttList[0]==1 || tttList[0]==2){
            furhat.say("that box is full, choose another box")
            reentry()
        }
        else{
            tttList[0]=1
            goto(robotPlayingEasy)
        }
    }
    onResponse<Two>{
        if(tttList[1]==1 || tttList[1]==2){
            furhat.say("that box is full, choose another box")
            reentry()
        }
        else{
            tttList[1]=1
            goto(robotPlayingEasy)
        }
    }
    onResponse<Three>{
        if(tttList[2]==1 || tttList[2]==2){
            furhat.say("that box is full, choose another box")
            reentry()
        }
        else{
            tttList[2]=1
            goto(robotPlayingEasy)
        }
    }
    onResponse<Four>{
        if(tttList[3]==1 || tttList[3]==2){
            furhat.say("that box is full, choose another box")
            reentry()
        }
        else{
            tttList[3]=1
            goto(robotPlayingEasy)
        }
    }
    onResponse<Five>{
        if(tttList[4]==1 || tttList[4]==2){
            furhat.say("that box is full, choose another box")
            reentry()
        }
        else{
            tttList[4]=1
            goto(robotPlayingEasy)
        }
    }
    onResponse<Six>{
        if(tttList[5]==1 || tttList[5]==2){
            furhat.say("that box is full, choose another box")
            reentry()
        }
        else{
            tttList[5]=1
            goto(robotPlayingEasy)
        }
    }
    onResponse<Seven>{
        if(tttList[6]==1 || tttList[6]==2){
            furhat.say("that box is full, choose another box")
            reentry()
        }
        else{
            tttList[6]=1
            goto(robotPlayingEasy)
        }
    }
    onResponse<Eight>{
        if(tttList[7]==1 || tttList[7]==2){
            furhat.say("that box is full, choose another box")
            reentry()
        }
        else{
            tttList[7]=1
            goto(robotPlayingEasy)
        }
    }
    onResponse<Nine>{
        if(tttList[8]==1 || tttList[8]==2){
            furhat.say("that box is full, choose another box")
            reentry()
        }
        else{
            tttList[8]=1
            goto(robotPlayingEasy)
        }
    }
    onNoResponse {
        furhat.say("Only numbers from 1 to 9")
        reentry()
    }


}

val robotPlayingEasy: State = state(Parent){
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
            var rNum= randomPlay(tttList)
            tttList[rNum]=2
            furhat.say("I'm choosing " + numberToWordMap[rNum+1])
            delay(1500)
            goto(TTTStartEasy)
        }
    }
}


val endWithWinner:State = state(Parent){
    onEntry {
        furhat.say("the game ends")
        tttList=mutableListOf(0,0,0,0,0,0,0,0,0)
        goto(PostPlaying)
    }
}

val endWithTie:State = state(Parent){
    onEntry {
        furhat.say("the game ends")
        tttList=mutableListOf(0,0,0,0,0,0,0,0,0)
        goto(PostPlaying)
    }
}






// ****************** number guessing game ******************
val binaryGame: State = state(Parent) {


    onEntry {
        if(mIn!=mAx){
            goto(Searcher)
        }
        furhat.say("I think I found your number")
        furhat.ask("Is your number "+ numberToWordMap[mIn])
    }
    onResponse<Yes> {
        goto(Found);
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
        delay(1500)
        furhat.ask("Do you want to know how I found your number")


    }
    onResponse<No>(){
        goto(PostPlaying)
    }
    onResponse<Yes>(){
        furhat.say("I used binary search algorihtm to find your number" +
                "When I ask you if your number is graeter than a number, according to your answer, " +
                "each time, I got rid of the one half of the possibilities. which gives me logarithmic complexity" +
                "By doing that, in the worst case, I can find your " +
                "answer, at most 7 trials. ")
        delay(300)
        furhat.say("How wonderful!")
        delay(2000)
        goto(PostPlaying)
    }



}

val Searcher: State = state(Parent) {
    onEntry{
        nOfGuesses+=1;
        furhat.ask("Is your  number greater than "+numberToWordMap[middle])

    }
    onResponse(listOf(Yes(),UpIntent())){
        mIn=middle+1
        middle=(mIn+mAx)/2
        goto(binaryGame)
    }
    onResponse(listOf(No(),DownIntent())) {
        mAx=middle
        middle=(mAx+mIn)/2
        goto(binaryGame)
    }
}

//  ****************** joke generator  ******************
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
        goto(PostPlaying)
    }
}


//  ****************** functions for tictactoe  ******************
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
        val secureRandom = SecureRandom()

        val randomPlace = secureRandom.nextInt(8)
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



