package com.andreesperanca.deolhonobus.di.modules

import android.content.Context
import androidx.room.Room
import com.andreesperanca.deolhonobus.data.local.FavoriteRoomDataBase
import com.andreesperanca.deolhonobus.data.local.daos.FavoriteDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    @Singleton
    @Provides
    fun providesRoomService(@ApplicationContext context : Context): FavoriteDao {
        return Room.databaseBuilder(
            context,
            FavoriteRoomDataBase::class.java,
            "favorite-db"
        ).build().favoriteDao
    }
}