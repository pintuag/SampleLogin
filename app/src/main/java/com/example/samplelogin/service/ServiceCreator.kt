package com.example.samplelogin.service

import android.content.Context
import com.example.samplelogin.util.Constants
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory

object ServiceCreator {

    /**
     * This function will return the service class for ApiServiceCreator
     */
    private fun <S> createService(serviceClass : Class<S>) : S {
        val httpClientBuilder = OkHttpClient.Builder()
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        httpClientBuilder.addInterceptor(httpLoggingInterceptor)
        val okHttpClient = httpClientBuilder.build()
        val gson = GsonBuilder().setLenient().create()
        val retrofitBuilder = Retrofit.Builder().baseUrl(Constants.BASE_URL)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
        val retrofit = retrofitBuilder.client(okHttpClient).build()
        return retrofit.create(serviceClass)
    }


    fun createService() : Api {
        return createService<Api>(Api::class.java)
    }

}