package com.example.roomrepository.data

import com.example.roomrepository.dao.MedicineDao
import com.example.roomrepository.model.Medicine
import kotlinx.coroutines.flow.Flow

class OfflineMedicineRepository(private val medicineDao: MedicineDao): MedicineRepository {
    override fun getAllMedicineStream(): Flow<List<Medicine>> = medicineDao.getAllMedicine()

    override fun getMedicineStream(medicineId: Int): Flow<Medicine> = medicineDao.getMedicine(medicineId)

    override suspend fun insertMedicine(medicine: Medicine) = medicineDao.insert(medicine)

    override suspend fun updateMedicine(medicine: Medicine) = medicineDao.update(medicine)

    override suspend fun deleteMedicine(medicine: Medicine) = medicineDao.delete(medicine)
}