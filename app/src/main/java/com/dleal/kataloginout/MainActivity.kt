package com.dleal.kataloginout

import android.os.Bundle
import android.view.View
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
                login_group.hide()
                btn_logout.show()
            } else {
                //Error
                login_group.show()
                btn_logout.hide()
            }
        }
    }
}

private const val USERNAME = "admin"
private const val PASSWORD = "admin"

fun View.show(){
    this.visibility = View.VISIBLE
}

fun View.hide(){
    this.visibility = View.GONE
}