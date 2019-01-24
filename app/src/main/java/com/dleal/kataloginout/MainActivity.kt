package com.dleal.kataloginout

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_login.setOnClickListener {
            val username = edit_username.editText?.text ?: ""
            val password = edit_password.editText?.text ?: ""

            if (username == USERNAME && password == PASSWORD) {
                //Success
            } else {
                //ERROR
            }
        }
    }
}

private const val USERNAME = "admin"
private const val PASSWORD = "admin"