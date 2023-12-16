package com.example.lottogenerator


import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "lotto_numbers_table")
data class LottoNumbersEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val num1: Int,
    val num2: Int,
    val num3: Int,
    val num4: Int,
    val num5: Int,
    val num6: Int
)

