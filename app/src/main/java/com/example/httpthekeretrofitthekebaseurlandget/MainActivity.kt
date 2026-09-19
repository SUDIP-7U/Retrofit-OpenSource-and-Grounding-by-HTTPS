package com.example.httpthekeretrofitthekebaseurlandget

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.httpthekeretrofitthekebaseurlandget.quiz.QuizScreen
import com.example.httpthekeretrofitthekebaseurlandget.ui.theme.HttpThekeRetrofitThekeBASeURlAndGETTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HttpThekeRetrofitThekeBASeURlAndGETTheme {


                QuizScreen()


            }
        }
    }
}

