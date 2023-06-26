package com.example.countriesdemoapp.api

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiConfiguration {

    private const val BASE_URL = "https://restcountries.com/v3.1/"
    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build()
    }

    val countryService: CountryService by lazy {
        retrofit.create(CountryService::class.java)
    }
}