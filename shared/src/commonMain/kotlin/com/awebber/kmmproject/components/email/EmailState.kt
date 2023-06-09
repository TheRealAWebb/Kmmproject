package com.awebber.kmmproject.components.email

import com.awebber.kmmproject.components.core.TextFieldState
import com.awebber.kmmproject.components.core.textFieldStateSaver

private val EMAIL_VALIDATION_REGEX = "^[\\w-.]+(\\+[A-Za-z]*)?@([\\w-]+\\.)+[\\w-]{2,4}$".toRegex()

class EmailState(val email: String? = null) :
    TextFieldState(
        validator = ::isEmailValid,
        errorFor = ::emailValidationError
    ) {
    init {
        email?.let {
            text = it
        }
    }

}

/**
 * Returns an error to be displayed or null if no error was found
 */
private fun emailValidationError(email: String): String {
    return "Invalid email: $email"
}

private fun isEmailValid(email: String): Boolean {
    return EMAIL_VALIDATION_REGEX.matches(email)
}

val EmailStateSaver = textFieldStateSaver(EmailState())