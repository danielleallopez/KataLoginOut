package com.dleal.kataloginout

class AuthPresenter(
    private val view: AuthView,
    private val loginValidator: LoginValidator,
    private val logoutValidator: LogoutValidator
) {

    fun onLogInButtonClick() {
        val username = view.getUsername()
        val password = view.getPassword()

        if (loginValidator.performLogin(username, password)) {
            //Success
            logIn()
        } else {
            //Error
            view.showError(WRONG_CREDENTIALS_MESSAGE)
        }
    }

    fun onLogOutButtonClick() {
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