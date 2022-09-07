package com.andreesperanca.deolhonobus.repositories

import android.text.format.DateFormat
import com.andreesperanca.deolhonobus.data.remote.RetrofitService
import com.andreesperanca.deolhonobus.models.BusStop
import com.andreesperanca.deolhonobus.models.Place
import com.andreesperanca.deolhonobus.util.Resource
import com.andreesperanca.deolhonobus.util.apiCall
import com.andreesperanca.deolhonobus.util.dateStringFormatter
import com.google.android.gms.maps.model.LatLng
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.await
import java.time.Instant
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.util.*

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
                resultFetch.locations.let { it.forEach {
                    val hour = dateStringFormatter(it.hourLastLocation)
                    val newPlace = Place(title = hour, lng = LatLng(it.py,it.px))
                    resultMap.add(newPlace)
                } }
                Resource.Success(resultMap)
            }
        }
    }

}