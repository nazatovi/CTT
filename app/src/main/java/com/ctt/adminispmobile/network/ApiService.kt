package com.ctt.adminispmobile.network

import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST
import com.ctt.adminispmobile.model.SuscriptoresResponse
import com.ctt.adminispmobile.model.MonitoringResponse


interface ApiService {

    @GET("AdminISP/initAction")
    suspend fun initAction(): Response<ResponseBody>

    @FormUrlEncoded
    @POST("AdminISP/doLogin")
    suspend fun login(
        @Field("empSelected") empresa: String,
        @Field("username") username: String,
        @Field("password") password: String,
        @Field("INGRESAR") ingresar: String = "INGRESAR"
    ): Response<ResponseBody>

    @FormUrlEncoded
    @POST("AdminISP/sortRadAction")
    suspend fun buscarMonitoreo(

        @Field("columna")
        columna: String = "userName",

        @Field("direccion")
        direccion: String = "desc",

        @Field("actual")
        actual: Int = 1,

        @Field("pageSize")
        pageSize: Int = 10,

        @Field("start")
        start: Int = 0,

        @Field("reporte")
        reporte: Int = 0,

        @Field("campo")
        campo: String = "userName",

        @Field("intervalo")
        intervalo: String = "",

        @Field("filtros")
        filtros: String

    ): Response<MonitoringResponse>

    @FormUrlEncoded
    @POST("AdminISP/sortSuscriptoresAction")
    suspend fun buscarSuscriptores(

        @Field("columna")
        columna: String = "userName",

        @Field("direccion")
        direccion: String = "asc",

        @Field("actual")
        actual: Int = 0,

        @Field("pageSize")
        pageSize: Int = 10,

        @Field("start")
        start: Int = 0,

        @Field("searchUserName")
        usuario: String = "",

        @Field("searchPlan")
        plan: String = ""

    ): Response<SuscriptoresResponse>


}