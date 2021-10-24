package com.example.recipeapp


import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST


interface APIInterface {
    @GET("/recipes/")
    fun getit(): Call<List<Receipes.datalist>>
    @POST("/recipes/")
    fun added(@Body ud:Receipes.datalist):Call<Receipes.datalist>

}