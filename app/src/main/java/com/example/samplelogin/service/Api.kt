package com.example.samplelogin.service

import com.example.samplelogin.pojo.AuthEntity
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface Api {

    /*
    * Calling api method
    * */
    @POST("api/v1/user/sign_in")
    suspend fun getSignInUser(@Body
                              requestBody : RequestBody) : Response<AuthEntity>

}