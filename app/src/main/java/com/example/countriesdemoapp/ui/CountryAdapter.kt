package com.example.countriesdemoapp.ui

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.countriesdemoapp.R
import com.example.countriesdemoapp.model.Countries
import com.squareup.picasso.Picasso

class CountryAdapter(private val countries: Countries) : RecyclerView.Adapter<CountryAdapter.ViewHolder>() {

    inner class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        val countryName: TextView = itemView.findViewById(R.id.countryName)
        val countryCapital: TextView = itemView.findViewById(R.id.countryCapital)
        val countryFlag: ImageView = itemView.findViewById(R.id.countryFlagImageView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_country, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return countries.size;
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.apply {
            countryName.text = countries[position].name.official
            countryCapital.text = "Capital: ${(countries[position].capital?.first() ?: "-")}"
            Picasso.get().load(countries[position].flags.png).into(countryFlag)
        }
    }


}