package com.example.roomrepository.data

import android.content.Context

interface AppContainer{
    val medicineRepository: MedicineRepository
}

class AppDataContainer(context: Context): AppContainer{
    override val medicineRepository: MedicineRepository by lazy {
        OfflineMedicineRepository(AppDatabase.getDatabase(context).medicineDao())
    }

}