package com.andreesperanca.deolhonobus.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.andreesperanca.deolhonobus.models.BusLine
import com.andreesperanca.deolhonobus.models.BusStop
import com.andreesperanca.deolhonobus.repositories.FavoriteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FavoriteViewModel @Inject constructor (
    private val repository: FavoriteRepository
    ): ViewModel() {

    val favoritesBusLines: LiveData<List<BusLine>>
        get() = repository.allFavoritesBusLines.asLiveData()

    val favoritesBusStops: LiveData<List<BusStop>>
        get() = repository.allFavoritesBusStops.asLiveData()
}