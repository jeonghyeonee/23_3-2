package com.example.hw6.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

//define data structure
@Entity
data class LottoEntity (
    @PrimaryKey(autoGenerate = true) var id : Int? = null,
    @ColumnInfo(name="lotto1") val lotto1 : String,
    @ColumnInfo(name="lotto2") val lotto2 : String,
    @ColumnInfo(name="lotto3") val lotto3 : String,
    @ColumnInfo(name="lotto4") val lotto4 : String,
    @ColumnInfo(name="lotto5") val lotto5 : String,
    @ColumnInfo(name="lotto6") val lotto6 : String,
        )