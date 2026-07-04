package com.ctt.adminispmobile.network

import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {

    @FormUrlEncoded
    @POST("AdminISP/doLogin")
    suspend fun login(

        @Field("empSelected")
        empresa: String,

        @Field("username")
        username: String,

        @Field("password")
        password: String,

        @Field("INGRESAR")
        ingresar: String = "INGRESAR"


    ): Response<ResponseBody>

    @GET("AdminISP/initAction")
    suspend fun initAction(): Response<ResponseBody>

}