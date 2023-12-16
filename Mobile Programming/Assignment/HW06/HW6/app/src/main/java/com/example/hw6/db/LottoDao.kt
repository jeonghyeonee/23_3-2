package com.example.hw6.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query


@Dao
interface LottoDao {
    // bring all data in database
    @Query("SELECT * FROM LottoEntity")
    fun getAll() : List<LottoEntity>
    // insert new data in database
    @Insert
    fun insertLotto(lotto: LottoEntity)
    // delete data in room database
    @Delete
    fun deleteLotto(lotto : LottoEntity)

}