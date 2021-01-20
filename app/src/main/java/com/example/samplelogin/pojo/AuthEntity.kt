package com.example.samplelogin.pojo

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class AuthEntity(@SerializedName("status") @Expose val status : Int?,
                      @SerializedName("message") @Expose val message : String?,
                      @SerializedName("errors") @Expose val errors : String?,
                      @SerializedName("auth_token") @Expose val auth_token : String?,
                      @SerializedName("name") @Expose val name : String?,
                      @SerializedName("profile_image") @Expose val profile_image : String?,
                      @SerializedName("percentage_filled") @Expose val percentage_filled : String?,
                      @SerializedName("user_tier") @Expose val user_tier : String?,
                      @SerializedName("notification") @Expose val notification : String?,
                      @SerializedName("referral_url") @Expose val referral_url : String?)
