package com.awebber.kmmproject.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.awebber.kmmproject.AppClient
import com.awebber.kmmproject.components.email.Email
import com.awebber.kmmproject.components.email.EmailState
import com.awebber.kmmproject.components.email.EmailStateSaver
import com.awebber.kmmproject.components.password.Password
import com.awebber.kmmproject.components.password.PasswordState
import com.awebber.kmmproject.sign_in
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

@OptIn(ExperimentalResourceApi::class)
@Composable
fun LoginScreen() {
   // Scaffold(
   //     topBar = {},
   //     bottomBar = {}
   // ) {  innerPadding ->
//
   // }


    val emailState by rememberSaveable(stateSaver = EmailStateSaver) {
        mutableStateOf(EmailState())
    }
    val passwordState = remember { PasswordState() }
    val onSubmit: () -> Unit = {
        if (emailState.isValid && passwordState.isValid) {
            //TODO: Add some Logic
        } else {
            emailState.enableShowErrors()
            passwordState.showErrors()
        }
    }
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.surface,
        shape = RoundedCornerShape(8.dp),
    ) {
        val scope = rememberCoroutineScope()
        var response by remember { mutableStateOf("Loading") }
        LaunchedEffect(true) {
            scope.launch {
                response = try {
                    AppClient().greeting()
                } catch (e: Exception) {
                    e.message ?: "error"
                }
            }
        }
        Text(text = response)
        Column(
            Modifier.width(300.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                modifier = Modifier
                    .width(300.dp)
                    .height(200.dp),
                painter = painterResource(res = "logo.xml"),
                contentDescription = null
            )
            Email(emailState = emailState)
            Spacer(Modifier.height(8.dp))
            Password(passwordState = passwordState)
            Spacer(Modifier.height(8.dp))
            Button(
                modifier = Modifier
                    .width(150.dp),
                onClick = onSubmit,
                enabled = passwordState.isValid && emailState.isValid
            ) {
                Text(text = sign_in)
            }

        }
    }
}
