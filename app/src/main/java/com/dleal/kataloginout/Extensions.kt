package com.dleal.kataloginout

import android.view.View
import com.google.android.material.textfield.TextInputLayout

fun View.show(){
    this.visibility = View.VISIBLE
}

fun View.hide(){
    this.visibility = View.GONE
}

fun TextInputLayout.clear(){
    this.editText?.setText("")
}