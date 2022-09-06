package com.andreesperanca.deolhonobus.repositories

import androidx.lifecycle.LiveData
import com.andreesperanca.deolhonobus.data.local.daos.FavoriteDao
import com.andreesperanca.deolhonobus.models.BusLine

class BusDetailsRepository(
    private val favoriteDao : FavoriteDao) {

    val getFavoritesBusLine: LiveData<List<BusLine>> = favoriteDao.getBusLine()

    suspend fun favoriteBusLine(busLine: BusLine) { favoriteDao.insert(busLine) }

    suspend fun deleteBusLine(busLine: BusLine) {favoriteDao.deleteBusLine(busLine)}

}