package com.andreesperanca.deolhonobus.repositories

import com.andreesperanca.deolhonobus.data.remote.RetrofitService
import com.andreesperanca.deolhonobus.models.BusStopPrediction
import com.andreesperanca.deolhonobus.models.ForecastVehicleView
import com.andreesperanca.deolhonobus.util.Resource
import com.andreesperanca.deolhonobus.util.apiCall
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.await

class BusStopDetailsRepository(private val service: RetrofitService) {


    suspend fun getForecastWithBusStopCode (busStopCode: String) : Resource<List<ForecastVehicleView>> {
        return withContext(Dispatchers.IO) {
            apiCall {
                val resultFetch = service.getForecastWithBusStopCode(busStopCode).await()
                val resultMap = mutableListOf<ForecastVehicleView>()
                resultFetch.busStop.listOfLinesFound.map {
                    val forecastView = ForecastVehicleView(
                        sign = it.sign,
                        origin = it.origin,
                        lineWay = it.lineWay,
                        destination = it.destination,
                        vehicleList = it.vehicleList)
                    resultMap.add(forecastView)
                }
                Resource.Success(resultMap)
            }
        }
    }
}