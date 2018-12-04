package com.example.bruno.cocktailapp

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface CocktailService {


    @GET("filter.php")
    fun getAlcoholic(@Query("a") a: String = "Alcoholic"): Call<CocktailList>

    @GET("lookup.php")
    fun getById(@Query("i") i: String = ""): Call<CocktailList>

    @GET("random.php")
    fun getRandom(): Call<CocktailList>
}