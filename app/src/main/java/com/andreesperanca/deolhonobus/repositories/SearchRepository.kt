package com.andreesperanca.deolhonobus.repositories

import com.andreesperanca.deolhonobus.data.remote.RetrofitService
import com.andreesperanca.deolhonobus.models.BusLine
import com.andreesperanca.deolhonobus.models.BusStop
import com.andreesperanca.deolhonobus.repositories.SearchRepository.Authenticator.credential
import com.andreesperanca.deolhonobus.util.Resource
import com.andreesperanca.deolhonobus.util.apiCall
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.await
import javax.inject.Inject

class SearchRepository @Inject constructor(
    private val service: RetrofitService
) {

    object Authenticator {
        var credential = ""
    }

    suspend fun getAuthInApi(): Resource<Boolean> {
        return withContext(Dispatchers.IO) {
            apiCall {
                val auth = service.getAuthInAPI()
                val credential = auth.headers().get("Set-Cookie")
                credential?.let {
                    authentication(it)
                }
                Resource.Success(auth.body()!!)
            }
        }
    }

    private fun authentication(auth: String) {
        credential = auth
    }

    suspend fun getBusLines(searchTerms: String): Resource<List<BusLine>> {
        return withContext(Dispatchers.IO) {
            apiCall {
                val listBusLines =
                    service.getBusLinesWithNameOrNumber(credential, searchTerms).await()
                Resource.Success(listBusLines)
            }
        }
    }

    suspend fun getBusStopWithAddressOrName(searchTerms: String): Resource<List<BusStop>> {
        return withContext(Dispatchers.IO) {
            apiCall {
                val listBusStop =
                    service.getBusStopWithAddressOrName(credential, searchTerms).await()
                Resource.Success(listBusStop)
            }
        }
    }

    suspend fun getBusStopWithHallCode(hallCode: String): Resource<List<BusStop>> {
        return withContext(Dispatchers.IO) {
            apiCall {
                val listBusStop = service.getBusStopWithHallCode(credential, hallCode).await()
                Resource.Success(listBusStop)
            }
        }
    }

    suspend fun getBusStopWithBusLineCode(busLineCode: String): Resource<List<BusStop>> {
        return withContext(Dispatchers.IO) {
            apiCall {
                val fetchResult = service.getBusStopWithBusLineCode(credential, busLineCode).await()
                Resource.Success(fetchResult)
            }
        }
    }
}