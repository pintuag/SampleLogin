package com.example.samplelogin.util

import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody
import org.json.JSONObject

object Constants {

    const val BASE_URL = "https://uat.modipara.com/"

    const val MOBILE = "mobile"

    fun getRequestBody(jsonObject : JSONObject) : RequestBody {
        return RequestBody.create("application/json; charset=utf-8".toMediaTypeOrNull(),
            jsonObject.toString())
    }

}