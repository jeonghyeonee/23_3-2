package com.example.lottogenerator

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [LottoNumbersEntity::class], version = 1, exportSchema = false)
abstract class LottoNumbersDatabase : RoomDatabase() {
    abstract fun lottoNumbersDao(): LottoNumbersDao

    companion object {
        @Volatile
        private var INSTANCE: LottoNumbersDatabase? = null

        fun getDatabase(context: Context): LottoNumbersDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    LottoNumbersDatabase::class.java,
                    "lotto_numbers_database"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}

