package com.andreesperanca.deolhonobus.di.modules

import androidx.room.Room
import com.andreesperanca.deolhonobus.data.local.FavoriteRoomDataBase
import org.koin.dsl.module

val appModules = module {

    single<FavoriteRoomDataBase> {
        Room.databaseBuilder(
            get(),
            FavoriteRoomDataBase::class.java,
            "favorite-db"
        ).build()
    }
}