package com.andreesperanca.deolhonobus.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.andreesperanca.deolhonobus.data.local.daos.FavoriteDao
import com.andreesperanca.deolhonobus.models.BusLine
import com.andreesperanca.deolhonobus.models.BusStop

@Database(
    entities = [BusLine::class,BusStop::class],
    version = 1,
    exportSchema = false
)
abstract class FavoriteRoomDataBase : RoomDatabase() {
    abstract val favoriteDao: FavoriteDao

    companion object {

        @Volatile
        private var INSTANCE: FavoriteRoomDataBase? = null
    }
}