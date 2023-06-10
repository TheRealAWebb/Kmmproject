package com.awebber.kmmproject.signin

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.awebber.kmmproject.components.core.textFieldStateSaver
import com.awebber.kmmproject.components.email.EmailState
import com.awebber.kmmproject.repository.UserRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class SignInViewModel(
    private val userRepository: UserRepository
) {

    var text by mutableStateOf("")
    val emailStateSaver = textFieldStateSaver(EmailState())


    fun signIn(email: String, password: String) {

    }

    fun signInAsGuest() {
        userRepository.signInAsGuest()
    }

    fun test(scope: CoroutineScope) {
        scope.launch {
            text = try {
                userRepository.test()
            } catch (e: Exception) {
                e.message ?: "error"
            }
        }
    }
}
