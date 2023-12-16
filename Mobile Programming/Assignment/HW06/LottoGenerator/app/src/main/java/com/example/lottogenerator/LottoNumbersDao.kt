package com.example.lottogenerator

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import kotlin.coroutines.Continuation


@Dao
interface LottoNumbersDao {

    @Query("SELECT * FROM lotto_numbers_table")
    fun getAllLottoNumbers(): LiveData<List<LottoNumbersEntity>>

    @Insert
    suspend fun insert(lottoNumbersEntity: LottoNumbersEntity)

    @Delete
    suspend fun delete(lottoNumbersEntity: LottoNumbersEntity)
}

