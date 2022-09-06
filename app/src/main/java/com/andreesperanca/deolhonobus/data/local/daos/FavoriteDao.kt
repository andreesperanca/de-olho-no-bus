package com.andreesperanca.deolhonobus.data.local.daos

import androidx.lifecycle.LiveData
import androidx.room.*
import com.andreesperanca.deolhonobus.models.BusLine
import kotlinx.coroutines.flow.Flow

@Dao
interface FavoriteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert (busLine: BusLine)

    @Query("SELECT * FROM busline")
    fun getBusLine() : LiveData<List<BusLine>>

    @Delete
    suspend fun deleteBusLine(busLine: BusLine)
}
