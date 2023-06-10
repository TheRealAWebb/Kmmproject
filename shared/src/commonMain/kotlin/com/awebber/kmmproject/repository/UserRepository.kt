package com.awebber.kmmproject.repository

import com.awebber.kmmproject.AppClient

interface UserRepository {

    /**
     * Sign the user In
     */
    fun signIn(email: String, password: String)

    /**
     * Sign the user In as a guest
     */
    fun signInAsGuest()


    suspend fun test(): String
}

class UserRepositoryImpl() : UserRepository {
    val client by lazy {
        AppClient()
    }

    /**
     * Sign the user In
     */
    override fun signIn(email: String, password: String) {

    }


    /**
     * Sign the user In as a guest
     */

    override fun signInAsGuest() {
    }

    override suspend fun test(): String {
        return client.greeting()
    }

}

/** Example Use
 *  val scope = rememberCoroutineScope()
 *  var response by remember { mutableStateOf("Loading") }
 *  LaunchedEffect(true) {
 *  scope.launch {
 *  response = try {
 *  AppClient().greeting()
 *  } catch (e: Exception) {
 *  e.message ?: "error"
 *                          }
 *              }
 *                      }
 *  Text(text = response)
 **/