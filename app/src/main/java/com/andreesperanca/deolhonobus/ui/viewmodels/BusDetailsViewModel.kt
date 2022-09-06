package com.andreesperanca.deolhonobus.ui.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.andreesperanca.deolhonobus.mockdata.MockData
import com.andreesperanca.deolhonobus.models.BusLine
import com.andreesperanca.deolhonobus.repositories.BusDetailsRepository
import kotlinx.coroutines.launch

class BusDetailsViewModel(private val repository: BusDetailsRepository) : ViewModel() {

    private var _isFavorite = MutableLiveData<Boolean>()
    val isFavorite: LiveData<Boolean> = _isFavorite

    val getBusLine: LiveData<List<BusLine>>
        get() = repository.getFavoritesBusLine

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


}