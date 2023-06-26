package com.example.countriesdemoapp.model


import com.google.gson.annotations.SerializedName

data class CountryItem(
    @SerializedName("name")
    val name: Name,
    @SerializedName("tld")
    val tld: List<String>,
    @SerializedName("cca2")
    val cca2: String,
    @SerializedName("ccn3")
    val ccn3: String,
    @SerializedName("cca3")
    val cca3: String,
    @SerializedName("cioc")
    val cioc: String,
    @SerializedName("independent")
    val independent: Boolean,
    @SerializedName("status")
    val status: String,
    @SerializedName("unMember")
    val unMember: Boolean,
    @SerializedName("capital")
    val capital: List<String>?,
    @SerializedName("altSpellings")
    val altSpellings: List<String>,
    @SerializedName("region")
    val region: String,
    @SerializedName("subregion")
    val subregion: String,
    @SerializedName("latlng")
    val latlng: List<Double>,
    @SerializedName("landlocked")
    val landlocked: Boolean,
    @SerializedName("borders")
    val borders: List<String>,
    @SerializedName("area")
    val area: Double,
    @SerializedName("flag")
    val flag: String,
    @SerializedName("population")
    val population: Int,
    @SerializedName("fifa")
    val fifa: String,
    @SerializedName("timezones")
    val timezones: List<String>,
    @SerializedName("continents")
    val continents: List<String>,
    @SerializedName("flags")
    val flags: Flags,
    @SerializedName("startOfWeek")
    val startOfWeek: String
)