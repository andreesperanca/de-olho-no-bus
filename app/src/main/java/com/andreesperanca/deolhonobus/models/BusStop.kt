package com.andreesperanca.deolhonobus.models

data class BusStop(
    val id: Int,
    val name: String,
    val address: String,
    val latitude: Double,
    val longitude: Double
)
