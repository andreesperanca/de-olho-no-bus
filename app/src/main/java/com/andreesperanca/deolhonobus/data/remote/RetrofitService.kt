package com.andreesperanca.deolhonobus.data.remote

import com.andreesperanca.deolhonobus.models.BusLine
import com.andreesperanca.deolhonobus.util.API_KEY
import com.andreesperanca.deolhonobus.util.BASE_URL
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface RetrofitService {

    @POST("Login/Autenticar")
    fun getAuthInAPI(@Query("token") token: String = API_KEY) : Call<String>

    @GET("Linha/Buscar")
    fun getBusLinesWithNameOrNumber(@Query("termosBusca") termosBusca: String): Call<List<BusLine>>

}