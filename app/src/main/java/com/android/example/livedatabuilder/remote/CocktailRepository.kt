package com.android.example.livedatabuilder.remote

import com.android.example.livedatabuilder.CocktailService
import com.android.example.livedatabuilder.model.Cocktail
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class CocktailRepository(private val remoteService: CocktailService): Repository {
    override suspend fun fetchCocktails(): Flow<Resource<List<Cocktail>>> {
        return flow {
            val response = remoteService.getCocktails(null)
            response.body()?.let {
               emit(if(response.isSuccessful) Resource.Success(it.drinks) else Resource.Failed(response.message()))
            }

        }
    }

}