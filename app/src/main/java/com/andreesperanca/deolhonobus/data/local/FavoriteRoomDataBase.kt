package com.andreesperanca.deolhonobus.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.andreesperanca.deolhonobus.data.local.daos.FavoriteDao
import com.andreesperanca.deolhonobus.models.BusLine
import com.andreesperanca.deolhonobus.models.BusStop

@Database(entities = [BusStop::class, BusLine::class], version = 1, exportSchema = false)
abstract class FavoriteRoomDataBase : RoomDatabase() {

    abstract fun favoriteDao() : FavoriteDao

    companion object {
        @Volatile
        private var INSTANCE: FavoriteRoomDataBase? = null

        fun getDatabase(context: Context): FavoriteRoomDataBase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    FavoriteRoomDataBase::class.java,
                    "marketList_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
