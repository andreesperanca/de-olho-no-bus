package com.andreesperanca.deolhonobus.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class BusRoute(
    val id: Int,
    val CircularRoute: Boolean,
    val firstLabel : String,
    val secondLabel: String,
    val direction: Int,
    val mainTerminal: String,
    val secondaryTerminal: String
) : Parcelable
