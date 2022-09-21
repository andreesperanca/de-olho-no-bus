package com.andreesperanca.deolhonobus.di.modules

import com.andreesperanca.deolhonobus.application.Application
import com.andreesperanca.deolhonobus.data.remote.RetrofitService
import com.andreesperanca.deolhonobus.util.PROXY_URL_AIKO
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.internal.managers.ApplicationComponentManager
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule {

    @Singleton
    @Provides
    fun providesRetrofitService(): RetrofitService {

        val client by lazy {
            val interceptor = HttpLoggingInterceptor()
            interceptor.level = HttpLoggingInterceptor.Level.BODY
            OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build()
        }

        return Retrofit.Builder()
            .baseUrl(PROXY_URL_AIKO)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
            .create(RetrofitService::class.java)
    }
}