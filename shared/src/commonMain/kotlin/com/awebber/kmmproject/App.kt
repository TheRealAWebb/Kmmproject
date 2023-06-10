package com.awebber.kmmproject

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import com.awebber.kmmproject.repository.UserRepositoryImpl
import com.awebber.kmmproject.signin.SignInScreen
import com.awebber.kmmproject.signin.SignInViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun App() {
    MyApplicationTheme {
        Scaffold() {
            SignInScreen(
                SignInViewModel(
                    UserRepositoryImpl(),

                )
            )
        }
    }
}
