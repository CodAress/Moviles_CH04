package com.upc.challenger_semana04_compose.utils


import com.upc.challenger_semana04_compose.utils.interfaces.PlaceHolder
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private const val BASE_URL = "https://dev.formandocodigo.com/ServicioTour/"
    private val gson: Gson = GsonBuilder().create()
    private val retrofit: Retrofit =  Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()

    val placeHolder: PlaceHolder = retrofit.create(PlaceHolder::class.java)
}