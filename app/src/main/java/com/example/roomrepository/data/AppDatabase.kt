package com.example.roomrepository.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.roomrepository.dao.MedicineDao
import com.example.roomrepository.model.Medicine

@Database(entities = [Medicine::class], exportSchema = false, version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun medicineDao(): MedicineDao

    companion object {
        @Volatile
        private var Instance: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return Instance ?: synchronized(this) {
                Room.databaseBuilder(context, AppDatabase::class.java, "app_data").build()
            }
        }
    }
}