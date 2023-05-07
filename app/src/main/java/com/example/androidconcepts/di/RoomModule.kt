package com.example.androidconcepts.di

import android.content.Context
import androidx.room.Room
import com.example.androidconcepts.room.BmiDao
import com.example.androidconcepts.room.BmrDao
import com.example.androidconcepts.room.RoomDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    @Provides
    @Singleton
    fun provide(@ApplicationContext context: Context) : RoomDataBase {

        return Room.databaseBuilder(
            context, RoomDataBase::class.java, "room_database"
        )
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()
    }
    @Provides
    @Singleton
    fun provideBmiDao(db: RoomDataBase) : BmiDao {
       return db.bmiDao()
    }
    @Provides
    @Singleton
    fun provideBmrDao(db: RoomDataBase) : BmrDao {
        return db.bmrDao()
    }


}