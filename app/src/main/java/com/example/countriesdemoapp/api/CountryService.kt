package com.example.countriesdemoapp.api

import com.example.countriesdemoapp.model.Countries
import retrofit2.Response
import retrofit2.http.GET

interface CountryService {

    @GET("all")
    suspend fun getCountries() : Response<Countries>

}