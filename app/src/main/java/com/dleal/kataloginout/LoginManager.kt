package com.dleal.kataloginout

class LoginValidator {

    fun performLogin(username: String, password: String): Boolean =
        username == USERNAME && password == PASSWORD
}

class LogoutValidator() {
    fun performLogout(): Boolean {
        val timeMillis = System.currentTimeMillis()
        return timeMillis % 2 == 0L
    }
}

private const val USERNAME = "admin"
private const val PASSWORD = "admin"