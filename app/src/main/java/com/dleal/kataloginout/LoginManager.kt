package com.dleal.kataloginout

class LoginValidator {

    fun performLogin(username: String, password: String): Boolean =
        username == USERNAME && password == PASSWORD
}

class LogoutValidator(private val timeProvider: TimeProvider) {

    fun performLogout(): Boolean {
        return timeProvider.getTimeMillis() % 2 == 0L
    }
}

class TimeProvider() {
    fun getTimeMillis() = System.currentTimeMillis()
}

private const val USERNAME = "admin"
private const val PASSWORD = "admin"