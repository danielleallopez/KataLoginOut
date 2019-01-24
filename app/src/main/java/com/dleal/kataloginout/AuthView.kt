package com.dleal.kataloginout

interface AuthView {

    fun showLogInForm()
    fun showLogOutForm()
    fun hideLogInForm()
    fun hideLogOutForm()

    fun clearLogInForm()

    fun showError(errorMessage: String)

    fun getUsername(): String
    fun getPassword(): String
}