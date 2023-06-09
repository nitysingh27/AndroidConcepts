package com.example.androidconcepts.di

import com.example.androidconcepts.repository.BfpRepository
import com.example.androidconcepts.repository.BmiRepository
import com.example.androidconcepts.repository.BmrRepository
import com.example.androidconcepts.repository.WhrRepository
import com.example.androidconcepts.retrofit.RetrofitApiCall
import com.example.androidconcepts.room.BfpDao
import com.example.androidconcepts.room.BmiDao
import com.example.androidconcepts.room.BmrDao
import com.example.androidconcepts.room.WhrDao
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
    fun provideRepositoryObject(retrofitApiCall : RetrofitApiCall, bmiDao: BmiDao ) : BmiRepository{
        return BmiRepository(retrofitApiCall, bmiDao)
    }
    @Provides
    @Singleton
    fun provideRepositoryObjectForBmr(retrofitApiCall : RetrofitApiCall, bmrDao: BmrDao ) : BmrRepository {
        return BmrRepository(retrofitApiCall, bmrDao)
    }
    @Provides
    @Singleton
    fun provideRepositoryObjectForBfp(retrofitApiCall : RetrofitApiCall, bfpDao: BfpDao) : BfpRepository {
        return BfpRepository(retrofitApiCall, bfpDao)
    }

    @Provides
    @Singleton
    fun provideRepositoryObjectForWhr(retrofitApiCall: RetrofitApiCall, whrDao: WhrDao) : WhrRepository {
        return WhrRepository(retrofitApiCall,whrDao)
    }
}