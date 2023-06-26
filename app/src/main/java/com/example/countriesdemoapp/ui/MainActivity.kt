package com.example.countriesdemoapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.countriesdemoapp.R
import com.example.countriesdemoapp.model.Countries
import com.example.countriesdemoapp.viewmodel.MainActivityViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val countriesRecyclerView = findViewById<RecyclerView>(R.id.countriesRecyclerView)
        countriesRecyclerView.layoutManager = LinearLayoutManager(this)
        viewModel = ViewModelProvider(this)[MainActivityViewModel::class.java]
        viewModel.countries.observe(this, Observer {
            val countries = it
            countriesRecyclerView.adapter = countries?.let { countriesChecked -> CountryAdapter(countriesChecked) } ?: CountryAdapter(Countries())
        })
        viewModel.getCountries(this)
    }

}