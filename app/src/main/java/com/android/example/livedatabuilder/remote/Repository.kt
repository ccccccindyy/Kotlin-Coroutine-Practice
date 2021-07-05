package com.android.example.livedatabuilder.remote

import com.android.example.livedatabuilder.model.Cocktail
import kotlinx.coroutines.flow.Flow

interface Repository {
    suspend fun  fetchCocktails() : Flow<Resource<List<Cocktail>>>
}