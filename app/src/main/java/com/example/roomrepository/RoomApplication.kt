package com.example.roomrepository

import android.app.Application
import com.example.roomrepository.data.AppContainer
import com.example.roomrepository.data.AppDataContainer

class RoomApplication: Application() {
    lateinit var container: AppContainer
    override fun onCreate() {
        super.onCreate()
        container = AppDataContainer(this)
    }
}