package com.android.example.livedatabuilder.di

import com.android.example.livedatabuilder.CocktailService
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class CocktailAPIModule {
    @Singleton
    @Provides
    fun provideRetrofitService(): CocktailService = Retrofit.Builder()
        .baseUrl(CocktailService.BASE_URL)
        .addConverterFactory(
            MoshiConverterFactory.create(
                Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
            )
        )
        .build()
        .create(CocktailService::class.java)
}