package com.dleal.kataloginout

import kotlinx.coroutines.*

class AuthPresenter(
    private val view: AuthView,
    private val loginValidator: LoginValidator,
    private val logoutValidator: LogoutValidator
) : CoroutineScope by MainScope() {

    fun onLogInButtonClick(): Job {
        val username = view.getUsername()
        val password = view.getPassword()

        return launch {
            coroutineScope {
                delay(DELAY)
                validateCredentials(username, password)
            }
        }
    }

    fun onLogOutButtonClick() = launch {
        coroutineScope {
            delay(DELAY)
            validateLogOut()
        }
    }

    private fun validateCredentials(username: String, password: String) {
        if (loginValidator.performLogin(username, password)) {
            //Success
            logIn()
        } else {
            //Error
            view.showError(WRONG_CREDENTIALS_MESSAGE)
        }
    }

    private fun validateLogOut() {
        if (logoutValidator.performLogout()) {
            logOut()
        }
    }

    private fun logIn() {
        view.showLogOutForm()
        view.hideLogInForm()
    }

    private fun logOut() {
        view.clearLogInForm()
        view.showLogInForm()
        view.hideLogOutForm()
    }
}

private const val WRONG_CREDENTIALS_MESSAGE = "Invalid credentials"
private const val DELAY = 1000L