package com.andreesperanca.deolhonobus.repositories

import com.andreesperanca.deolhonobus.data.remote.RetrofitService
import com.andreesperanca.deolhonobus.models.BusStop
import com.andreesperanca.deolhonobus.models.Place
import com.andreesperanca.deolhonobus.util.Resource
import com.andreesperanca.deolhonobus.util.apiCall
import com.google.android.gms.maps.model.LatLng
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.await

class BusDetailsRepository(private val service: RetrofitService) {

    suspend fun getBusStopWithBusLineCode(codigoLinha: String): Resource<List<BusStop>> {
        return withContext(Dispatchers.IO) {
            apiCall {
                val fetchResult = service.getBusStopWithBusLineCode(codigoLinha).await()
                Resource.Success(fetchResult)
            }
        }
    }

    suspend fun getBusPositionWithBusLineCode(busLineCode: String): Resource<List<Place>> {
        return withContext(Dispatchers.IO) {
            apiCall {
                val resultFetch = service.getPositionBusLineWithBusLineCode(busLineCode).await()
                val resultMap = mutableListOf<Place>()
                resultFetch.locations?.let { it.forEach {
                    val newPlace = Place(title = it.hourLastLocation, lng = LatLng(it.py,it.px))
                    resultMap.add(newPlace)
                } }
                Resource.Success(resultMap)
            }
        }
    }

}