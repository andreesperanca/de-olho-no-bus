package com.andreesperanca.deolhonobus.models

data class BusRoute(
    val id: Int,
    val CircularRoute: Boolean,
    val firstLabel : String,
    val secondLabel: String,
    val direction: Int,
    val mainTerminal: String,
    val secondaryTerminal: String
)
