package com.example.countriesdemoapp.repository

import android.app.Activity
import android.content.Context
import android.util.Log
import com.example.countriesdemoapp.api.ApiConfiguration
import com.example.countriesdemoapp.model.Countries
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

object CountriesRepository {

    suspend fun getAllCountries(context: Context): Countries? {
        return withContext(Dispatchers.IO) {
            try {
                getCountriesInLocal(context)?.takeIf { it.isNotEmpty() } ?: run {
                    val response = ApiConfiguration.countryService.getCountries()
                    if (response.isSuccessful) {
                        saveCountriesInLocal(context, Gson().toJson(response.body()))
                        response.body()
                    } else {
                        Countries()
                    }
                }
            } catch (e: Exception) {
                Log.e("EXCEPTION", "Exception getting data $e")
                null
            }
        }
    }

    private fun saveCountriesInLocal(context: Context, value: String) {
        context.getSharedPreferences("SP", Activity.MODE_PRIVATE).edit().apply {
                putString("countries_list", value)
                apply()
        }
    }

    private fun getCountriesInLocal(context: Context) : Countries? {
        return try {
            val json = context.getSharedPreferences("SP", Activity.MODE_PRIVATE)
                .getString("countries_list", "")!!
            Gson().fromJson(json, Countries::class.java)
        } catch (e: Exception) {
            Log.e("EXCEPTION", "Exception getting local data $e")
            null
        }
    }

}