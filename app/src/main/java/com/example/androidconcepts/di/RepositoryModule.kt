package com.example.androidconcepts.di

import com.example.androidconcepts.repository.BmiRepository
import com.example.androidconcepts.retrofit.BmiRetrofit
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule  {
    //Step 1: Give provides for creating object of bmirepository
    @Provides
    @Singleton
    fun provideRepositoryObject(bmiRetrofit : BmiRetrofit ) : BmiRepository{
        return BmiRepository(bmiRetrofit)
    }
}