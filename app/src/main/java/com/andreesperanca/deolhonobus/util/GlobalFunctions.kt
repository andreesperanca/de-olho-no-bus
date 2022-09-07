package com.andreesperanca.deolhonobus.util

import android.view.View
import com.google.android.material.snackbar.Snackbar
import java.time.Instant
import java.time.ZoneId

fun snackBarCreator(view: View, message: String) {
    Snackbar.make(view, message, Snackbar.LENGTH_LONG).show()
}

fun dateStringFormatter (dateString: String): String {
    val timestamp = Instant.parse(dateString).atZone(ZoneId.of(("America/Sao_Paulo")))
    val hour = "${timestamp.hour}:${timestamp.minute}"
    return hour
}