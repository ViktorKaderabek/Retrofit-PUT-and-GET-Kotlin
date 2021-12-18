package com.example.startovacky_app.Data.Api

import android.util.Log
import com.example.startovacky_app.Data.Modules.StartovackyDataClassItem
import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

interface ApiInterface {


    @GET("Startovacky")
     fun getData(): Call<List<StartovackyDataClassItem>>

    companion object {

        var BASE_URL = "https://61bc9a15d8542f0017824870.mockapi.io/"

        fun create(): ApiInterface {

            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
            return retrofit.create(ApiInterface::class.java)
        }
    }

    @FormUrlEncoded
    @POST("Startovacky")
     fun createData(
        @Field("name") name: String?
    ): Call<StartovackyDataClassItem>
}