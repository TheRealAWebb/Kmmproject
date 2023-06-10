package com.awebber.kmmproject

import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.statement.bodyAsText

class AppClient {

    private val client = HttpClient()
      suspend fun greeting(): String {
        val response = client.get("https://ktor.io/docs/")
        return response.bodyAsText()

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
 *
 */
//
