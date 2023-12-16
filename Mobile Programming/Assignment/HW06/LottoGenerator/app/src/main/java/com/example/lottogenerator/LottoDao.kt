package com.example.lottogenerator

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

//데이터 접근 객체에서 데이터로 무엇을 할지 정의
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