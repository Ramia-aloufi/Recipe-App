package com.example.recipeapp


import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST


interface APIInterface {
    @GET("/test/")
    fun getit(): Call<List<Receipes.datalist>>
    @POST("/test/")
    fun added(@Body userdat:Receipes.datalist):<List<Receipes.datalist>>

}