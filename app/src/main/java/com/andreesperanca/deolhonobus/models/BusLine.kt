package com.andreesperanca.deolhonobus.models

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "busLine")
data class BusLine(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val busLineNumber: Int,
    val CircularRoute: Boolean,
    val firstLabel : String,
    val secondLabel: String,
    val direction: Int,
    val mainTerminal: String,
    val secondaryTerminal: String
) : Parcelable
