package com.example.prova1

import com.example.prova1.dominio.DadosGeograficos
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path


interface API {
    @GET("forecast/8eeafa93fa171bb970bfac9b03caa3a3/{latitude},{longitude}?exclude=minutely,hourly,daily,flags,alerts")
    fun consulta(@Path("latitude") latitude: Double,
                 @Path("longitude") longitude: Double): Call<DadosGeograficos?>?
}