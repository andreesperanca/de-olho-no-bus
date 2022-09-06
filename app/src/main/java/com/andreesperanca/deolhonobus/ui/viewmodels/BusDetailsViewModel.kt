package com.andreesperanca.deolhonobus.ui.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.andreesperanca.deolhonobus.mockdata.MockData
import com.andreesperanca.deolhonobus.models.BusLine
import com.andreesperanca.deolhonobus.models.BusStop
import com.andreesperanca.deolhonobus.repositories.BusDetailsRepository
import com.andreesperanca.deolhonobus.util.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class BusDetailsViewModel(private val repository: BusDetailsRepository) : ViewModel() {

    private var _isFavorite = MutableLiveData<Boolean>()
    val isFavorite: LiveData<Boolean> = _isFavorite

    private var _searchBusStop = MutableLiveData<Resource<List<BusStop>>>()
    val searchBusStop: LiveData<Resource<List<BusStop>>> = _searchBusStop

    val listTest = MockData().listLines

    fun favoriteBusLine(busLine: BusLine) = viewModelScope.launch {
        listTest.map { it == busLine }.let {
            if (it.isEmpty()) {
                Log.i("teste", it.size.toString())
                listTest.add(busLine)
                Log.i("teste", it.size.toString())
                _isFavorite.value = true
            } else {
                Log.i("teste2", it.size.toString())
                listTest.remove(busLine)
                Log.i("teste2", listTest.size.toString())
                _isFavorite.value = false
            }
        }
    }

    fun getBusStopWithBusLineCode(busLineCode: String) {
        _searchBusStop.postValue(Resource.Loading())
        viewModelScope.launch (Dispatchers.Main) {
            val searchResult = repository.getBusStopWithBusLineCode(busLineCode)
            _searchBusStop.postValue(searchResult)
        }
    }
}