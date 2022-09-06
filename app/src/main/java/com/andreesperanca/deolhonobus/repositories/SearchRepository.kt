package com.andreesperanca.deolhonobus.repositories

import com.andreesperanca.deolhonobus.data.remote.RetrofitService
import com.andreesperanca.deolhonobus.models.BusLine
import com.andreesperanca.deolhonobus.util.Resource
import com.andreesperanca.deolhonobus.util.apiCall
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.await

class SearchRepository(private val service: RetrofitService) {

    suspend fun getAuthInApi(): Resource<String>{
        return withContext(Dispatchers.IO) {
            apiCall {
                val auth = service.getAuthInAPI().await()
                Resource.Success(auth)
            }
        }
    }


    suspend fun getBusLines(searchTerms: String): Resource<List<BusLine>> {
        return withContext(Dispatchers.IO) {
            apiCall {
                val listBusLines = service.getBusLinesWithNameOrNumber(searchTerms).await()
                Resource.Success(listBusLines)
            }
        }
    }


}