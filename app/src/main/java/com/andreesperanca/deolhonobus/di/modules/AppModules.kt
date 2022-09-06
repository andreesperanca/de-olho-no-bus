package com.andreesperanca.deolhonobus.di.modules

import androidx.room.Room
import com.andreesperanca.deolhonobus.data.local.FavoriteRoomDataBase
import com.andreesperanca.deolhonobus.data.remote.AppRetrofit
import com.andreesperanca.deolhonobus.data.remote.RetrofitService
import com.andreesperanca.deolhonobus.repositories.SearchRepository
import com.andreesperanca.deolhonobus.ui.viewmodels.SearchViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.GlobalContext.get
import org.koin.dsl.module

val appModules = module {

    single<FavoriteRoomDataBase> {
        Room.databaseBuilder(
            get(),
            FavoriteRoomDataBase::class.java,
            "favorite-db"
        ).build()
    }

    single<RetrofitService> {
        AppRetrofit().webService
    }

    single<SearchRepository> {
        SearchRepository(service = get())
    }

    viewModel<SearchViewModel> {
        SearchViewModel(repository = get())
    }
}