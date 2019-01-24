package com.dleal.kataloginout

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), AuthView {

    private val loginValidator by lazy { LoginValidator() }
    private val timeProvider by lazy { TimeProvider() }
    private val logoutValidator by lazy { LogoutValidator(timeProvider) }

    private val authPresenter by lazy { AuthPresenter(this, loginValidator, logoutValidator) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_login.setOnClickListener {
            authPresenter.onLogInButtonClick()
            hideKeyboard(this)
        }

        btn_logout.setOnClickListener {
            authPresenter.onLogOutButtonClick()
        }
    }

    override fun showLogInForm() {
        login_group.show()
    }

    override fun showLogOutForm() {
        btn_logout.show()
    }

    override fun hideLogInForm() {
        login_group.hide()
    }

    override fun hideLogOutForm() {
        btn_logout.hide()
    }

    override fun clearLogInForm() {
        edit_username.clear()
        edit_password.clear()
    }

    override fun showError(errorMessage: String) {
        Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT).show()
    }

    override fun getUsername(): String = edit_username.editText?.text.toString()

    override fun getPassword(): String = edit_password.editText?.text.toString()

    private fun hideKeyboard(activity: Activity) {
        val inputMethodManager = activity.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager

        //Find the currently focused view, so we can grab the correct window token from it.
        val view = activity.currentFocus ?: View(activity)

        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }

}