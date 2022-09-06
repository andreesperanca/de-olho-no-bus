package com.andreesperanca.deolhonobus.repositories

import com.andreesperanca.deolhonobus.data.remote.RetrofitService
import com.andreesperanca.deolhonobus.models.BusStop
import com.andreesperanca.deolhonobus.util.Resource
import com.andreesperanca.deolhonobus.util.apiCall
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
}