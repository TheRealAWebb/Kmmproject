package com.awebber.kmmproject.signin

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
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.awebber.kmmproject.components.email.Email
import com.awebber.kmmproject.components.email.EmailState
import com.awebber.kmmproject.components.password.Password
import com.awebber.kmmproject.components.password.PasswordState
import com.awebber.kmmproject.sign_in
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

//
@OptIn(ExperimentalResourceApi::class)
@Composable
fun SignInScreen(
    viewModel: SignInViewModel,
) {

    val emailState by rememberSaveable(stateSaver = viewModel.emailStateSaver) {
        mutableStateOf(EmailState())
    }
    val passwordState = remember { PasswordState() }
    val scope = rememberCoroutineScope()

    val onSubmit: () -> Unit = {
        if (emailState.isValid && passwordState.isValid) {
            try {
                viewModel.test(scope)
            } catch (e: Exception) {
                e.message ?: "error"
            }
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

            Text(text = viewModel.text)
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

