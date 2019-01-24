package com.dleal.kataloginout

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_login.setOnClickListener {
            val username = edit_username.editText?.text.toString()
            val password = edit_password.editText?.text.toString()

            if (username == USERNAME && password == PASSWORD) {
                //Success
                login()
            } else {
                //Error
                Toast.makeText(this, "Invalid credentials", Toast.LENGTH_SHORT).show()
            }

            hideKeyboard(this)
        }

        btn_logout.setOnClickListener {
            val timeMillis = System.currentTimeMillis()
            if (timeMillis % 2 == 0L) {
                logout()
            }
        }
    }

    private fun login() {
        login_group.hide()
        btn_logout.show()
    }

    private fun logout() {
        login_group.show()
        btn_logout.hide()

        edit_username.clear()
        edit_password.clear()
    }

    private fun hideKeyboard(activity: Activity) {
        val inputMethodManager = activity.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager

        //Find the currently focused view, so we can grab the correct window token from it.
        val view = activity.currentFocus ?: View(activity)

        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }

}

private const val USERNAME = "admin"
private const val PASSWORD = "admin"