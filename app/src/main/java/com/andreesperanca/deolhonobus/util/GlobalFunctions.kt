package com.andreesperanca.deolhonobus.util

import android.view.View
import com.google.android.material.snackbar.Snackbar

fun snackBarCreator(view: View, message: String) {
    Snackbar.make(view, message, Snackbar.LENGTH_LONG).show()
}