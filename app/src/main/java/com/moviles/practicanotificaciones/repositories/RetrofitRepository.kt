package com.moviles.practicanotificaciones.repositories

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitRepository {
    fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://chatapp.jmacboy.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}