package com.example.roomrepository.data

import com.example.roomrepository.model.Medicine
import kotlinx.coroutines.flow.Flow

interface MedicineRepository {
    fun getAllMedicineStream(): Flow<List<Medicine>>
    fun getMedicineStream(medicineId: Int): Flow<Medicine>
    suspend fun insertMedicine(medicine: Medicine)
    suspend fun updateMedicine(medicine: Medicine)
    suspend fun deleteMedicine(medicine: Medicine)
}