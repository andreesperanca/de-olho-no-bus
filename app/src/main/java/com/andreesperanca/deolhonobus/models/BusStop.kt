package com.andreesperanca.deolhonobus.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class BusStop(
    val id: Int,
    val name: String,
    val address: String,
    val latitude: Double,
    val longitude: Double
) : Parcelable
