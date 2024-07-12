package com.example.roomrepository.ui.theme.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.roomrepository.data.MedicineRepository
import com.example.roomrepository.model.Medicine
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

data class HomeUiState(val medicineList: List<Medicine> = listOf())

class HomeViewModel(medicineRepository: MedicineRepository): ViewModel(){
    val homeUiState: StateFlow<HomeUiState> =
        medicineRepository.getAllMedicineStream().map {
            HomeUiState(it)
        }.stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(TIMEOUT_MILLIS),
            initialValue = HomeUiState()
        )
    companion object{
        private const val TIMEOUT_MILLIS = 5_000L
    }
}