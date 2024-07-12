package com.example.roomrepository.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Medicine (
    @PrimaryKey(autoGenerate = true)
    val medicineId: Int = 0,
    val medicineName: String,
)