package com.andreesperanca.deolhonobus.repositories

import com.andreesperanca.deolhonobus.data.local.daos.FavoriteDao
import com.andreesperanca.deolhonobus.models.BusLine

class BusDetailsRepository(
    private val favoriteDao : FavoriteDao) {

    suspend fun favoriteBusLine(busLine: BusLine) {
        favoriteDao.insert(busLine)
    }

    suspend fun getFavoritesBusLine() {
        favoriteDao.getBusLine()
    }
}