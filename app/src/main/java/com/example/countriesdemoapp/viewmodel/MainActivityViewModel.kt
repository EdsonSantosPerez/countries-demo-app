package com.example.countriesdemoapp.viewmodel

import android.content.Context
import androidx.lifecycle.*
import com.example.countriesdemoapp.model.Countries
import com.example.countriesdemoapp.repository.CountriesRepository
import kotlinx.coroutines.launch

class MainActivityViewModel : ViewModel() {

    private val _countries = MutableLiveData<Countries>()
    val countries: LiveData<Countries> get() = _countries

    fun getCountries(context: Context) {
        viewModelScope.launch {
            val countries = CountriesRepository.getAllCountries(context)
            if (countries.isNullOrEmpty()) {
                // Toast message
                _countries.value = Countries()
            } else {
                _countries.value = countries!!
            }
        }
    }
}