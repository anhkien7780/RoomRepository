package com.example.roomrepository.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.roomrepository.model.Medicine
import kotlinx.coroutines.flow.Flow

@Dao
interface MedicineDao {
    @Query("Select * from Medicine")
    fun getAllMedicine(): Flow<List<Medicine>>
    @Query("Select * from Medicine where medicineId = :medicineId")
    fun getMedicine(medicineId: Int): Flow<Medicine>
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(medicine: Medicine)
    @Update
    suspend fun update(medicine: Medicine)
    @Delete
    suspend fun delete(medicine: Medicine)
}