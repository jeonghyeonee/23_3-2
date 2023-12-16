package com.example.hw6.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(LottoEntity::class),version=1) // list up all entity related to the DB


abstract class AppDatabase : RoomDatabase(){
    // abstract function which return DAO and no parameter
    abstract fun getLottoDao() : LottoDao


    companion object{
        val databaseName = "db_lotto"
        var appDatabase : AppDatabase?=null

        fun getInstance(context: Context) : AppDatabase?{
            // if appDatabase is null, create object
            if(appDatabase==null){
                appDatabase = Room.databaseBuilder(context,AppDatabase::class.java,databaseName).build()
            }
            // if not null, return existing object
            return appDatabase
        }
    }
}
