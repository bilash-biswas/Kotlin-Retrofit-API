package com.example.expenseapidevelopment

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ExpenseRetrofitClient {
    private const val BASE_URL = "http://192.168.0.103/expense/"
    val gson = GsonBuilder()
        .setLenient()
        .create()

    val expenseApi : ExpenseApi by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(ExpenseApi::class.java)
    }
}