package com.andreesperanca.deolhonobus.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.andreesperanca.deolhonobus.models.BusLine
import com.andreesperanca.deolhonobus.repositories.BusDetailsRepository
import kotlinx.coroutines.launch

class BusDetailsViewModel(private val repository: BusDetailsRepository) : ViewModel() {

    private val _isFavorite = MutableLiveData<Boolean>()
    private val isFavorite: LiveData<Boolean> = _isFavorite

    fun favoriteBusLine(busLine: BusLine) = viewModelScope.launch {
        repository.favoriteBusLine(busLine)
    }

    fun getFavoritesBusLine() = viewModelScope.launch {
        repository.getFavoritesBusLine()
    }
}