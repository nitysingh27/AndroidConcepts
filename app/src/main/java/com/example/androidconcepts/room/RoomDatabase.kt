package com.example.androidconcepts.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.androidconcepts.model.RoomEntity

@Database(
    entities = [RoomEntity::class],
    version = 1
)
abstract class RoomDataBase : RoomDatabase() {

    abstract fun bmiDao(): BmiDao
    abstract fun bmrDao() : BmrDao

    companion object {
        @Volatile
        private var INSTANCE: RoomDataBase? = null
        fun getDataBase(context: Context): RoomDataBase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    RoomDataBase::class.java,
                    "room_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}