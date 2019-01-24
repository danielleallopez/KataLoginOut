package com.dleal.kataloginout

import android.os.Bundle
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
                Toast.makeText(this, "SUCCESS", Toast.LENGTH_SHORT).show()
            } else {
                //ERROR
                Toast.makeText(this, "ERROR", Toast.LENGTH_SHORT).show()
            }
        }
    }
}

private const val USERNAME = "admin"
private const val PASSWORD = "admin"