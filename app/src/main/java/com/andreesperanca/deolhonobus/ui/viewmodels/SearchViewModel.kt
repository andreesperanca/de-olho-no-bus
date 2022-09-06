package com.andreesperanca.deolhonobus.ui.viewmodels

import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.andreesperanca.deolhonobus.models.BusLine
import com.andreesperanca.deolhonobus.repositories.SearchRepository
import com.andreesperanca.deolhonobus.util.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SearchViewModel(private val repository: SearchRepository) : ViewModel() {

    private val _searchResult = MutableLiveData<Resource<List<BusLine>>>()
    val seachResult: LiveData<Resource<List<BusLine>>> = _searchResult

    private val _authResult = MutableLiveData<Resource<String>>()
    val authResult: LiveData<Resource<String>> = _authResult

    fun getAuthInApi() = viewModelScope.launch(Dispatchers.Main) {
        val resultAuth = repository.getAuthInApi()
        _authResult.postValue(resultAuth)
    }


    fun getBusLines(searchTerms: String) = viewModelScope.launch(Dispatchers.Main) {
        val fetchResult = repository.getBusLines(searchTerms)
        _searchResult.postValue(fetchResult)
    }

}