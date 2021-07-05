package com.android.example.livedatabuilder

import com.android.example.livedatabuilder.model.Cocktail
import com.android.example.livedatabuilder.model.Drinks
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface CocktailService {
    @GET("/api/json/v1/1/search.php")
    suspend fun getCocktails(@Query("s")search:String?): Response<Drinks>

    companion object {
        const val BASE_URL = "https://www.thecocktaildb.com"
    }
}