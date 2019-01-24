package com.dleal.kataloginout

class LoginValidator {

    fun performLogin(username: String, password: String): Boolean =
        username == USERNAME && password == PASSWORD
}

private const val USERNAME = "admin"
private const val PASSWORD = "admin"