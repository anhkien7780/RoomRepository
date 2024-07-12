package com.example.roomrepository

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.roomrepository.data.AppDatabase
import com.example.roomrepository.ui.theme.home.HomeViewModel

object AppViewModelProvider {
    val Factory = viewModelFactory {
        initializer {
            HomeViewModel(roomApplication().container.medicineRepository)
        }
    }
}

fun CreationExtras.roomApplication(): RoomApplication =
    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as RoomApplication)