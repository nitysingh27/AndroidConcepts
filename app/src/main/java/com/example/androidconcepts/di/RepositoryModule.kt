package com.example.androidconcepts.di

import com.example.androidconcepts.repository.BmiRepository
import com.example.androidconcepts.retrofit.RetrofitApiCall
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
    fun provideRepositoryObject(retrofitApiCall : RetrofitApiCall ) : BmiRepository{
        return BmiRepository(retrofitApiCall)
    }
}