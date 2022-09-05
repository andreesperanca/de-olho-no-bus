package com.andreesperanca.deolhonobus.data.local.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.andreesperanca.deolhonobus.models.BusLine
import kotlinx.coroutines.flow.Flow

@Dao
interface FavoriteDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert (busLine: BusLine)

    @Query("SELECT * FROM favorite")
    suspend fun getBusLine() : Flow<List<BusLine>>


}
