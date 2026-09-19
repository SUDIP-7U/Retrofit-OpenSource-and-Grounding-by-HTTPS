package com.example.httpthekeretrofitthekebaseurlandget.quiz

import androidx.compose.ui.unit.dp
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier


data class Question(
    val text: String,
    val options: List<String>,
    val answer: Int
)

@Composable
fun QuizScreen() {
    val questions = listOf(
        Question(
            text = "Retrofit-এর @GET annotation আসলে কী কাজ করে?",
            options = listOf("HTTP request পাঠায়", "Declare করে proxy বানায়", "Server state পরিবর্তন করে", "Cache clear করে"),
            answer = 1
        ),
        Question(
            text = "HTTP GET method-এর মূল property কী?",
            options = listOf("Safe, Idempotent, Cacheable", "Server state পরিবর্তন করে", "POST shortcut", "Retrofit invention"),
            answer = 0
        ),
        Question(
            text = "Retrofit internally কোন library ব্যবহার করে network call execute করে?",
            options = listOf("Volley", "OkHttp", "Gson", "Retrofit নিজেই"),
            answer = 1
        ),
        Question(
            text = "Developer-এর কাজ কীভাবে কমে যায় Retrofit @GET annotation ব্যবহার করলে?",
            options = listOf("Manual request build করতে হয় না", "JSON parsing auto হয়", "Async call সহজ হয়", "উপরের সবগুলো"),
            answer = 3
        ),
        Question(
            text = "নিচের কোন statement সঠিক?",
            options = listOf(
                "Retrofit-এর @GET annotation হলো আসল HTTP GET method",
                "Retrofit-এর @GET annotation হলো shortcut, আসল backbone HTTP GET",
                "HTTP GET method Retrofit-এর invention",
                "Retrofit ছাড়া HTTP GET কাজ করে না"
            ),
            answer = 1
        ),
        // নতুন প্রশ্ন ৬
                Question(text = "Retrofit কি internally OkHttp use করে?",
                    options = listOf("Yes it does", "No"),
                    answer = 0
    ),
    // নতুন প্রশ্ন ৭
    Question(
        text = "OkHttp এখানে কী করে, যখন Retrofit library ব্যবহার হয়?",
        options = listOf(
            "idle থাকে",
            "কিছুই করে না",
            "connection তৈরি, request পাঠানো, response আনা, caching, interceptors, error handling — সব OkHttp করে। ",
            "Do Nothing"
        ),
        answer = 2
    )
    )

    var currentIndex by remember { mutableIntStateOf(0) }
    var selectedOption by remember { mutableIntStateOf(-1) }
    var score by remember { mutableIntStateOf(0) }

    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = "Quiz App", style = MaterialTheme.typography.headlineSmall)

        Spacer(modifier = Modifier.height(16.dp))

        val question = questions[currentIndex]
        Text(text = question.text, style = MaterialTheme.typography.bodyLarge)

        Spacer(modifier = Modifier.height(8.dp))

        question.options.forEachIndexed { index, option ->
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { selectedOption = index }
                    .padding(8.dp)
            ) {
                RadioButton(
                    selected = selectedOption == index,
                    onClick = { selectedOption = index }
                )
                Text(text = option)
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            if (selectedOption == question.answer) {
                score++
            }
            if (currentIndex < questions.size - 1) {
                currentIndex++
                selectedOption = -1
            }
        }) {
            Text("Next")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Score: $score/${questions.size}")
    }
}
