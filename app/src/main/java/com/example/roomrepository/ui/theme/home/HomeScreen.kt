@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.roomrepository.ui.theme.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.roomrepository.AppViewModelProvider
import com.example.roomrepository.model.Medicine
import com.example.roomrepository.ui.theme.RoomRepositoryTheme


@Composable
fun HomeScreen(
    onNavToAddMedicineScreen: () -> Unit,
    //viewModel: HomeViewModel = viewModel(factory = AppViewModelProvider.Factory)

) {
    Scaffold(
        topBar = {
            AppCenterAlignedTopAppBar(title = "Home") {}
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = onNavToAddMedicineScreen,
                contentColor = MaterialTheme.colorScheme.secondary,
                containerColor = MaterialTheme.colorScheme.secondaryContainer
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Add",
                    tint = MaterialTheme.colorScheme.secondary
                )
            }
        }
    ) { paddingValues ->
        HomeBody(medicineList = listMedicine, contentPadding = paddingValues)
    }
}

@Composable
fun HomeBody(
    modifier: Modifier = Modifier,
    medicineList: List<Medicine> = listOf(),
    contentPadding: PaddingValues
) {
    when (medicineList.isEmpty()) {
        true -> {
            EmptyHomeBody(contentPadding = contentPadding)
        }

        false -> {
            LazyColumn(
                modifier = modifier
                    .padding(paddingValues = contentPadding)
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                items(listMedicine){
                    item -> MedicineItem(medicine = item)
                }
            }
        }
    }
}

@Composable
fun MedicineItem(medicine: Medicine) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Text(
            text = medicine.medicineId.toString(),
            style = MaterialTheme.typography.labelMedium,
            color = MaterialTheme.colorScheme.primary
        )
        Text(
            text = medicine.medicineName,
            style = MaterialTheme.typography.labelMedium,
            color = MaterialTheme.colorScheme.primary
        )
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    RoomRepositoryTheme {
        HomeScreen(onNavToAddMedicineScreen = {})
    }
}

@Composable
fun EmptyHomeBody(contentPadding: PaddingValues) {
    Column(
        modifier = Modifier
            .padding(contentPadding)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Bạn không có đơn thuốc nào hôm nay",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.primary
        )
    }
}

@Composable
fun AppCenterAlignedTopAppBar(title: String, onBackClick: () -> Unit) {
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = title,
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary
            )
        },
        navigationIcon = {
            IconButton(onClick = onBackClick) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "Back",
                    tint = MaterialTheme.colorScheme.primary
                )
            }
        }
    )
}

val listMedicine: List<Medicine> = listOf(
    Medicine(medicineId = 8159, medicineName = "Winston Richards"),
    Medicine(medicineId = 8159, medicineName = "Winston Richards"),
    Medicine(medicineId = 8159, medicineName = "Winston Richards"),
    Medicine(medicineId = 8159, medicineName = "Winston Richards"),
    Medicine(medicineId = 8159, medicineName = "Winston Richards")
)
