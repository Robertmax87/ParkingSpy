package com.delicious.parkingspy.login.ui

import android.app.DatePickerDialog
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.delicious.parkingspy.login.viewmodels.SignUpViewModel
import java.time.LocalDate
import java.time.format.DateTimeFormatter


@Composable
fun SignUpUi(viewModel: SignUpViewModel = viewModel()) {
    val signUpState = viewModel.state.collectAsState().value
    val context = LocalContext.current
    val dateFormatter = DateTimeFormatter.ofPattern("MMM dd, yyyy")
    val datePickerDialog = DatePickerDialog(
        context,
        { _, year, month, dayOfMonth ->
            viewModel.updateDateOfBirth(LocalDate.of(year, month + 1, dayOfMonth))
        },
        signUpState.dateOfBirth.year,
        signUpState.dateOfBirth.monthValue - 1,
        signUpState.dateOfBirth.dayOfMonth
    )
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ){
        OutlinedTextField(
            value = signUpState.firstName,
            onValueChange = { viewModel.updateUserFirstName(it) },
            label = { Text("First Name") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = signUpState.lastName,
            onValueChange = { viewModel.updateUserLastName(it) },
            label = { Text("Last Name") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = signUpState.email,
            onValueChange = { viewModel.updateUserEmail(it) },
            label = { Text("Email") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        Button(
            onClick = { datePickerDialog.show() },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Select Date of Birth: ${signUpState.dateOfBirth.format(dateFormatter)}")
        }

    }
}