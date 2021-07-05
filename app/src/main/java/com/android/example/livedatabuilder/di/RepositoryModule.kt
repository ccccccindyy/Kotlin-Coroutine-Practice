package com.android.example.livedatabuilder.di

import com.android.example.livedatabuilder.CocktailService
import com.android.example.livedatabuilder.remote.CocktailRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {
    @Provides
    @Singleton
    fun provideRepository(service: CocktailService) : CocktailRepository {
        return CocktailRepository(service)
    }
}