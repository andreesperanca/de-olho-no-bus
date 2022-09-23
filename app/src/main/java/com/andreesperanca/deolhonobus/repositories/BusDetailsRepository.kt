package com.andreesperanca.deolhonobus.repositories

import com.andreesperanca.deolhonobus.data.local.daos.FavoriteDao
import com.andreesperanca.deolhonobus.data.remote.RetrofitService
import com.andreesperanca.deolhonobus.models.BusLine
import com.andreesperanca.deolhonobus.models.BusStop
import com.andreesperanca.deolhonobus.models.Place
import com.andreesperanca.deolhonobus.repositories.SearchRepository.Authenticator.credential
import com.andreesperanca.deolhonobus.util.Resource
import com.andreesperanca.deolhonobus.util.apiCall
import com.google.android.gms.maps.model.LatLng
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.await
import javax.inject.Inject


class BusDetailsRepository @Inject constructor(
    private val service: RetrofitService,
    private val favoriteDao: FavoriteDao
) {

    suspend fun getBusStopWithBusLineCode(busLineCode: String): Resource<List<BusStop>> {
        return withContext(Dispatchers.IO) {
            apiCall {
                val fetchResult = service.getBusStopWithBusLineCode(credential,busLineCode).await()
                Resource.Success(fetchResult)
            }
        }
    }

    suspend fun getBusPositionWithBusLineCode(busLineCode: String): Resource<List<Place>> {
        return withContext(Dispatchers.IO) {
            apiCall {
                val resultFetch = service.getPositionBusLineWithBusLineCode(credential,busLineCode).await()
                val resultMap = mutableListOf<Place>()
                resultFetch.locations.let {
                    it.forEach {
                        val newPlace =
                            Place(
                                title = "Prefixo Veículo: ${it.prefixVehicle}",
                                lng = LatLng(it.py, it.px)
                            )
                        resultMap.add(newPlace)
                    }
                }
                Resource.Success(resultMap)
            }
        }
    }

    suspend fun favoriteBusLine(busLine: BusLine) {
        favoriteDao.favoriteBusLine(busLine)
    }

    fun deleteFavoriteBusLine(key: Int) {
        favoriteDao.deleteFavoriteBusLine(key)
    }

    fun favoriteVerify(key: Int): BusLine? = favoriteDao.favoriteBusLineVerify(key)
}